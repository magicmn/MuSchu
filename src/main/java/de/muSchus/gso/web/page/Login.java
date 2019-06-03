package de.muSchus.gso.web.page;

import de.muSchus.gso.database.util.Rolle;
import de.muSchus.gso.web.bootstrap.page.BasePage;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.Form;

@AuthorizeInstantiation(Rolle.Constants.LOGGED_IN)
public class Login extends BasePage {
    public Login() {
        add(new Form<>("Test"));
    }
}
