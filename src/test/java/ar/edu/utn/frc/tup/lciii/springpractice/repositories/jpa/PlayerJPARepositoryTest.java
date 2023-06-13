package ar.edu.utn.frc.tup.lciii.springpractice.repositories.jpa;


import ar.edu.utn.frc.tup.lciii.entities.PlayerEntity;
import ar.edu.utn.frc.tup.lciii.repositories.jpa.PlayerJPARepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PlayerJPARepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private PlayerJPARepository playerJPARepository;
    @Test
    public void findByUserNameOrEmailTest(){
        PlayerEntity playerEntity=new PlayerEntity();
        playerEntity.setEmail("email@email.com");
        playerEntity.setUserName("brunoToledo");
        playerEntity.setPassword("Password3#");

        entityManager.persist(playerEntity);
        entityManager.flush();

        Optional<PlayerEntity>result=playerJPARepository.findByUserNameOrEmail("brunotoledo","email@email.com");
        assertEquals("brunoToledo",result.get().getUserName());
    }

}
