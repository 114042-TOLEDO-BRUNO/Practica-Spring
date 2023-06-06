package ar.edu.utn.frc.tup.lciii.springpractice.repositories.jpa;

import ar.edu.utn.frc.tup.lciii.entities.PlayerEntity;
import ar.edu.utn.frc.tup.lciii.repositories.jpa.PlayerJPARepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@DataJpaTest
public class PlayerJPARepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private PlayerJPARepository playerJPARepository;
    @Test
    public void findByUserNameOrEmailTest(){
        PlayerEntity playerEntity=new PlayerEntity();
        playerEntity.setEmail("vrunotoledo@gmail.com");
        playerEntity.setUserName("Bruno3");
        playerEntity.setPassword("Password03#");

        entityManager.persist(playerEntity);
        entityManager.flush();

        Optional<PlayerEntity> result=playerJPARepository.findByUserNameOrEmail("Bruno3","vrunotoledo@gmail.com");
        assertEquals("Bruno3",result.get().getUserName());
    }
}
