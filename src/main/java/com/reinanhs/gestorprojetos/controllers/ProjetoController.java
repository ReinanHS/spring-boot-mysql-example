package com.reinanhs.gestorprojetos.controllers;

import com.reinanhs.gestorprojetos.entitys.projeto.Projeto;
import com.reinanhs.gestorprojetos.repositorys.ProjetoRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/projeto")
public class ProjetoController {
    @Autowired
    protected ProjetoRepository repository;

    @GetMapping(path = "/")
    public ResponseEntity<List<Projeto>> index() {
        return ResponseEntity.status(HttpStatus.OK.value())
                .body(this.repository.findAll());
    }

    @PostMapping(path = "/")
    public Projeto store(@Valid @RequestBody Projeto projeto){
        return this.repository.save(projeto);
    }

    @GetMapping(path = "/{id}")
    public Projeto show(@PathVariable Long id){
        return this.repository.getById(id);
    }

    @PutMapping(path = "/{id}")
    public Projeto update(@Valid @RequestBody Projeto projeto, @PathVariable Long id){
        projeto.setId(id);
        return this.repository.save(projeto);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<JSONObject> destroy(@PathVariable Long id){
        this.repository.deleteById(id);

        JSONObject jsonObject = new JSONObject();
        jsonObject.appendField("mensagem", "O objeto foi deletado com sucesso");

        return ResponseEntity.status(HttpStatus.OK).body(jsonObject);
    }
}
