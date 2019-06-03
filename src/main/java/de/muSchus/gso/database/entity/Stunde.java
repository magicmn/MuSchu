package de.muSchus.gso.database.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Data
@Accessors(chain = true)
@Entity
public class Stunde implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date datum;
    private Time startzeit;
    private Integer dauer;
    private String inhalt;
    @ManyToOne
    @JoinColumn(name = "kurs", foreignKey = @ForeignKey(name = "fk_stunde_kurs"))
    private Kurs kurs;

}
