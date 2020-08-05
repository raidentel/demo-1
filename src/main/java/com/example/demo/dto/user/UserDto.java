package com.example.demo.dto.user;


import com.google.common.collect.Lists;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
    @NotNull
    @NotEmpty
    private String username;
    @NotNull
    @NotEmpty
    private String password;
    private String firstname;
    private String lastname;
    private String profile;
    private String gender;
    private String telephone;
    private List<RoleDto> roles = Lists.newArrayList(RoleDto.builder().id(1L).build());
    private boolean enabled = true;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;

}
