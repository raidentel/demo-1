package com.example.demo.dto.user;

import lombok.*;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String label;
}
