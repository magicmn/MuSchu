package de.muSchus.gso.database.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@Entity
public class Schueler implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String vorname;

    @Column(nullable = false)
    private String nachname;

    @Email
    private String email;

    @Column(length = 20)
    private String telefonnummer;

    @Column(length = 10)
    private String postleitzahl;

    private String ort;

    private String strasse;

    @Column(length = 6)
    private String hausnummer;

    @ManyToOne
    @JoinColumn(name = "bankverbindung", foreignKey = @ForeignKey(name = "fk_schueler_bankverbindung"))
    private Bankverbindung bankverbindung;

    @OneToMany(mappedBy = "schueler")
    private List<Vertrag> vertraege = new ArrayList<>();
}
