package de.muSchus.gso.web;

import de.muSchus.gso.web.page.Home;
import org.apache.wicket.Application;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.core.request.mapper.MountedMapper;
import org.apache.wicket.core.request.mapper.PackageMapper;
import org.apache.wicket.devutils.stateless.StatelessChecker;
import org.apache.wicket.devutils.stateless.StatelessComponent;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.IRequestMapper;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.mapper.CompoundRequestMapper;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.util.lang.PackageName;

/**
 * WebApplication-Objekt. Definiert die grundlegende Konfiguration der gesamten Anwendung.
 */
public class MuSchuApplication extends AuthenticatedWebApplication {

    /**
     * @see AuthenticatedWebApplication#getWebSessionClass()
     */
    @Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        return MuSchuSession.class;
    }

    /**
     * @see Application#getHomePage()
     */
    @Override
    public Class<? extends Page> getHomePage() {
        return Home.class;
    }

    /**
     * @see AuthenticatedWebApplication#getSignInPageClass()
     */
    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        return null;
    }

    /**
     * Lädt Injector, der es erlaubt innerhalb von {@link Component}'s die {@link SpringBean}-Annotation zu verwenden.
     * Zusätzlich wird ein {@link StatelessChecker} initialisiert, welcher mit der {@link StatelessComponent}-Annotation
     * überprüft, ob für die gewünschte Komponente eine Session erzeugt wird oder nicht.
     * @see Application#init()
     */
    @Override
    protected void init() {
        super.init();
        mount(new PackageMapper("page", PackageName.forClass(getHomePage())));
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
        // TODO Stateless Überprüfung für Components die keine Session erstellen sollen, während der Entwicklung. Nachher entfernen.
        getComponentPostOnBeforeRenderListeners().add(new StatelessChecker());
    }
}
