package com.example.demo.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.DTO.RecursoDTO;
import com.example.demo.Service.RecursoService;

@RestController
@RequestMapping("/recursos")
public class RecursoController extends BaseController<RecursoDTO> {

    protected RecursoController(RecursoService service){
        super(service);
    }
    @GetMapping
    public List<RecursoDTO> list(){
        return service.list();
    }

    @PutMapping("/{id}")
    public RecursoDTO update(
        @PathVariable("id")Long id,
        @RequestBody RecursoDTO recursoCreateDTO){
            return service.update(id,recursoCreateDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")Long id){
        service.delete(id);
    }
}
