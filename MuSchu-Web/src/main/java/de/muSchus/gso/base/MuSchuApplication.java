package de.muSchus.gso.base;

import de.muSchus.gso.component.page.Home;
import org.apache.wicket.Application;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;

/**
 * WebApplication-Objekt. Definiert die grundlegende Konfiguration der gesamten Anwendung.
 */
public class MuSchuApplication extends AuthenticatedWebApplication {

    /**
     * @see Application#getHomePage()
     */
    @Override
    public Class<? extends WebPage> getHomePage() {
        return Home.class;
    }

    /**
     * @see AuthenticatedWebApplication#getWebSessionClass()
     */
    @Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        return MuSchuSession.class;
    }

    /**
     * @see AuthenticatedWebApplication#getSignInPageClass()
     */
    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        return null;
    }
}
