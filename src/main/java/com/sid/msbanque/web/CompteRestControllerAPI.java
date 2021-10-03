package com.sid.msbanque.web;

import com.sid.msbanque.entities.Compte;
import com.sid.msbanque.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.*;

//@RestController
@RequestMapping("/banque")
public class CompteRestControllerAPI {
    @Autowired
    private CompteRepository compteRepository;
   @GetMapping(path = "/comptes",produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public List<Compte> compteList(){
    return compteRepository.findAll();

    }
    @GetMapping(path = "/comptes/{id}",produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    public Compte getOne(@PathVariable(value = "id") Long id) {
        return compteRepository.findById(id).get();
    }
    @PostMapping(path = "/comptes")
    public Compte save(@RequestBody Compte compte) {
        return compteRepository.save(compte);
    }
    @PutMapping(path = "/comptes/{id}")

    public Compte update(@RequestBody Compte compte,@PathVariable(value = "id") Long id) {
       compte.setId(id);
        return compteRepository.save(compte);
    }
    @DeleteMapping(value = "/comptes/{id}",produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})

    public void delete(@PathVariable(value = "id") Long id) {
        compteRepository.deleteById(id);
    }
}
