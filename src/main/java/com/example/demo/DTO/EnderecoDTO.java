package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EnderecoDTO {

    private String cep;
    private String logradouro;
    private String bairro;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String localidade;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String uf;

    @JsonProperty("cidade")
    public String getCidade(){
        return localidade;
    }

    @JsonProperty("estado")
    public String getEstado(){
        return uf;
    }
    @JsonProperty("endereco")
    public String getEnderecoCompleto(){
        return logradouro + ", " + bairro + ", " + localidade + " - " + uf;
    }
}
