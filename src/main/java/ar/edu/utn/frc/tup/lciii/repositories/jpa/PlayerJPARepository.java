package ar.edu.utn.frc.tup.lciii.repositories.jpa;

import ar.edu.utn.frc.tup.lciii.entities.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerJPARepository extends JpaRepository<PlayerEntity,Long> {
    //despues de esto tengo que modificar el serviceimpl
    Optional<PlayerEntity>findByUserNameOrEmail(String username,String email);//buscar un pEntity por nombre o email y pasamos los parametros
}
