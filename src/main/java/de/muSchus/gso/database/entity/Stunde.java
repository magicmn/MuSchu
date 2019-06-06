package de.muSchus.gso.database.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@Entity
@Transactional
public class Stunde implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime start;

    @Column(length = 2500)
    private String inhalt;

    @ManyToOne
    @JoinColumn(name = "kurs", foreignKey = @ForeignKey(name = "fk_stunde_kurs"))
    private Kurs kurs;

    @ManyToOne
    @JoinColumn(name = "raum", foreignKey = @ForeignKey(name = "fk_stunde_raum"))
    private Raum raum;

    public int getDauer() {
        return kurs.getVertraege().size() > 1 ? 60 : 30;
    }

}
