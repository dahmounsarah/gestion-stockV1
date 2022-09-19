package dz.elit.dto;

import dz.elit.model.Address;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AddressDto {

    private String addressed1;


    private String addressed2;


    private String ville;


    private String codePostal;

    private String pays;

    public static AddressDto fromEntity(Address address) {
        if (address == null) return null;
        else
            return AddressDto.builder().
                    addressed1(address.getAddressed1()).
                    addressed2(address.getAddressed2()).
                    ville(address.getVille()).
                    codePostal(address.getCodePostal()).
                    pays(address.getPays()).
                    build();
    }

    public static Address toEntity(AddressDto addressDto) {
        if (addressDto == null) return null;
        else
            return Address.builder().
                    addressed1(addressDto.getAddressed1()).
                    addressed2(addressDto.getAddressed2()).
                    ville(addressDto.getVille()).
                    codePostal(addressDto.getCodePostal()).
                    pays(addressDto.getPays()).
                    build();
    }
}
