package dz.elit.service.impl;

import dz.elit.dto.ArticleDto;
import dz.elit.dto.LigneVenteDto;
import dz.elit.dto.VenteDto;
import dz.elit.exception.EntityNotFoundException;
import dz.elit.exception.ErrorCodes;
import dz.elit.exception.InvalidEntityException;
import dz.elit.model.Article;
import dz.elit.model.LigneVente;
import dz.elit.model.Vente;
import dz.elit.repository.ArticleRepository;
import dz.elit.repository.LigneVenteRepository;
import dz.elit.repository.VentesRepository;
import dz.elit.service.VentesService;
import dz.elit.validator.VenteValidator;
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
public class VentesServiceImpl implements VentesService {

    private ArticleRepository articleRepository;
    private VentesRepository ventesRepository;

    private LigneVenteRepository ligneVenteRepository;

    @Autowired
    public VentesServiceImpl(ArticleRepository articleRepository, VentesRepository ventesRepository,
                             LigneVenteRepository ligneVenteRepository) {
        this.articleRepository = articleRepository;
        this.ventesRepository = ventesRepository;
        this.ligneVenteRepository = ligneVenteRepository;

    }

    @Override
    public VenteDto save(VenteDto venteDto) {
        //  on vas verify que l'article n'est pas null a ce niveau de validation
        List<String> errors = VenteValidator.validate(venteDto);
        if (!errors.isEmpty()) {
            log.error("la vente n'est valide ");
            throw new InvalidEntityException("la vente n'est valide ", ErrorCodes.VENTE_INVALID, errors);
        }
        List<String> articlesErrors = new ArrayList<>();

        venteDto.getLigneVenteDtos().forEach(ligneVenteDto ->
        {
            Optional<Article> article = articleRepository.findById(ligneVenteDto.getArticleDto().getId());
            if (!article.isPresent()) {
                articlesErrors.add("l'article ne doit pas etre vide ");
            }
        });
        if (!articlesErrors.isEmpty()) {
            log.error("one or more article does exists  ");
            throw new InvalidEntityException("Un ou plusieur article n'existe pas de bbd ", ErrorCodes.VENTE_INVALID, errors);
        }
        Vente venteSaved = ventesRepository.save(VenteDto.toEntity(venteDto));
        venteDto.getLigneVenteDtos().forEach(ligneVenteDto ->
        {
            LigneVente ligneVente = LigneVenteDto.toEntity(ligneVenteDto);
            ligneVenteRepository.save(ligneVente);

        });

        return VenteDto.fromEntity(venteSaved);
    }


    @Override
    public VenteDto findById(Integer id) {
        if (id == null) {
            log.error("Error id est null");
            return null;
        } else {

            return ventesRepository.findById(id).map(VenteDto::fromEntity).orElseThrow(() ->
                    new EntityNotFoundException("Aucun vente n'est trouve ave" +
                            "le Id" + id, ErrorCodes.VENTE_NOT_FOUND));
//
//        }
        }
    }

    @Override
    public VenteDto findByCodeArticle(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Le code est  id est vide");
            return null;
        } else {
            return ventesRepository.findVenteByCode(code).map(VenteDto::fromEntity).orElseThrow(() ->
                    new EntityNotFoundException("Aucun vente n'est trouve avev" +
                            "le code" + code, ErrorCodes.VENTE_NOT_FOUND));
        }
    }

    @Override
    public List<VenteDto> findAll() {
        return ventesRepository.findAll().stream().map(VenteDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer venteDtoId) {
        if (venteDtoId == null)
            log.error("l'id est null");
        else
            ventesRepository.deleteById(venteDtoId);
    }
}

