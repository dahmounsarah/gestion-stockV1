package dz.elit.dto;

import dz.elit.model.Role;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RoleDto {

    private Integer id;
    private String roleName;
    private UtilisateurDto utilisateurDto;

    public static RoleDto fromEntity(Role role) {
        if (role == null) {
            return null;
        } else {
            return RoleDto.builder().id(role.getId())
                    .roleName(role.getRoleName())
                    .utilisateurDto(UtilisateurDto.fromEntity(role.getUtilisateur()))
                    .build();

        }
    }

    public static Role toEntity(RoleDto roleDto) {
        if (roleDto == null) {
            return null;
        } else {
            Role role = new Role();
            // car le id est dans la super clasee
            role.setId(roleDto.getId());
            role.setRoleName(roleDto.getRoleName());
            role.setUtilisateur(UtilisateurDto.toEntity(roleDto.getUtilisateurDto()));
            return role;
        }
    }


}
