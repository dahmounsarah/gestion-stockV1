package dz.elit.service.impl;

import dz.elit.dto.EntrepriseDto;
import dz.elit.dto.UtilisateurDto;
import dz.elit.exception.EntityNotFoundException;
import dz.elit.exception.ErrorCodes;
import dz.elit.exception.InvalidEntityException;
import dz.elit.repository.EntrepriseRepository;
import dz.elit.repository.RolesRepository;
import dz.elit.repository.UtilisateurRepository;
import dz.elit.service.EntrepriseService;
import dz.elit.service.UtilisateurService;
import dz.elit.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;
    private RolesRepository rolesRepository;
    private UtilisateurService utilisateurService;



    @Autowired// une injection par contructeur
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository,
                                 UtilisateurRepository utilisateurRepository,
                                 UtilisateurService utilisateurService,
                                 RolesRepository roleRepository) {
        this.entrepriseRepository = entrepriseRepository;
        this.utilisateurService = utilisateurService;
        this.rolesRepository = roleRepository;
    }


    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        List<String> errors = EntrepriseValidator.validate(entrepriseDto);
        if (!errors.isEmpty()) {
            log.error("L'entreprise n'est pas valide " + entrepriseDto);
            throw new InvalidEntityException("L'entreprise n'est pas valide", ErrorCodes.ENTREPRISE_INVALIDE, errors);
        }
        //Sauvgarder l'entreprise
        EntrepriseDto savedEntreprise = EntrepriseDto.fromEntity(entrepriseRepository.save(EntrepriseDto.toEntity(entrepriseDto)));
        //Créer un utilisateur a partir de l'entreprise
        UtilisateurDto utilisateur = fromEntreprise(savedEntreprise);
        //Sauvgarder l'entreprise
        UtilisateurDto savedUser = utilisateurService.save(utilisateur);
        //Ajouter un role ADMIN pour l'utlisateur
//        RoleDto roleDto = RoleDto.builder()
//                .roleName("ADMIN")
//                .utilisateurDto(savedUser)
//                .build();
//        //Sauvgarder le role
//        rolesRepository.save(RoleDto.toEntity(roleDto));
        return savedEntreprise;
    }

    private UtilisateurDto fromEntreprise(EntrepriseDto savedEntreprise) {
        return UtilisateurDto.builder()
                //  .addressDto(savedEntreprise.get())
                .nom(savedEntreprise.getNom())
                // .prenom(savedEntreprise.getNom())
                //  .dateNaissance(Instant.parse("1993-12-01T18:35:24.00Z"))
                .email(savedEntreprise.getEmail())
                .password(generateRandomMotPasse())
                //      .dateNaissance(Instant.now())
                //  .photo(savedEntreprise.getPhoto())
                .entrepriseDto(savedEntreprise)
                .build();
    }

    private String generateRandomMotPasse() {
        return "som3R@ndomP@a$$word";
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if (id == null) {
            log.error("Id entreprise null");
            return null;
        } else {
            EntrepriseDto entrepriseDto = EntrepriseDto.fromEntity(entrepriseRepository.findById(id).get());
            return Optional.of(entrepriseDto).orElseThrow(() -> new EntityNotFoundException
                    ("Aucune catégorie trouve avec le id" + id, ErrorCodes.ENTREPRISE_NOT_foud));

        }
    }

    @Override
    public EntrepriseDto findByNom(String nom) {
        if (!StringUtils.hasLength(nom)) {
            log.error("Error nom est vide");
            return null;
        } else {
            EntrepriseDto entrepriseDto = EntrepriseDto.fromEntity(entrepriseRepository.findByNom(nom));
            return Optional.of(entrepriseDto).orElseThrow(() -> new EntityNotFoundException("Aucune entreprise trouve avec le code" + nom, ErrorCodes.ENTREPRISE_NOT_foud));
        }
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream().map(EntrepriseDto::fromEntity).collect(Collectors.toList());

    }

    @Override
    public void delete(Integer entrepriseDtoId) {
        if (entrepriseDtoId == null) {
            log.error("Error id est null");
            return;
        } else {
            entrepriseRepository.deleteById(entrepriseDtoId);

        }

    }
}
