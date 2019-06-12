package de.muSchus.gso.database.entity;

import de.muSchus.gso.database.util.Rolle;
import lombok.Data;
import lombok.experimental.Accessors;
import java.security.MessageDigest;

import javax.persistence.*;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

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
    private byte[] passwort;

    @Enumerated(EnumType.STRING)
    private Rolle rolle;


    public Account setPasswort(String passwort){
        this.passwort=encryptPW(passwort);
        return this;
    }

    public static byte[] encryptPW(String passwort){
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            if (passwort != null) {
                messageDigest.update(passwort.getBytes());
                return messageDigest.digest();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
