package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.DTO.EnderecoDTO;
import com.example.demo.Service.CepService;

@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    private CepService service;

    @GetMapping("/{cep}")
    public EnderecoDTO enderecar(@PathVariable String cep){
        return service.buscarPorCep(cep);
    }
}
