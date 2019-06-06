package de.muSchus.gso.database.entity;

import de.muSchus.gso.database.util.Rolle;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@Entity
@PrimaryKeyJoinColumn(name = "account", foreignKey = @ForeignKey(name = "fk_lehrer_account"))
public class Dozent extends Account implements Serializable {

    public Dozent() {
        setRolle(Rolle.LEHRER);
    }

    @Column(nullable = false, precision = 2)
    private BigDecimal stundensatz;

    @ManyToOne
    @JoinColumn(name = "bankverbindung", foreignKey = @ForeignKey(name = "fk_lehrer_bankverbindung"))
    private Bankverbindung bankverbindung;

    @OneToMany(mappedBy = "dozent")
    private List<Kurs> kurse = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "lehrer_kursTyp",
            joinColumns = @JoinColumn(name = "dozent", foreignKey = @ForeignKey(name = "fk_dozent_kursTyp")),
            inverseJoinColumns = @JoinColumn(name = "kursTyp", foreignKey = @ForeignKey(name = "fk_kursTyp_dozent"))
    )
    private List<KursTyp> kursTypen = new ArrayList<>();

    @Tolerate
    public Dozent setKursTypen(KursTyp... kursTypen) {
        return setKursTypen(Arrays.asList(kursTypen));
    }

    @Tolerate
    public Dozent setStundensatz(double stundensatz) {
        return setStundensatz(new BigDecimal(stundensatz));
    }
}
