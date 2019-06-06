package de.muSchus.gso.web.panel.account.test;

import de.muSchus.gso.database.util.Rolle;
import de.muSchus.gso.web.MuSchuSession;
import de.muSchus.gso.web.page.Home;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.markup.html.panel.Panel;

@AuthorizeAction(action = "RENDER", roles = Rolle.Constants.LOGGED_OUT)
public class TestLogin extends Panel {

    public TestLogin(String id) {
        super(id);
        add(new StatelessLink<Void>("loginDozent") {
            @Override
            public void onClick() {
                MuSchuSession.get().signIn("Fidel", "passwort");
                setResponsePage(Home.class);
            }
        });
        add(new StatelessLink<Void>("loginVerwaltung") {
            @Override
            public void onClick() {
                MuSchuSession.get().signIn("Admin", "passwort");
                setResponsePage(Home.class);
            }
        });
    }
}
