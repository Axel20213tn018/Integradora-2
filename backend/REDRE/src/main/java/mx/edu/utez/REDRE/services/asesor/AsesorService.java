package mx.edu.utez.REDRE.services.asesor;

import mx.edu.utez.REDRE.models.asesor.Asesor;
import mx.edu.utez.REDRE.models.asesor.AsesorDto;
import mx.edu.utez.REDRE.models.asesor.AsesorRepository;
import mx.edu.utez.REDRE.models.responsable.Responsable;
import mx.edu.utez.REDRE.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class AsesorService {
    @Autowired
    private AsesorRepository repository;

    @Transactional
    public CustomResponse<List<Asesor>> getAll(){
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "Ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<List<Asesor>> getAllActive(){
        return new CustomResponse<>(
                this.repository.findAllByStatus(true),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Asesor> getOne(Long id){
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false,
                200,
                "Ok"
        );
    }

    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<Asesor> insert(Asesor asesor){
        if(this.repository.existsByCorreo(asesor.getCorreo()))
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "El Correo asignado a este asesor ya se encuentra registrado"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(asesor),
                false,
                200,
                "Asesor registrado correctamente"
        );
    }

    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<Asesor> update(Asesor asesor){
        if(!this.repository.existsById(asesor.getId()))
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "El asesor no existe"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(asesor),
                false,
                200,
                "Asesor actualizado correctamente"
        );
    }

    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<Boolean> changeStatus(Asesor asesor){
        if(!this.repository.existsById(asesor.getId())){
            return new CustomResponse<>(
                    false,
                    true,
                    400,
                    "El asesor no existe"
            );
        }
        return new CustomResponse<>(
                this.repository.updateStatusById(
                        asesor.getStatus(), asesor.getId()
                ) == 1,
                false,
                200,
                "Asesor actualizado correctamente"
        );
    }
}
