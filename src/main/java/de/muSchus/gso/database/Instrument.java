package de.muSchus.gso.database;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Instrument {

    @Id
    @GeneratedValue
    private Long id;
    private String bezeichnung;

}
