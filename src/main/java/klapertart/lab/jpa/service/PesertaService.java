package klapertart.lab.jpa.service;

import klapertart.lab.jpa.entity.Peserta;
import klapertart.lab.jpa.repository.PesertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author kurakuraninja
 * @since 18/12/22
 */

@Service
@Transactional
public class PesertaService {

    @Autowired
    private PesertaRepository pesertaRepository;

    public List<Peserta> getAllPeserta(){
        List<Peserta> pesertas = new ArrayList<>();

        pesertaRepository.findAll().forEach(peserta -> pesertas.add(peserta));

        return pesertas;
    }

    public Peserta findById(String id){
        return pesertaRepository.findById(id).get();
    }

    public Peserta findByEmail(String email){
        return pesertaRepository.findByEmail(email);
    }

    public void save(Peserta peserta){
        pesertaRepository.save(peserta);
    }

    public long countRecord(){
        return pesertaRepository.count();
    }

    public void deleteByEmail(String email){
        pesertaRepository.deleteByEmail(email);
    }

    public void updateContent(String id, String nama, Date tanggalLahir){
        pesertaRepository.updateContent(id,nama,tanggalLahir);
    }

}
