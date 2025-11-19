package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.DTO.RecursoDTO;
import com.example.demo.Entity.Recurso;
import com.example.demo.Repository.RecursoRepository;

@Service
public class RecursoService extends BaseService<Recurso, RecursoDTO>{
    private RecursoRepository repository;

    protected RecursoService(RecursoRepository repository){
        super(repository);
        this.repository = repository;
    }
    public List<RecursoDTO> findAll(){
        List<Recurso> recursos = repository.findAll();
        List<RecursoDTO> recursosDTO = new ArrayList<>();
        for(Recurso recurso : recursos){
            recursosDTO.add(toDto(recurso));
        }
        return recursosDTO;
    }
    public RecursoDTO save(RecursoDTO recursoDTO){
        Recurso recurso = toEntity(recursoDTO);
        recurso = repository.save(recurso);
        return toDto(recurso);
    }
    public RecursoDTO update(Long id, RecursoDTO recursoDTO){
        Recurso recurso = toEntity(recursoDTO);
        recurso.setId(id);
        recurso = repository.save(recurso);
        return toDto(recurso);
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }    
}
