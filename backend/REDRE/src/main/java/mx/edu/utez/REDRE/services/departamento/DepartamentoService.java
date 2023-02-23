package mx.edu.utez.REDRE.services.departamento;

import mx.edu.utez.REDRE.models.departamento.Departamento;
import mx.edu.utez.REDRE.models.departamento.DepartamentoRepository;
import mx.edu.utez.REDRE.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Departamento> insert(Departamento departamento){
        Optional<Departamento> exist = this.repository.findByEmail(departamento.getCorreo());
        if (exist.isPresent()){
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

    // TODO: investigar como hacer correctamente el update
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Departamento> update(Departamento departamento){
        Optional<Departamento> exist = this.repository.findById(departamento.getId());
        if (exist.isEmpty()){
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
                "Departamento Registrado correctamente"
        );
    }
}
