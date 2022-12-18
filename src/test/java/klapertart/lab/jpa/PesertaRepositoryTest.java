package klapertart.lab.jpa;

import klapertart.lab.jpa.entity.Peserta;
import klapertart.lab.jpa.service.PesertaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Date;

/**
 * @author kurakuraninja
 * @since 18/12/22
 */

@SpringBootTest(classes = BelajarJavaJpaApplication.class)
public class PesertaRepositoryTest {

    @Autowired
    private PesertaService pesertaService;

    @Test
    @Order(1)
    void testSave() {

        Peserta peserta = new Peserta();
        peserta.setNama("otong");
        peserta.setEmail("otong@gmail.com");
        peserta.setTanggalLahir(new Date());

        pesertaService.save(peserta);

        Peserta peserta2 = new Peserta();
        peserta2.setNama("hamka");
        peserta2.setEmail("hamka@gmail.com");
        peserta2.setTanggalLahir(new Date());

        pesertaService.save(peserta2);

        Peserta result = pesertaService.findByEmail("otong@gmail.com");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("otong@gmail.com",result.getEmail());
    }

    @Test
    @Order(2)
    void testDuplicateSave() {
        Peserta peserta = new Peserta();
        peserta.setNama("otongs");
        peserta.setEmail("otong@gmail.com");
        peserta.setTanggalLahir(new Date());

        Assertions.assertThrows(DataIntegrityViolationException.class,()->{
            pesertaService.save(peserta);
        });

    }

    @Test
    @Order(3)
    void testUpdate() {
        Peserta peserta = pesertaService.findByEmail("otong@gmail.com");

        pesertaService.updateContent(peserta.getId(),"hamka",new Date());

        peserta = pesertaService.findByEmail("otong@gmail.com");
        Assertions.assertEquals("hamka",peserta.getNama());
    }

    @Test
    @Order(4)
    void testDeleteByEmail() {

        pesertaService.deleteByEmail("otong@gmail.com");

        Peserta peserta = pesertaService.findByEmail("otong@gmail.com");
        Assertions.assertNull(peserta);

    }
}
