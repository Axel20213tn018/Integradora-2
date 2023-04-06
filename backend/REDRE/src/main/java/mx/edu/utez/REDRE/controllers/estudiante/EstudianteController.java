package mx.edu.utez.REDRE.controllers.estudiante;

import mx.edu.utez.REDRE.models.estudiante.Estudiante;
import mx.edu.utez.REDRE.models.estudiante.EstudianteDto;
import mx.edu.utez.REDRE.services.estudiante.EstudianteService;
import mx.edu.utez.REDRE.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/redre/api/estudiante/")
@CrossOrigin(origins = {"*"})
public class EstudianteController {
    @Autowired
    private EstudianteService service;

    @GetMapping("/getAll")
    public ResponseEntity<CustomResponse<List<Estudiante>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Estudiante>>>
    getAllActive(){
        return new ResponseEntity<>(
                this.service.getAllActive(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Estudiante>> getOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Estudiante>> insert(
            @RequestBody EstudianteDto estudianteDto, @Valid BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                this.service.insert(estudianteDto.getEstudiante()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<Estudiante>> update(
            @RequestBody EstudianteDto estudianteDto, @Valid BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                this.service.update(estudianteDto.getEstudiante()),
                HttpStatus.CREATED
        );
    }

    @PatchMapping("/")
    public ResponseEntity<CustomResponse<Boolean>> enableOrDisable(
            @RequestBody EstudianteDto estudianteDto) {
        return new ResponseEntity<>(
                this.service.changeStatus(estudianteDto.getEstudiante()),
                HttpStatus.OK
        );
    }
}
