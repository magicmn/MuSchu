package de.muSchus.gso.web.page;

import de.muSchus.gso.database.util.Rolle;
import de.muSchus.gso.web.component.schueler.aufnahmeantrag.Aufnahmeantrag;
import de.muSchus.gso.web.general.page.BasePage;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;

@AuthorizeInstantiation(Rolle.Constants.LOGGED_OUT)
public class Anmeldung extends BasePage {

    public Anmeldung() {
        add(new Aufnahmeantrag("antrag"));
    }
}
