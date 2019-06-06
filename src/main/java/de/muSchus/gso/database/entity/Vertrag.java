package de.muSchus.gso.database.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Accessors(chain = true)
@Entity
@Transactional
public class Vertrag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date startDatum;

    @ManyToOne
    @JoinColumn(name = "schueler", foreignKey = @ForeignKey(name = "fk_vertrag_schueler"))
    private Schueler schueler;

    @ManyToOne
    @JoinColumn(name = "kondition", foreignKey = @ForeignKey(name = "fk_vertrag_kondition"))
    private Kondition kondition;

    @ManyToOne
    @JoinColumn(name = "kurs", foreignKey = @ForeignKey(name = "fk_vertrag_kurs"))
    private Kurs kurs;
}
