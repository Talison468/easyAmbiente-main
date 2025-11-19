package com.example.demo.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recurso")
@EqualsAndHashCode(callSuper = false)
public class Recurso extends BaseEntity {
    
    @Column(nullable = false, unique = true)
    private String nome;
}
