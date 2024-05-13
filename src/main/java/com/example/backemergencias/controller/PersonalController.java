package com.example.backemergencias.controller;

import com.example.backemergencias.entity.Personal;
import com.example.backemergencias.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personal")
public class PersonalController {

    @Autowired
    private PersonalRepository personalRepository;

    @GetMapping
    public List<Personal> getAllPersonal() {
        return personalRepository.findAll();
    }

    @PostMapping
    public Personal createPersonal(@RequestBody Personal personal) {
        return personalRepository.save(personal);
    }

    @GetMapping("/{cedula}")
    public Personal getPersonalByCedula(@PathVariable String cedula) {
        return personalRepository.findById(cedula).orElse(null);
    }

    @PutMapping("/{cedula}")
    public Personal updatePersonal(@PathVariable String cedula, @RequestBody Personal personal) {
        personal.setCedula(cedula);
        return personalRepository.save(personal);
    }

    @DeleteMapping("/{cedula}")
    public void deletePersonal(@PathVariable String cedula) {
        personalRepository.deleteById(cedula);
    }
}
