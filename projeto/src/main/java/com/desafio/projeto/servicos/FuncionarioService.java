package com.desafio.projeto.servicos;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.desafio.projeto.dto.SalarioDTO;
import com.desafio.projeto.dto.SalarioMinDTO;
import com.desafio.projeto.entidades.Funcionario;
import com.desafio.projeto.repositorios.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario inserirFuncionario(Funcionario funcionario){
        return this.repository.save(funcionario);
    }
    public List<Funcionario> listaFuncionarios(){
        return this.repository.findAll();
        
    }
    public List<Funcionario> aumentoSalario(){
        List<Funcionario> funcionarios = this.repository.findAll();
        for(Funcionario f:funcionarios){
            BigDecimal value = f.getSalario().multiply(BigDecimal.valueOf(1.1));
            f.setSalario(value);

        }

        return this.repository.saveAll(funcionarios);

    }
    public List<Funcionario> funcionarioMaisVelho(){
        return this.repository.findFuncionarioComMaiorIdade();
    }

    public BigDecimal totalSalarios(){
        return this.repository.calcularTotalSalarios();
    }
    public List<SalarioDTO> listaSalarios(){
        return this.repository.findAllSalarios();
    }
    
    public List<SalarioMinDTO> calcularQntSalariosMin(){
        return this.repository.calcularSalariosMinimos();
    }
    
    
    public List <Funcionario> removerFuncionario(String nome){
        return this.repository.deleteByNome(nome);
    }

    
    public Map<String, List<Funcionario>> agruparPorFuncao() {
        List<Funcionario> funcionarios = this.listaFuncionarios();
        return funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public List<Funcionario> listaOrdAlf(){
        return this.repository.findByOrder();
    }
    
    public List <Funcionario> buscaFuncionario(int mes){
        return this.repository.findByDataNascimentoMonthIn(mes);
    }
    

    
}
