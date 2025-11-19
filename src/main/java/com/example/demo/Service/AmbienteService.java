package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.DTO.AmbienteDTO;
import com.example.demo.Entity.Ambiente;
import com.example.demo.Repository.AmbienteRepository;

@Service
public class AmbienteService extends BaseService<Ambiente, AmbienteDTO>{

    private AmbienteRepository repository;

    protected AmbienteService(AmbienteRepository repository){
        super(repository);
        this.repository = repository;
    }
    
    public void delete(Long id){
        boolean reservado = repository.temReservaFutura(id);

        if(reservado){
            throw new IllegalStateException("Ambiente possui reservas futuras e não pode ser excluído.");
        }

        super.delete(id);        
    }
    public List<AmbienteDTO> listarAmbienteRecursos(Long ambienteId, Long recursosId){
        List<Ambiente> ambientes = repository.findByAmbienteRecurso(ambienteId, recursosId);
        List<AmbienteDTO> dtos = new ArrayList<>();
        for(Ambiente ambiente : ambientes){
            dtos.add(super.toDto(ambiente));
        }
        return dtos;
    }
    public List<AmbienteDTO> listarPorRecursos(Long recursoId){
        List<Ambiente> ambientes = repository.findByRecursoId(recursoId);
        List<AmbienteDTO> dtos = new ArrayList<>();
        for(Ambiente ambiente : ambientes){
            dtos.add(super.toDto(ambiente));
        }
        return dtos;
    }
}
