package com.reinanhs.gestorprojetos.controllers;

import com.reinanhs.gestorprojetos.entitys.funcionario.Funcionario;
import com.reinanhs.gestorprojetos.repositorys.FuncionarioRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/funcionario")
public class FuncionarioController {
    @Autowired
    protected FuncionarioRepository repository;

    @GetMapping(path = "/")
    public ResponseEntity<List<Funcionario>> index() {
        return ResponseEntity.status(HttpStatus.OK.value())
                .body(this.repository.findAll());
    }

    @PostMapping(path = "/")
    public Funcionario store(@Valid @RequestBody Funcionario funcionario){
        return this.repository.save(funcionario);
    }

    @GetMapping(path = "/{id}")
    public Funcionario show(@PathVariable Long id){
        return this.repository.getById(id);
    }

    @PutMapping(path = "/{id}")
    public Funcionario update(@Valid @RequestBody Funcionario funcionario, @PathVariable Long id){
        funcionario.setId(id);
        return this.repository.save(funcionario);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<JSONObject> destroy(@PathVariable Long id){
        this.repository.deleteById(id);

        JSONObject jsonObject = new JSONObject();
        jsonObject.appendField("mensagem", "O objeto foi deletado com sucesso");

        return ResponseEntity.status(HttpStatus.OK).body(jsonObject);
    }
}
