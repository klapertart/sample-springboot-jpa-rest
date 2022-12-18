package klapertart.lab.jpa.repository;

import klapertart.lab.jpa.entity.Peserta;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PesertaRepository extends CrudRepository<Peserta,String> {

    Peserta findByEmail(String email);

    void deleteByEmail(String email);

    @Modifying
    @Query("UPDATE Peserta " +
            "set nama=:nama, tanggalLahir=:tanggalLahir " +
            "WHERE id=:id")
    void updateContent(
            @Param(value = "id") String id,
            @Param(value = "nama") String nama,
            @Param(value = "tanggalLahir") Date tanggalLahir);
}
