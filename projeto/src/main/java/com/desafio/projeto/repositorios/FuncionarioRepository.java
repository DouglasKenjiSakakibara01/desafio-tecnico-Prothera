package com.desafio.projeto.repositorios;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.desafio.projeto.dto.SalarioDTO;
import com.desafio.projeto.dto.SalarioMinDTO;
import com.desafio.projeto.entidades.Funcionario;
import com.desafio.projeto.entidades.Pessoa;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    
    // Encontra todos os salários de cada funcionário
    @Query("SELECT new com.desafio.projeto.dto.SalarioDTO(f.id,f.salario) FROM Funcionario f")
    List<SalarioDTO> findAllSalarios();
    
    // Gera a soma dos salários de todos os funcionários
    @Query("SELECT SUM(f.salario) FROM Funcionario f")
    BigDecimal calcularTotalSalarios();
    
    // Encontra o funcionário com a maior idade
    @Query("SELECT f FROM Funcionario f ORDER BY f.dataNascimento ASC")
    List<Funcionario>findFuncionarioComMaiorIdade();
    
    // Encontra todos os funcionários ordenados por ordem alfabética
    @Query("SELECT f From Funcionario f ORDER By f.nome")
    List<Funcionario> findByOrder();
    
    // Retorna quantos salários mínimos cada funcionario ganha
    @Query("SELECT new com.desafio.projeto.dto.SalarioMinDTO(f.id, f.salario/1112 ) FROM Funcionario f")
    List<SalarioMinDTO> calcularSalariosMinimos();
    
    // Encontra os funcionarios de acordo com o mes de nascimento
    @Query("SELECT f FROM Funcionario f WHERE MONTH(f.dataNascimento) = :mes")
    List<Funcionario> findByDataNascimentoMonthIn(@Param("mes") int mes);
    
    
    // Deleta um funcionario pelo nome 
    List <Funcionario> deleteByNome(String nome);
}
