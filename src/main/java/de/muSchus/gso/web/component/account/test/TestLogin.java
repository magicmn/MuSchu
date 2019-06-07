package de.muSchus.gso.web.component.account.test;

import de.muSchus.gso.web.general.MuSchuSession;
import de.muSchus.gso.web.page.Home;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.markup.html.panel.Panel;

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
