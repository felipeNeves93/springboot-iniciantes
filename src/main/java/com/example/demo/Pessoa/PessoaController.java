package com.example.demo.Pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class PessoaController {

    @Autowired
    PessoaDao pessoaDao;

    @GetMapping(value = "/pessoas")
    public List<Pessoa> findAll(){
        return pessoaDao.findAll();
    }

    @GetMapping(value = "/pessoas/{id}")
    public Resource<Pessoa> findById(@PathVariable Integer id){
        Pessoa pessoaPesquisada = pessoaDao.findOne(id);

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());

        Resource<Pessoa> resource = new Resource<>(pessoaPesquisada);
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @PostMapping(value = "/pessoas")
    public Resource<Pessoa> addUser(@RequestBody Pessoa pessoa){
        Pessoa pessoaSalva = pessoaDao.save(pessoa);

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());

        Resource<Pessoa> resource = new Resource<>(pessoaSalva);
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @DeleteMapping(value = "/pessoas/{id}")
    public Resource<Pessoa> deleteUser(@PathVariable Integer id){
        Pessoa pessoaDeletada = pessoaDao.delete(id);

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());

        Resource<Pessoa> resource = new Resource<>(pessoaDeletada);
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }
}
