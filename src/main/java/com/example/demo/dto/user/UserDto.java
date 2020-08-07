package com.example.demo.dto.user;


import com.example.demo.validator.EmailValid;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.Lists;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @NotNull
    @NotEmpty
    @EmailValid
    private String username;
    @NotNull
    @NotEmpty
    private String password;

    //    @NotNull
//    @Size(min = 4, message = "Must be at least 4 characters")
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
