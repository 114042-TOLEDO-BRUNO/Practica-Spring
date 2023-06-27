package ar.edu.utn.frc.tup.lciii.repositories.jpa;

import ar.edu.utn.frc.tup.lciii.entities.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerJPARepository extends JpaRepository<PlayerEntity,Long> {//ESTA CLASE REPRESENTA EL ACCESO AL DATAACCESS DE PLAYERS EN LA BASE DE DATOS
    //despues de esto tengo que modificar el serviceimpl
    Optional<PlayerEntity>findByUserNameOrEmail(String username,String email);//buscar un pEntity por nombre o email y pasamos los parametros

    Optional<PlayerEntity> findByUserNameAndPassword(String userName, String password);

    Optional<PlayerEntity> findByEmailAndPassword(String email, String password);
    @Query("Select p from PlayerEntity p "+"where (p.userName like :identity or p.email like :identity)and p.password like:password")
    Optional<PlayerEntity>findByUsernameOrEmailAndPassword(@Param("identity")String identity,@Param("password")String password);

}
