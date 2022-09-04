package dz.elit.service.impl;

import dz.elit.dto.CommandeClientDto;
import dz.elit.dto.CommandeFournisseurDto;
import dz.elit.dto.LigneCommandeClientDto;
import dz.elit.dto.LigneCommandeFournisseurDto;
import dz.elit.exception.EntityNotFoundException;
import dz.elit.exception.ErrorCodes;
import dz.elit.exception.InvalidEntityException;
import dz.elit.model.*;
import dz.elit.repository.*;
import dz.elit.service.CommandeFournisseurService;
import dz.elit.validator.CommandeClientValidator;
import dz.elit.validator.CommandeFournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {

    private CommandeFournisseurRepository commandeFournisseurRepository ;

    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;
    private FournisseurRepository fournisseurRepository;
    private ArticleRepository articleRepository;




    @Autowired
    public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository,
                                          LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository,
                                          FournisseurRepository fournisseurRepository, ArticleRepository articleRepository) {
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.articleRepository = articleRepository;

    }
    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto) {
        List<String> errros = CommandeFournisseurValidator.validate(commandeFournisseurDto);
        if (!errros.isEmpty()) {
            log.error("Comande fournisseur n'est pas valide ");
            throw new InvalidEntityException("Commande fournisseur n'est pas valide ",
                    ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID, errros);
        }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(commandeFournisseurDto.getFournieeurDto().getId());
        if (!fournisseur.isPresent()) {
            log.warn("Le fournisseur n'existe pas avec le id {}" + commandeFournisseurDto.getFournieeurDto().getId());
            throw new EntityNotFoundException("Le client n'existe pas ", ErrorCodes.CLIENT_NOT_FOUND);
        }
        List<String> articlesErrors = new ArrayList<>();
        if (commandeFournisseurDto.getLigneCommandeFournisseurDtos() != null)
            commandeFournisseurDto.getLigneCommandeFournisseurDtos().forEach(commandefourDto -> {
                        if (commandefourDto.getArticleDto() != null) {
                            Optional<Article> article = articleRepository.findById(commandefourDto.getArticleDto().getId());
                            if (!article.isPresent()) {
                                articlesErrors.add("L'article n'existe pas dans la base de données ");
                            }
                        } else {
                            articlesErrors.add("Impossible d'enregistre ligne ommande avec article vide ");

                        }
                    }
            );
        if (!articlesErrors.isEmpty()) {
            log.warn("L'article n'existe pas dans la  base de données ");
            throw new InvalidEntityException("L'artcile n'exte pas", ErrorCodes.ARTICLE_NOT_FOUND, articlesErrors);
        }

        CommandeFounisseur commandeFounisseurSaved = commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(commandeFournisseurDto));
        if (commandeFournisseurDto.getLigneCommandeFournisseurDtos() != null) {
            commandeFournisseurDto.getLigneCommandeFournisseurDtos().forEach(lg -> {
                LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(lg);
                ligneCommandeFournisseur.setCommandeFounisseurs(commandeFounisseurSaved);
                ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);

            });
        }


        return CommandeFournisseurDto.fromEntity(commandeFounisseurSaved);

    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        if (id == null) {
            log.error("Le id de client est NULL");
            return null;

        } else {
            return commandeFournisseurRepository.findById(id).map(CommandeFournisseurDto::fromEntity).
                    orElseThrow(() -> new EntityNotFoundException("Commande fournisseur not Found", ErrorCodes.COMMANDE_CLEINT_NOT_FOUD)
                    );
        }
    }

    @Override
    public CommandeFournisseurDto findByCodeArticle(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Le code de client est vide");
            return null;

        } else {
            // lorsque tu rajoute optionel tu peux utilise map
            return commandeFournisseurRepository.findCommandeFournisseurByCode(code).map(CommandeFournisseurDto::fromEntity).
                    orElseThrow(() -> new EntityNotFoundException("Commande fournisseur not Found", ErrorCodes.COMMANDE_CLEINT_NOT_FOUD)
                    );
        }
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurRepository.findAll().stream().map(CommandeFournisseurDto::fromEntity).collect(Collectors.toList());

    }

    @Override
    public void delete(Integer commandeFournisseurDtoId) {
        if (commandeFournisseurDtoId == null) {
            log.error("Le id de client est NULL");
        } else {
            commandeFournisseurRepository.deleteById(commandeFournisseurDtoId);
        }

    }
}
