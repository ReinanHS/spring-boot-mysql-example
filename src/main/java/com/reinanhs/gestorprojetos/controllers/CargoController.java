package com.reinanhs.gestorprojetos.controllers;

import com.reinanhs.gestorprojetos.entitys.cargo.Cargo;
import com.reinanhs.gestorprojetos.repositorys.CargoRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/cargo")
public class CargoController {
    @Autowired
    protected CargoRepository repository;

    @GetMapping(path = "/")
    public ResponseEntity<List<Cargo>> index() {
        return ResponseEntity.status(HttpStatus.OK.value())
                .body(this.repository.findAll());
    }

    @PostMapping(path = "/")
    public Cargo store(@Valid @RequestBody Cargo cargo){
        return this.repository.save(cargo);
    }

    @GetMapping(path = "/{id}")
    public Cargo show(@PathVariable Long id){
        return this.repository.getById(id);
    }

    @PutMapping(path = "/{id}")
    public Cargo update(@Valid @RequestBody Cargo cargo, @PathVariable Long id){
        cargo.setId(id);
        return this.repository.save(cargo);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<JSONObject> destroy(@PathVariable Long id){
        this.repository.deleteById(id);

        JSONObject jsonObject = new JSONObject();
        jsonObject.appendField("mensagem", "O objeto foi deletado com sucesso");

        return ResponseEntity.status(HttpStatus.OK).body(jsonObject);
    }
}
