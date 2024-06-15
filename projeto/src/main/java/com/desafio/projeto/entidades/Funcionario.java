package com.desafio.projeto.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Funcionario extends Pessoa{
    private BigDecimal salario;
    private String funcao;
    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        
        super(nome, dataNascimento);
        this.setFuncao(funcao);
        this.setSalario(salario);
    }

}
