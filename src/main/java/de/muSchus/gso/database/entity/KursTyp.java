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
public class KursTyp implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bezeichnung;

    @ManyToMany(mappedBy = "kursTypen")
    private List<Dozent> dozenten = new ArrayList<>();

    @ManyToMany(mappedBy = "kursTypen")
    private List<Raum> raeume = new ArrayList<>();

    @ManyToMany(mappedBy = "wunschkurse")
    private List<Schueler> schueler = new ArrayList<>();
}
