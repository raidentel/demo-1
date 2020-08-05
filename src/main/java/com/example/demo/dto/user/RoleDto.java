package com.example.demo.dto.user;

import lombok.*;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDto {

    private Long id;
    private String label;
}
