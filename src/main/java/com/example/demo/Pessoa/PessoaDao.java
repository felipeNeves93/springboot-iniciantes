package com.example.demo.Pessoa;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PessoaDao {

    private static List<Pessoa> pessoas = new ArrayList<>(Arrays.asList(
            new Pessoa(1,"Pessoa", "Um"),
            new Pessoa(2,"Pessoa", "Dois"),
            new Pessoa(3,"Pessoa", "Tres"),
            new Pessoa(4,"Pessoa", "Quatro")
    ));

    private static Integer generateId = 5;

    public List<Pessoa> findAll(){
        return this.pessoas;
    }

    public Pessoa save(Pessoa pessoa){
        pessoa.setId(++ generateId);
        pessoas.add((pessoa));

        return pessoa;
    }

    public Pessoa findOne(Integer id){
        return pessoas.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Pessoa delete(Integer id){
        Pessoa usuarioDeletado = pessoas.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);

        pessoas.removeIf(p -> p.getId().equals(id));

        return usuarioDeletado;
    }

    public Pessoa update(Pessoa pessoa){
        pessoas.forEach(p -> {
            if(p.getId().equals(pessoa.getId())){
                p = pessoa;
            }
        });

        return pessoa;
    }
}
