package com.example.demo.model.authority;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column
    private Long id;
    @Column
    private String label;
}
