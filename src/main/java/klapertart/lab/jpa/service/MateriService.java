package klapertart.lab.jpa.service;

import klapertart.lab.jpa.entity.Materi;
import klapertart.lab.jpa.entity.Sesi;
import klapertart.lab.jpa.repository.MateriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kurakuraninja
 * @since 18/12/22
 */

@Service
@Transactional
public class MateriService {

    @Autowired
    private MateriRepository materiRepository;

    public void save(Materi materi){
        materiRepository.save(materi);
    }

    public Materi findByKode(String kode){
        return materiRepository.findByKode(kode);
    }
}
