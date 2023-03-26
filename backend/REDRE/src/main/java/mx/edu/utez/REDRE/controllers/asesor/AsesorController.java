package mx.edu.utez.REDRE.controllers.asesor;

import mx.edu.utez.REDRE.models.asesor.Asesor;
import mx.edu.utez.REDRE.models.asesor.AsesorDto;
import mx.edu.utez.REDRE.services.asesor.AsesorService;
import mx.edu.utez.REDRE.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/redre/api/asesor/")
@CrossOrigin(origins = {"*"})
public class AsesorController {
    @Autowired
    private AsesorService service;

    @GetMapping("/getAll")
    public ResponseEntity<CustomResponse<List<Asesor>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Asesor>>>
    getAllActive(){
        return new ResponseEntity<>(
                this.service.getAllActive(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Asesor>> getOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Asesor>> insert(
            @RequestBody AsesorDto asesorDto, @Valid BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                this.service.insert(asesorDto.getAsesor()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<Asesor>> update(
            @RequestBody AsesorDto asesorDtoDto, @Valid BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                this.service.update(asesorDtoDto.getAsesor()),
                HttpStatus.CREATED
        );
    }

    @PatchMapping("/")
    public ResponseEntity<CustomResponse<Boolean>> enableOrDisable(
            @RequestBody AsesorDto asesorDto) {
        return new ResponseEntity<>(
                this.service.changeStatus(asesorDto.getAsesor()),
                HttpStatus.OK
        );
    }
}
