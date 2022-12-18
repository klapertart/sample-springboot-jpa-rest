package klapertart.lab.jpa;

import klapertart.lab.jpa.entity.Materi;
import klapertart.lab.jpa.repository.MateriRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author kurakuraninja
 * @since 18/12/22
 */

@SpringBootTest(classes = BelajarJavaJpaApplication.class)
public class MateriRepositoryTest {

    @Autowired
    MateriRepository materiRepository;


    @Test
    void testSave() {
        Materi materi = new Materi();
        materi.setNama("Belajar PHP Dasar");
        materi.setKode("002");

        materiRepository.save(materi);

        Materi result = materiRepository.findByKode("002");
        Assertions.assertNotNull(result);

        Assertions.assertEquals("Belajar PHP Dasar",result.getNama());
    }
}
