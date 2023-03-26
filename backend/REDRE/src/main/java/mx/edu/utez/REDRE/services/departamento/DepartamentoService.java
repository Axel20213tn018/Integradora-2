package mx.edu.utez.REDRE.services.departamento;

import mx.edu.utez.REDRE.models.departamento.Departamento;
import mx.edu.utez.REDRE.models.departamento.DepartamentoRepository;
import mx.edu.utez.REDRE.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Departamento>> getAll(){
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "Ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<List<Departamento>> getAllActive(){
        return new CustomResponse<>(
                this.repository.findAllByStatus(true),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Departamento> getOne(Long id){
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false,
                200,
                "OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Departamento> insert(Departamento departamento){
        if (this.repository.existsByCorreo(departamento.getCorreo())){
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "Este departamento ya se encuentra regitrado"
            );
        }
        return new CustomResponse<>(
                this.repository.saveAndFlush(departamento),
                false,
                200,
                "Departamento Registrado correctamente"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Departamento> update(Departamento departamento){
        if (!this.repository.existsById(departamento.getId())){
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "Este departamento no existe"
            );
        }
        return new CustomResponse<>(
                this.repository.saveAndFlush(departamento),
                false,
                200,
                "Departamento Actualizado correctamente"
        );
    }

    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<Boolean> changeStatus(Departamento departamento){
        if(!this.repository.existsById(departamento.getId())){
            return new CustomResponse<>(
                    null, true, 400, "El Departamento no existe"
            );
        }
        return new CustomResponse<>(
                this.repository.updateStatusById(departamento.getStatus(), departamento.getId()) == 1,
                false,
                200,
                "Se ha cambiado el status del departamento"
        );
    }
}
