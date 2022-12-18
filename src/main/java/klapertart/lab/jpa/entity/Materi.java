package klapertart.lab.jpa.entity;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kurakuraninja
 * @since 18/12/22
 */

@Entity
@Table(name = "m_materi")
@Data
public class Materi {

    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(nullable = false, unique = true)
    private String kode;

    @Column(nullable = true, length = 50)
    private String nama;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "materi")
    private List<Sesi> daftarSesi = new ArrayList<>();
}
