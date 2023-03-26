package mx.edu.utez.REDRE.services.responsable;

import mx.edu.utez.REDRE.models.departamento.Departamento;
import mx.edu.utez.REDRE.models.responsable.Responsable;
import mx.edu.utez.REDRE.models.responsable.ResponsableRepository;
import mx.edu.utez.REDRE.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ResponsableService {
    @Autowired
    private ResponsableRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Responsable>> getAll(){
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "Ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<List<Responsable>> getAllActive(){
        return new CustomResponse<>(
                this.repository.findAllByStatus(true),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Responsable> getOne(Long id){
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false,
                200,
                "Ok"
        );
    }

    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<Responsable> insert(Responsable responsable){
        if(this.repository.existsByCorreo(responsable.getCorreo()))
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "El Correo asignado a este responsable ya se encuentra registrado"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(responsable),
                false,
                200,
                "Responsable registrado correctamente"
        );
    }

    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<Responsable> update(Responsable responsable){
        if(!this.repository.existsById(responsable.getId()))
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "El responsable no existe"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(responsable),
                false,
                200,
                "Responsable actualizado correctamente"
        );
    }

    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<Boolean> changeStatus(Responsable responsable){
        if(!this.repository.existsById(responsable.getId())){
            return new CustomResponse<>(
                    false,
                    true,
                    400,
                    "El responsable no existe"
            );
        }
        return new CustomResponse<>(
                this.repository.updateStatusById(
                        responsable.getStatus(), responsable.getId()
                ) == 1,
                false,
                200,
                "Responsable actualizado correctamente"
        );
    }
}
