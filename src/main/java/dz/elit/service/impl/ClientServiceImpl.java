package dz.elit.service.impl;

import dz.elit.dto.ClientDto;
import dz.elit.exception.ErrorCodes;
import dz.elit.exception.InvalidEntityException;
import dz.elit.repository.ClientRepository;
import dz.elit.service.ClientService;
import dz.elit.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("clientServiceImpl")
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired// une injection par contructeur
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto  save(ClientDto clientDto) {
        List<String> errors = ClientValidator.validate(clientDto);
        if(!errors.isEmpty()){
            log.error("client not valide {}" + clientDto);
            throw new InvalidEntityException("Invalide article", ErrorCodes.ARTICLE_INVALID, errors);
        }else{
            // return clientRepository.save(ClientDto.toEntity(clientDto));
            return null;
        }
    }



    @Override
    public ClientDto findById(Integer id) {
        if(id==null){
            log.error("le id client " + id);
            throw new InvalidEntityException("Invalide client", ErrorCodes.CLIENT_NOT_FOUND);
        }else{
            ClientDto clientDto=ClientDto.fromEntity(clientRepository.findById(id).get());
            return clientDto;
        }
    }

    @Override
    public ClientDto findByNom(String nom) {
        return null;
    }

    @Override
    public List<ClientDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer clientDtoId) {

    }
}
