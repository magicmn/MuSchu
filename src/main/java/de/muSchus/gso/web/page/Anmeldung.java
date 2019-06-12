package de.muSchus.gso.web.page;

import de.muSchus.gso.web.component.schueler.aufnahmeantrag.Aufnahmeantrag;
import de.muSchus.gso.web.general.page.BasePage;

public class Anmeldung extends BasePage {

    public Anmeldung() {
        add(new Aufnahmeantrag("antrag"));
    }
}
