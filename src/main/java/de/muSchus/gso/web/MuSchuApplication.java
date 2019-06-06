package de.muSchus.gso.web;

import de.muSchus.gso.database.DatabaseConnector;
import de.muSchus.gso.web.page.Home;
import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AnnotationsRoleAuthorizationStrategy;
import org.apache.wicket.devutils.stateless.StatelessChecker;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.response.filter.AjaxServerAndClientTimeFilter;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

/**
 * WebApplication-Objekt. Definiert die grundlegende Konfiguration der gesamten Anwendung.
 */
public class MuSchuApplication extends AuthenticatedWebApplication {

    public static MuSchuApplication get() {
        return (MuSchuApplication) AuthenticatedWebApplication.get();
    }

    @Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        return MuSchuSession.class;
    }

    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        return Home.class;
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return Home.class;
    }

    @Override
    public void init() {
        getRequestCycleSettings().addResponseFilter(new AjaxServerAndClientTimeFilter());
        getDebugSettings().setAjaxDebugModeEnabled(true);
        mountPackage("page", Home.class);
        getSecuritySettings().setAuthorizationStrategy(new AnnotationsRoleAuthorizationStrategy(this));
        getComponentPostOnBeforeRenderListeners().add(new StatelessChecker());
        getComponentInstantiationListeners().add(new SpringComponentInjector(this, DatabaseConnector.getApplicationContext()));
        getMarkupSettings().setStripWicketTags(true);
        getMarkupSettings().setCompressWhitespace(true);
    }

}
