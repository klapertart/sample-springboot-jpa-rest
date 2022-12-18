package klapertart.lab.jpa.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author kurakuraninja
 * @since 18/12/22
 */

@Entity
@Data
public class Peserta {

    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(nullable = false,length = 50)
    private String nama;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "tanggal_lahir", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;
}
