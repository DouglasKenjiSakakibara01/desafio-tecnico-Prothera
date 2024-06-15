package com.desafio.projeto.controle;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.projeto.dto.SalarioDTO;
import com.desafio.projeto.dto.SalarioMinDTO;
import com.desafio.projeto.entidades.Funcionario;
import com.desafio.projeto.servicos.FuncionarioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/funcionarios")

public class FuncionarioController {
    
    @Autowired
    private FuncionarioService service;

    @PostMapping("/insere")
    public Funcionario insereFuncionario(@RequestBody Funcionario funcionario){
        return this.service.inserirFuncionario(funcionario);
    }
    @GetMapping("/listaF")
    public List<Funcionario> listaFuncionarios(){
        return this.service.listaFuncionarios();
    }
    @GetMapping("/aumento")
    public List<Funcionario> aumentoSalario(){
        return this.service.aumentoSalario();
    }
    @GetMapping("/funcionarioMaisVelho")
    public List<Funcionario> buscaFuncionarioMaisAntigo(){
        return this.service.funcionarioMaisVelho();
    }
    @GetMapping("/totalSalario")
    public BigDecimal totalSalarios(){
        return this.service.totalSalarios();
    }
    @GetMapping("/listaS")
    public List<SalarioDTO> listaSalarios(){
        return this.service.listaSalarios();
    }
    @DeleteMapping("/remove/{nome}")
    public List <Funcionario> removeFuncionario(@PathVariable String nome){
        return this.service.removerFuncionario(nome);
    }
    @GetMapping("/listaOrdem")
    public List<Funcionario> listaEmOrdemAlf(){
        return this.service.listaOrdAlf();
    }
    
    @GetMapping("/busca/{mes}")
    public List <Funcionario> buscaFuncionarioMes(@PathVariable int mes){
        return this.service.buscaFuncionario(mes);
    }
    @GetMapping("/agrupaFuncionarios")
    public Map<String, List<Funcionario>> agrupaFuncionarios(){
        return this.service.agruparPorFuncao();
    }
    
    @GetMapping("/listaQntSM")
    public List<SalarioMinDTO> calculaQntSalariosMin(){
        return this.service.calcularQntSalariosMin();
    }
    

}
