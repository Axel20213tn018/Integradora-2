package mx.edu.utez.REDRE.services.estudiante;

import mx.edu.utez.REDRE.models.estudiante.Estudiante;
import mx.edu.utez.REDRE.models.estudiante.EstudianteRepository;
import mx.edu.utez.REDRE.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class EstudianteService {
    @Autowired
    EstudianteRepository repository;

    @Transactional
    public CustomResponse<List<Estudiante>> getAll(){
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "Ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<List<Estudiante>> getAllActive(){
        return new CustomResponse<>(
                this.repository.findAllByStatus(true),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Estudiante> getOne(Long id){
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false,
                200,
                "Ok"
        );
    }

    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<Estudiante> insert(Estudiante estudiante){
        if(this.repository.existsByCorreo(estudiante.getCorreo()))
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "El Correo asignado a este asesor ya se encuentra registrado"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(estudiante),
                false,
                200,
                "Asesor registrado correctamente"
        );
    }

    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<Estudiante> update(Estudiante estudiante){
        if(!this.repository.existsById(estudiante.getId()))
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "El asesor no existe"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(estudiante),
                false,
                200,
                "Asesor actualizado correctamente"
        );
    }

    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<Boolean> changeStatus(Estudiante estudiante){
        if(!this.repository.existsById(estudiante.getId())){
            return new CustomResponse<>(
                    false,
                    true,
                    400,
                    "El asesor no existe"
            );
        }
        return new CustomResponse<>(
                this.repository.updateStatusById(
                        estudiante.getStatus(), estudiante.getId()
                ) == 1,
                false,
                200,
                "Asesor actualizado correctamente"
        );
    }
}
