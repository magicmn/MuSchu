package de.muSchus.gso.database.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@Entity
public class Kondition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bezeichnung;

    @Column(scale = 2)
    private BigDecimal preis;

    private Integer laufzeit;

    private Integer kuendigungsfrist;

    @OneToMany(mappedBy = "kondition")
    private List<Vertrag> vertraege = new ArrayList<>();

    @Tolerate
    public Kondition setPreis(double preis) {
        return setPreis(new BigDecimal(preis));
    }
}
