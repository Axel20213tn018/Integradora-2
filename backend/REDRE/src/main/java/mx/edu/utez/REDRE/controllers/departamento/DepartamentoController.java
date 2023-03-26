package mx.edu.utez.REDRE.controllers.departamento;

import mx.edu.utez.REDRE.models.departamento.Departamento;
import mx.edu.utez.REDRE.models.departamento.DepartamentoDto;
import mx.edu.utez.REDRE.services.departamento.DepartamentoService;
import mx.edu.utez.REDRE.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/redre/api/departamento/")
@CrossOrigin(origins = {"*"})
public class DepartamentoController {
    @Autowired
    private DepartamentoService service;

    @GetMapping("/getAll")
    public ResponseEntity<CustomResponse<List<Departamento>>>
    getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Departamento>>>
    getAllActive(){
        return new ResponseEntity<>(
                this.service.getAllActive(),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Departamento>> insert(
            @RequestBody DepartamentoDto departamento,
            @Valid BindingResult result
    ){
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                this.service.insert(departamento.getDepartamento()),
                HttpStatus.CREATED
        );
    }

    //Obtener un registro
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Departamento>> getOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<Departamento>> update(
            @RequestBody DepartamentoDto departamento,
            @Valid BindingResult result
    ){
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                this.service.update(departamento.getDepartamento()),
                HttpStatus.CREATED
        );
    }

    @PatchMapping("/")
    public ResponseEntity<CustomResponse<Boolean>> enableOrDisable(
            @Valid @RequestBody DepartamentoDto departamento
    ) {
        return new ResponseEntity<>(
                this.service.changeStatus(departamento.getDepartamento()),
                HttpStatus.OK
        );
    }
}
