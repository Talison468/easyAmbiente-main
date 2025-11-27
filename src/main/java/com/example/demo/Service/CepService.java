package com.example.demo.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.DTO.EnderecoDTO;

@Service
public class CepService {

    private WebClient wc = WebClient.builder().baseUrl("https://viacep.com.br/ws/").build();

    public EnderecoDTO buscarPorCep(String cep){
        return wc.get().uri(cep + "/json/").retrieve().bodyToMono(EnderecoDTO.class).block();
    }
}
 