package mx.edu.utez.REDRE.controllers.departamento;

import mx.edu.utez.REDRE.models.departamento.Departamento;
import mx.edu.utez.REDRE.models.departamento.DepartamentoDto;
import mx.edu.utez.REDRE.services.departamento.DepartamentoService;
import mx.edu.utez.REDRE.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("redre/api/departamento")
@CrossOrigin(origins = {"*"})
public class DepartamentoController {
    @Autowired
    private DepartamentoService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Departamento>>>
    getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Departamento>> insert(
            @Valid @RequestBody DepartamentoDto departamento
    ){
        return new ResponseEntity<>(
                this.service.insert(departamento.getDepartamento()),
                HttpStatus.CREATED
        );
    }
}
