package dz.elit.service.impl;

import dz.elit.dto.EntrepriseDto;
import dz.elit.exception.EntityNotFoundException;
import dz.elit.exception.ErrorCodes;
import dz.elit.exception.InvalidEntityException;
import dz.elit.repository.EntrepriseRepository;
import dz.elit.service.EntrepriseService;
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

    @Autowired// une injection par contructeur
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }


    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        List<String> errors = EntrepriseValidator.validate(entrepriseDto);
        if (!errors.isEmpty()) {
            log.error("entreprise not valide {}" + entrepriseDto);
            throw new InvalidEntityException("Invalide entreprise", ErrorCodes.ENTREPRISE_INVALIDE, errors);
        } else {
            return EntrepriseDto.fromEntity(entrepriseRepository.save(EntrepriseDto.toEntity(entrepriseDto)));
        }

    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if (id == null) {
            log.error("Id entreprise null");
            return null;
        } else {
            EntrepriseDto entrepriseDto= EntrepriseDto.fromEntity(entrepriseRepository.findById(id).get());
            return Optional.of(entrepriseDto).orElseThrow(()->new EntityNotFoundException
                    ("Aucune catégorie trouve avec le id"+id,ErrorCodes.ENTREPRISE_NOT_foud));

        }
    }

    @Override
    public EntrepriseDto findByNom(String nom) {
        if (!StringUtils.hasLength(nom)) {
            log.error("Error nom est vide");
            return null;}
        else{
            EntrepriseDto entrepriseDto=EntrepriseDto.fromEntity(entrepriseRepository.findByNom(nom));
            return Optional.of(entrepriseDto).orElseThrow(()->new EntityNotFoundException  ("Aucune entreprise trouve avec le code"+nom,ErrorCodes.ENTREPRISE_NOT_foud));
        }
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream().map(EntrepriseDto::fromEntity).collect(Collectors.toList());

    }

    @Override
    public void delete(Integer entrepriseDtoId) {
        if (entrepriseDtoId== null) {
            log.error("Error id est null");
            return ;
        } else {
            entrepriseRepository.deleteById(entrepriseDtoId);

        }

    }
}
