package com.example.demo.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.DTO.AmbienteDTO;
import com.example.demo.Service.AmbienteService;

@RestController
@RequestMapping("/ambientes")
public class AmbienteController extends BaseController<AmbienteDTO> {

    protected AmbienteController(AmbienteService service){
        super(service);
    }
    @GetMapping("/ambientes/recursos/{ambienteId}/{recursoId}")
    public List<AmbienteDTO> ambientesPorRecurso(
        @PathVariable("ambienteId") Long ambienteId,
        @PathVariable("recursoId") Long recursoId) {
    return service.listarAmbienteRecurso(ambienteId, recursoId);
    }

    @GetMapping("/recursos/listagem/{recursoId}")
    public List<AmbienteDTO> listarPorRecurso(
        @PathVariable("recursoId") Long recursoId) {
            return service.listarPorRecurso(recursoId);
    }
}
