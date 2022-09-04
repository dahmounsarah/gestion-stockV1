package dz.elit.service.impl;

import dz.elit.dto.CommandeClientDto;
import dz.elit.dto.LigneCommandeClientDto;
import dz.elit.exception.EntityNotFoundException;
import dz.elit.exception.ErrorCodes;
import dz.elit.exception.InvalidEntityException;
import dz.elit.model.Article;
import dz.elit.model.Client;
import dz.elit.model.CommandeClient;
import dz.elit.model.LigneCommandeClient;
import dz.elit.repository.ArticleRepository;
import dz.elit.repository.ClientRepository;
import dz.elit.repository.CommandeClientRepository;
import dz.elit.repository.LigneCommandeClientRepository;
import dz.elit.service.CommandeClientService;
import dz.elit.validator.CommandeClientValidator;
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
public class CommandeClientServiceImpl implements CommandeClientService {

    private CommandeClientRepository commandeClientRepository;

    private LigneCommandeClientRepository ligneCommandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;


    @Autowired
    public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository,
                                     LigneCommandeClientRepository ligneCommandeClientRepository,
                                     ClientRepository clientRepository, ArticleRepository articleRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;

    }

    @Override
    public CommandeClientDto save(CommandeClientDto commandeClientDto) {

        List<String> errros = CommandeClientValidator.validate(commandeClientDto);
        if (!errros.isEmpty()) {
            log.error("Comande client n'est pas valide ");
            throw new InvalidEntityException("Commande client n'est pas valide ",
                    ErrorCodes.COMMANDE_CLEINT_NOT_VALID, errros);
        }
        // faire la validation metier
        Optional<Client> client = clientRepository.findById(commandeClientDto.getClientDto().getId());
        if (!client.isPresent()) {
            log.warn("Le cleint n'existe pas avec le id {}" + commandeClientDto.getClientDto().getId());
            throw new EntityNotFoundException("Le client n'existe pas ", ErrorCodes.CLIENT_NOT_FOUND);
        }
        List<String> articlesErrors = new ArrayList<>();
        if (commandeClientDto.getLigneCommandeClientDtos() != null)
            commandeClientDto.getLigneCommandeClientDtos().forEach(commandeClDto -> {
                        if (commandeClDto.getArticleDto() != null) {
                            Optional<Article> article = articleRepository.findById(commandeClDto.getArticleDto().getId());
                            if (!article.isPresent()) {
                                articlesErrors.add("L'article n'existe pas dans la base de données ");
                            }
                        } else {
                            articlesErrors.add("Impossible d'enregistre ligne ommande avec article vide ");

                        }
                    }
            );


        if (!articlesErrors.isEmpty()) {
            log.warn("L'article n'existe pas dans la  base de donées ");
            throw new InvalidEntityException("L'artcile n'exte pas", ErrorCodes.ARTICLE_NOT_FOUND, articlesErrors);
        }

        CommandeClient commandClientSaved = commandeClientRepository.save(CommandeClientDto.toEntity(commandeClientDto));
        if (commandeClientDto.getLigneCommandeClientDtos() != null) {
            commandeClientDto.getLigneCommandeClientDtos().forEach(lg -> {
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(lg);
                ligneCommandeClient.setCommandeClient(commandClientSaved);
                ligneCommandeClientRepository.save(ligneCommandeClient);

            });
        }


        return CommandeClientDto.fromEntity(commandClientSaved);
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        if (id == null) {
            log.error("Le id de client est NULL");
            return null;

        } else {
            return commandeClientRepository.findById(id).map(CommandeClientDto::fromEntity).
                    orElseThrow(() -> new EntityNotFoundException("Commande Client not Found", ErrorCodes.COMMANDE_CLEINT_NOT_FOUD)
                    );
        }


    }

    @Override
    public CommandeClientDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Le code de client est vide");
            return null;

        } else {
            // lorsque tu rajoute optionel tu peux utilise map
            return commandeClientRepository.findCommandeClientByCode(code).map(CommandeClientDto::fromEntity).
                    orElseThrow(() -> new EntityNotFoundException("Commande Client not Found", ErrorCodes.COMMANDE_CLEINT_NOT_FOUD)
                    );
        }
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream().map(CommandeClientDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer commandeClientDtoId) {
        if (commandeClientDtoId == null) {
            log.error("Le id de client est NULL");
        } else {
            commandeClientRepository.deleteById(commandeClientDtoId);
        }
    }

}

