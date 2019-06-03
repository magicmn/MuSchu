package de.muSchus.gso.database.entity;

import de.muSchus.gso.database.util.Rolle;
import de.muSchus.gso.database.util.RolleConverter;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Accessors(chain = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(uniqueConstraints = {@UniqueConstraint(name = "uk_nutzername", columnNames = "nutzername")})
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nutzername;
    @Column(nullable = false)
    private String passwort;
    @Convert(converter = RolleConverter.class)
    private Rolle rolle;
}
