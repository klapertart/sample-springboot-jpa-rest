package klapertart.lab.jpa.repository;

import klapertart.lab.jpa.entity.Materi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kurakuraninja
 * @since 18/12/22
 */

@Repository
public interface MateriRepository extends CrudRepository<Materi,String> {

    Materi findByKode(String kode);

}
