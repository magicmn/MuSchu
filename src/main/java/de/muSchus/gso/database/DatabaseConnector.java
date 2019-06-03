package de.muSchus.gso.database;

import de.muSchus.gso.database.entity.*;
import de.muSchus.gso.database.repository.*;
import de.muSchus.gso.database.util.Rolle;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DatabaseConnector {

    private static ApplicationContext applicationContext;

    public static void main(String[] args) throws BeansException {
        applicationContext = SpringApplication.run(DatabaseConnector.class, args);
        createTestdata();
    }

    public static ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            main(new String[]{});
        }
        return applicationContext;
    }

    public static void createTestdata() {
        applicationContext.getBean(AccountRepository.class).save(new Account().setNutzername("Admin").setPasswort("passwort").setRolle(Rolle.VERWALTUNG));
        List<KursTyp> kursTypen = new ArrayList<>();
        kursTypen.add(new KursTyp().setBezeichnung("Gesang"));
        kursTypen.add(new KursTyp().setBezeichnung("Gitarre"));
        kursTypen.add(new KursTyp().setBezeichnung("Klavier"));
        kursTypen.add(new KursTyp().setBezeichnung("Keyboard"));
        kursTypen.add(new KursTyp().setBezeichnung("Bass"));
        kursTypen.add(new KursTyp().setBezeichnung("Geige"));
        kursTypen.add(new KursTyp().setBezeichnung("Trompete"));
        kursTypen.add(new KursTyp().setBezeichnung("Saxophone"));
        kursTypen.add(new KursTyp().setBezeichnung("Querflöte"));
        kursTypen.add(new KursTyp().setBezeichnung("Klarinette"));
        kursTypen.add(new KursTyp().setBezeichnung("Ukulele"));
        kursTypen.add(new KursTyp().setBezeichnung("Band"));
        kursTypen.add(new KursTyp().setBezeichnung("Schalgzeug"));
        applicationContext.getBean(KursTypRepository.class).saveAll(kursTypen);
        List<Raum> raeume = new ArrayList<>();
        raeume.add(new Raum().setBezeichnung("Raum 1").setKursTypen(kursTypen.get(0), kursTypen.get(1), kursTypen.get(4), kursTypen.get(5), kursTypen.get(6), kursTypen.get(7), kursTypen.get(8), kursTypen.get(9), kursTypen.get(10)));
        raeume.add(new Raum().setBezeichnung("Raum 2").setKursTypen(kursTypen.get(0), kursTypen.get(1), kursTypen.get(4), kursTypen.get(5), kursTypen.get(6), kursTypen.get(7), kursTypen.get(8), kursTypen.get(9), kursTypen.get(10), kursTypen.get(12)));
        raeume.add(new Raum().setBezeichnung("Raum 3").setKursTypen(kursTypen.get(0), kursTypen.get(1), kursTypen.get(4), kursTypen.get(5), kursTypen.get(6), kursTypen.get(7), kursTypen.get(8), kursTypen.get(9), kursTypen.get(10)));
        raeume.add(new Raum().setBezeichnung("Raum 4").setKursTypen(kursTypen.get(0), kursTypen.get(1), kursTypen.get(3), kursTypen.get(4), kursTypen.get(5), kursTypen.get(6), kursTypen.get(7), kursTypen.get(8), kursTypen.get(9), kursTypen.get(10)));
        raeume.add(new Raum().setBezeichnung("Raum 5").setKursTypen(kursTypen.get(0), kursTypen.get(1), kursTypen.get(3), kursTypen.get(4), kursTypen.get(5), kursTypen.get(6), kursTypen.get(7), kursTypen.get(8), kursTypen.get(9), kursTypen.get(10)));
        raeume.add(new Raum().setBezeichnung("Raum 6").setKursTypen(kursTypen.get(0), kursTypen.get(1), kursTypen.get(4), kursTypen.get(5), kursTypen.get(6), kursTypen.get(7), kursTypen.get(8), kursTypen.get(9), kursTypen.get(10)));
        raeume.add(new Raum().setBezeichnung("Raum 7").setKursTypen(kursTypen.get(0), kursTypen.get(1), kursTypen.get(4), kursTypen.get(5), kursTypen.get(6), kursTypen.get(7), kursTypen.get(8), kursTypen.get(9), kursTypen.get(10)));
        raeume.add(new Raum().setBezeichnung("Raum 8").setKursTypen(kursTypen.get(0), kursTypen.get(1), kursTypen.get(2), kursTypen.get(3), kursTypen.get(4), kursTypen.get(5), kursTypen.get(6), kursTypen.get(7), kursTypen.get(8), kursTypen.get(9), kursTypen.get(10)));
        raeume.add(new Raum().setBezeichnung("Raum 9").setKursTypen(kursTypen.get(0), kursTypen.get(1), kursTypen.get(2), kursTypen.get(4), kursTypen.get(5), kursTypen.get(6), kursTypen.get(7), kursTypen.get(8), kursTypen.get(9), kursTypen.get(10)));
        raeume.add(new Raum().setBezeichnung("Raum 10").setKursTypen(kursTypen.get(0), kursTypen.get(1), kursTypen.get(4), kursTypen.get(5), kursTypen.get(6), kursTypen.get(7), kursTypen.get(8), kursTypen.get(9), kursTypen.get(10), kursTypen.get(12)));
        raeume.add(new Raum().setBezeichnung("Raum 11").setKursTypen(kursTypen.get(0), kursTypen.get(1), kursTypen.get(4), kursTypen.get(5), kursTypen.get(6), kursTypen.get(7), kursTypen.get(8), kursTypen.get(9), kursTypen.get(10)));
        raeume.add(new Raum().setBezeichnung("Raum 12").setKursTypen(kursTypen.get(0), kursTypen.get(1), kursTypen.get(4), kursTypen.get(5), kursTypen.get(6), kursTypen.get(7), kursTypen.get(8), kursTypen.get(9), kursTypen.get(10)));
        raeume.add(new Raum().setBezeichnung("Raum 13").setKursTypen(kursTypen.get(0), kursTypen.get(1), kursTypen.get(4), kursTypen.get(5), kursTypen.get(6), kursTypen.get(7), kursTypen.get(8), kursTypen.get(9), kursTypen.get(10)));
        raeume.add(new Raum().setBezeichnung("Raum 14").setKursTypen(kursTypen.get(0), kursTypen.get(1), kursTypen.get(4), kursTypen.get(5), kursTypen.get(6), kursTypen.get(7), kursTypen.get(8), kursTypen.get(9), kursTypen.get(10)));
        raeume.add(new Raum().setBezeichnung("Raum 15").setKursTypen(kursTypen.get(0), kursTypen.get(1), kursTypen.get(2), kursTypen.get(3), kursTypen.get(4), kursTypen.get(5), kursTypen.get(6), kursTypen.get(7), kursTypen.get(8), kursTypen.get(9), kursTypen.get(10), kursTypen.get(11)));
        raeume.add(new Raum().setBezeichnung("Studio"));
        applicationContext.getBean(RaumRepository.class).saveAll(raeume);
        List<Bankverbindung> bankverbindungen = new ArrayList<>();
        bankverbindungen.add(new Bankverbindung().setIban("DE123234DRÖLF").setKontoinhaber("Gönner Für Alle Ev"));
        bankverbindungen.add(new Bankverbindung().setIban("DE2q13234").setKontoinhaber("Noch ein Gönner Ev"));
        bankverbindungen.add(new Bankverbindung().setIban("DE12323").setKontoinhaber("Abzocker GmbH"));
        applicationContext.getBean(BankverbindungRepository.class).saveAll(bankverbindungen);
        List<Dozent> dozenten = new ArrayList<>();
        dozenten.add(((Dozent) new Dozent().setNutzername("Oliver").setPasswort("passwort")).setBankverbindung(bankverbindungen.get(2)).setStundensatz(30.00).setKursTypen(kursTypen.get(1), kursTypen.get(4), kursTypen.get(10), kursTypen.get(11)));
        dozenten.add(((Dozent) new Dozent().setNutzername("Lea").setPasswort("passwort")).setBankverbindung(bankverbindungen.get(2)).setStundensatz(27.00).setKursTypen(kursTypen.get(8), kursTypen.get(9)));
        dozenten.add(((Dozent) new Dozent().setNutzername("Steve").setPasswort("passwort")).setBankverbindung(bankverbindungen.get(2)).setStundensatz(18.00).setKursTypen(kursTypen.get(0)));
        dozenten.add(((Dozent) new Dozent().setNutzername("Fidel").setPasswort("passwort")).setBankverbindung(bankverbindungen.get(2)).setStundensatz(50.00).setKursTypen(kursTypen.get(0), kursTypen.get(2), kursTypen.get(3), kursTypen.get(11)));
        dozenten.add(((Dozent) new Dozent().setNutzername("Steffi").setPasswort("passwort")).setBankverbindung(bankverbindungen.get(2)).setStundensatz(30.00).setKursTypen(kursTypen.get(0)));
        dozenten.add(((Dozent) new Dozent().setNutzername("Lukas").setPasswort("passwort")).setBankverbindung(bankverbindungen.get(2)).setStundensatz(25.00).setKursTypen(kursTypen.get(12)));
        dozenten.add(((Dozent) new Dozent().setNutzername("Dirk").setPasswort("passwort")).setBankverbindung(bankverbindungen.get(2)).setStundensatz(25.00).setKursTypen(kursTypen.get(1), kursTypen.get(4)));
        dozenten.add(((Dozent) new Dozent().setNutzername("Gunnar").setPasswort("passwort")).setBankverbindung(bankverbindungen.get(2)).setStundensatz(30.00).setKursTypen(kursTypen.get(7)));
        dozenten.add(((Dozent) new Dozent().setNutzername("Mara").setPasswort("passwort")).setBankverbindung(bankverbindungen.get(2)).setStundensatz(25.00).setKursTypen(kursTypen.get(2)));
        dozenten.add(((Dozent) new Dozent().setNutzername("Marc").setPasswort("passwort")).setBankverbindung(bankverbindungen.get(2)).setStundensatz(28.00).setKursTypen(kursTypen.get(7)));
        dozenten.add(((Dozent) new Dozent().setNutzername("Max").setPasswort("passwort")).setBankverbindung(bankverbindungen.get(2)).setStundensatz(35.00).setKursTypen(kursTypen.get(5)));
        dozenten.add(((Dozent) new Dozent().setNutzername("Maren").setPasswort("passwort")).setBankverbindung(bankverbindungen.get(2)).setStundensatz(30.00).setKursTypen(kursTypen.get(5)));
        dozenten.add(((Dozent) new Dozent().setNutzername("Hans").setPasswort("passwort")).setBankverbindung(bankverbindungen.get(2)).setStundensatz(27.00).setKursTypen(kursTypen.get(4)));
        dozenten.add(((Dozent) new Dozent().setNutzername("Ralf").setPasswort("passwort")).setBankverbindung(bankverbindungen.get(2)).setStundensatz(30.00).setKursTypen(kursTypen.get(1), kursTypen.get(4), kursTypen.get(10)));
        dozenten.add(((Dozent) new Dozent().setNutzername("Guido").setPasswort("passwort")).setBankverbindung(bankverbindungen.get(2)).setStundensatz(35.00).setKursTypen(kursTypen.get(6)));
        dozenten.add(((Dozent) new Dozent().setNutzername("Bärbel").setPasswort("passwort")).setBankverbindung(bankverbindungen.get(2)).setStundensatz(30.00).setKursTypen(kursTypen.get(2), kursTypen.get(3)));
        dozenten.add(((Dozent) new Dozent().setNutzername("Harald").setPasswort("passwort")).setBankverbindung(bankverbindungen.get(2)).setStundensatz(35.00).setKursTypen(kursTypen.get(8), kursTypen.get(9)));
        dozenten.add(((Dozent) new Dozent().setNutzername("Julius").setPasswort("passwort")).setBankverbindung(bankverbindungen.get(2)).setStundensatz(30.00).setKursTypen(kursTypen.get(6)));
        dozenten.add(((Dozent) new Dozent().setNutzername("Eva").setPasswort("passwort")).setBankverbindung(bankverbindungen.get(2)).setStundensatz(28.00).setKursTypen(kursTypen.get(0), kursTypen.get(2)));
        applicationContext.getBean(DozentRepository.class).saveAll(dozenten);
        List<Kurs> kurse = new ArrayList<>();
        kurse.add(new Kurs().setBezeichnung("A capella am Montag (Einzel/10:00)").setDozent(dozenten.get(3)).setKursTyp(kursTypen.get(0)));
        kurse.add(new Kurs().setBezeichnung("A capella am Montag (Einzel/10:30)").setDozent(dozenten.get(3).setKursTypen(kursTypen.get(0))));
        kurse.add(new Kurs().setBezeichnung("A capella am Montag (Einzel/11:30)").setDozent(dozenten.get(3).setKursTypen(kursTypen.get(0))));
        kurse.add(new Kurs().setBezeichnung("A capella am Montag (Einzel/13:00)").setDozent(dozenten.get(3).setKursTypen(kursTypen.get(0))));
        kurse.add(new Kurs().setBezeichnung("Klarinette am Montag (Einzel/14:00)").setDozent(dozenten.get(1).setKursTypen(kursTypen.get(9))));
        kurse.add(new Kurs().setBezeichnung("A capella am Montag (Einzel/16:00)").setDozent(dozenten.get(3)).setKursTyp(kursTypen.get(0)));
        kurse.add(new Kurs().setBezeichnung("Gitarre am Dienstag (Einzel/11:30)").setDozent(dozenten.get(0)).setKursTyp(kursTypen.get(1)));
        kurse.add(new Kurs().setBezeichnung("Gitarre am Dienstag (Einzel/12:00)").setDozent(dozenten.get(0)).setKursTyp(kursTypen.get(1)));
        kurse.add(new Kurs().setBezeichnung("Gekreische am Dienstag (Einzel/13:00)").setDozent(dozenten.get(3)).setKursTyp(kursTypen.get(0)));
        kurse.add(new Kurs().setBezeichnung("Ruhestörung mit der E-Gitarre am Mittwoch (Einzel/11:30)").setDozent(dozenten.get(0)).setKursTyp(kursTypen.get(1)));
        applicationContext.getBean(KursRepository.class).saveAll(kurse);
        List<Schueler> schueler = new ArrayList<>();
        schueler.add(new Schueler().setVorname("Eva").setNachname("Battner").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Martina").setNachname("Mitz").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Dirk").setNachname("Jäger").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Tom").setNachname("Grifftith").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Kevin").setNachname("Betz").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Ingrid").setNachname("Gründgens").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Anke").setNachname("Bach").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Tim").setNachname("Eisenmann").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Marc").setNachname("Kelter").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Charlotte").setNachname("Bachmann").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Hannah").setNachname("Ahmendt").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Jana").setNachname("Jacobs").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Lukas").setNachname("Dotzler").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Lukas").setNachname("Sterling").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Bernd").setNachname("Escher").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Tobias").setNachname("Boschers").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Kai").setNachname("Zobel").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Sascha").setNachname("Zimmermann").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Vicky").setNachname("Bröder").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Marlene").setNachname("Babbage").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Corinna").setNachname("Pollmann").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Susanne").setNachname("Neumann").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Kim").setNachname("Bukowski").setBankverbindung(bankverbindungen.get(0)));
        schueler.add(new Schueler().setVorname("Erika").setNachname("Schmidt").setBankverbindung(bankverbindungen.get(1)));
        schueler.add(new Schueler().setVorname("Andrea").setNachname("Müller").setBankverbindung(bankverbindungen.get(1)));
        schueler.add(new Schueler().setVorname("Michael").setNachname("Meier").setBankverbindung(bankverbindungen.get(1)));
        schueler.add(new Schueler().setVorname("Christine").setNachname("Hendrichs").setBankverbindung(bankverbindungen.get(1)));
        applicationContext.getBean(SchuelerRepository.class).saveAll(schueler);
        List<Kondition> konditionen = new ArrayList<>();
        konditionen.add(new Kondition().setBezeichnung("Schüler/Studenten/Azubis").setPreis(79).setLaufzeit(6).setKuendigungsfrist(2));
        konditionen.add(new Kondition().setBezeichnung("Schüler/Studenten/Azubis").setPreis(72).setLaufzeit(12).setKuendigungsfrist(2));
        konditionen.add(new Kondition().setBezeichnung("Erwachsene").setPreis(89).setLaufzeit(6).setKuendigungsfrist(2));
        konditionen.add(new Kondition().setBezeichnung("Erwachsene").setPreis(82).setLaufzeit(12).setKuendigungsfrist(2));
        konditionen.add(new Kondition().setBezeichnung("Musikalische Früherziehung").setPreis(35).setLaufzeit(6).setKuendigungsfrist(0));
        applicationContext.getBean(KonditionRepository.class).saveAll(konditionen);
        List<Vertrag> vertraege = new ArrayList<>();
        vertraege.add(new Vertrag().setSchueler(schueler.get(0)).setKondition(konditionen.get(0)).setKurs(kurse.get(0)).setStartDatum(Date.valueOf(LocalDate.of(2019, 1, 2))));
        vertraege.add(new Vertrag().setSchueler(schueler.get(6)).setKondition(konditionen.get(1)).setKurs(kurse.get(1)).setStartDatum(Date.valueOf(LocalDate.of(2019, 6, 2))));
        vertraege.add(new Vertrag().setSchueler(schueler.get(19)).setKondition(konditionen.get(2)).setKurs(kurse.get(2)).setStartDatum(Date.valueOf(LocalDate.of(2019, 5, 4))));
        vertraege.add(new Vertrag().setSchueler(schueler.get(21)).setKondition(konditionen.get(3)).setKurs(kurse.get(3)).setStartDatum(Date.valueOf(LocalDate.now().minusDays(213))));
        vertraege.add(new Vertrag().setSchueler(schueler.get(1)).setKondition(konditionen.get(4)).setKurs(kurse.get(4)).setStartDatum(Date.valueOf(LocalDate.now().minusMonths(3))));
        vertraege.add(new Vertrag().setSchueler(schueler.get(2)).setKondition(konditionen.get(0)).setKurs(kurse.get(5)).setStartDatum(Date.valueOf(LocalDate.now().minusYears(2))));
        vertraege.add(new Vertrag().setSchueler(schueler.get(12)).setKondition(konditionen.get(1)).setKurs(kurse.get(6)).setStartDatum(Date.valueOf(LocalDate.now().minusDays(22))));
        vertraege.add(new Vertrag().setSchueler(schueler.get(10)).setKondition(konditionen.get(2)).setKurs(kurse.get(7)).setStartDatum(Date.valueOf(LocalDate.now().minusDays(2))));
        vertraege.add(new Vertrag().setSchueler(schueler.get(13)).setKondition(konditionen.get(3)).setKurs(kurse.get(8)).setStartDatum(Date.valueOf(LocalDate.now().minusDays(45))));
        applicationContext.getBean(VertragRepository.class).saveAll(vertraege);
        List<Stunde> stunden = new ArrayList<>();
        stunden.add(new Stunde().setDatum(Date.valueOf(LocalDate.of(2019, 6, 3))).setStartzeit(new Time(10, 0, 0)).setKurs(kurse.get(0)));
    }
}
