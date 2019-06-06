package de.muSchus.gso.database.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@Accessors(chain = true)
@Entity
public class Raum implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bezeichnung;

    @ManyToMany
    @JoinTable(
            name = "raum_kursTyp",
            joinColumns = @JoinColumn(name = "raum", foreignKey = @ForeignKey(name = "fk_raum_kursTyp")),
            inverseJoinColumns = @JoinColumn(name = "kursTyp", foreignKey = @ForeignKey(name = "fk_kursTyp_raum"))
    )
    private List<KursTyp> kursTypen = new ArrayList<>();

    @OneToMany(mappedBy = "raum")
    private List<Stunde> stunden = new ArrayList<>();

    @Tolerate
    public Raum setKursTypen(KursTyp... kursTypen) {
        return setKursTypen(Arrays.asList(kursTypen));
    }
}
