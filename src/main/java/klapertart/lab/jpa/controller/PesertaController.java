package klapertart.lab.jpa.controller;

import klapertart.lab.jpa.entity.Peserta;
import klapertart.lab.jpa.model.ResponseMessageCustom;
import klapertart.lab.jpa.service.PesertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kurakuraninja
 * @since 18/12/22
 */

@RestController
@RequestMapping(path = "/peserta")
public class PesertaController {

    @Autowired
    PesertaService pesertaService;

    @GetMapping("/")
    public String home(){
        return "Welcome in SpringBoot Restful";
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseMessageCustom> getAllPeserta(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                new ResponseMessageCustom(000,"Daftar Peserta",pesertaService.getAllPeserta()));
    }
}
