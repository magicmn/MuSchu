package de.muSchus.gso.database.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@Entity
public class Kurs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bezeichnung;
    @OneToMany(mappedBy = "kurs")
    private List<Stunde> stunden = new ArrayList<>();
    @OneToMany(mappedBy = "kurs")
    private List<Vertrag> vertraege;
    @ManyToOne
    @JoinColumn(name = "kursTyp", foreignKey = @ForeignKey(name = "fk_kurs_kurstyp"))
    private KursTyp kursTyp;
    @ManyToOne
    @JoinColumn(name = "dozent", foreignKey = @ForeignKey(name = "fk_kurs_dozent"))
    private Dozent dozent;
}
