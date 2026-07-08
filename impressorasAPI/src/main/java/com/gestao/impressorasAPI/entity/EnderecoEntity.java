package com.gestao.impressorasAPI.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Entity
@Table(name = "Endereço")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoEntity {
    private String rua;
    private String bairro;
    private Integer numero;
}
