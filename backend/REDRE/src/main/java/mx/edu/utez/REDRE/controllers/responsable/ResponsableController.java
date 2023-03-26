package mx.edu.utez.REDRE.controllers.responsable;

import mx.edu.utez.REDRE.models.departamento.Departamento;
import mx.edu.utez.REDRE.models.responsable.Responsable;
import mx.edu.utez.REDRE.models.responsable.ResponsableDto;
import mx.edu.utez.REDRE.services.responsable.ResponsableService;
import mx.edu.utez.REDRE.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/redre/api/responsable/")
@CrossOrigin(origins = {"*"})
public class ResponsableController {
    @Autowired
    private ResponsableService service;

    @GetMapping("/getAll")
    public ResponseEntity<CustomResponse<List<Responsable>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Responsable>>>
    getAllActive(){
        return new ResponseEntity<>(
                this.service.getAllActive(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Responsable>> getOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Responsable>> insert(
            @RequestBody ResponsableDto responsableDto, @Valid BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                this.service.insert(responsableDto.getResponsable()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<Responsable>> update(
            @RequestBody ResponsableDto responsableDto, @Valid BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                this.service.update(responsableDto.getResponsable()),
                HttpStatus.CREATED
        );
    }

    @PatchMapping("/")
    public ResponseEntity<CustomResponse<Boolean>> enableOrDisable(
            @RequestBody ResponsableDto responsableDto) {
        return new ResponseEntity<>(
                this.service.changeStatus(responsableDto.getResponsable()),
                HttpStatus.OK
        );
    }
}
