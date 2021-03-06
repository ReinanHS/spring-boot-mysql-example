package com.reinanhs.gestorprojetos.controllers;

import com.reinanhs.gestorprojetos.entitys.cliente.Cliente;
import com.reinanhs.gestorprojetos.repositorys.ClienteRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/cliente")
public class ClienteCntroller {
    @Autowired
    protected ClienteRepository clienteRepository;

    @GetMapping(path = "/")
    public ResponseEntity<List<Cliente>> index() {
        return ResponseEntity.status(HttpStatus.OK.value())
                .body(this.clienteRepository.findAll());
    }

    @PostMapping(path = "/")
    public Cliente store(@Valid @RequestBody Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    @GetMapping(path = "/{id}")
    public Cliente show(@PathVariable Long id){
        return this.clienteRepository.getById(id);
    }

    @PutMapping(path = "/{id}")
    public Cliente update(@Valid @RequestBody Cliente cliente, @PathVariable Long id){
        cliente.setId(id);
        return this.clienteRepository.save(cliente);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<JSONObject> destroy(@PathVariable Long id){
        this.clienteRepository.deleteById(id);

        JSONObject jsonObject = new JSONObject();
        jsonObject.appendField("mensagem", "O objeto foi deletado com sucesso");

        return ResponseEntity.status(HttpStatus.OK).body(jsonObject);
    }
}
