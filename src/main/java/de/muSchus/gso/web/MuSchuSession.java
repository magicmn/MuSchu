package de.muSchus.gso.web;

import de.muSchus.gso.database.User;
import de.muSchus.gso.database.UserRepositroy;
import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * {@link WebSession} die für jeden User erstellt wird, sobald dieser auf eine Seite kommt, welche nicht Stateless ist.
 * Enthält somit alles, was global den User betrifft.
 */
public class MuSchuSession extends AuthenticatedWebSession {


    @SpringBean
    private UserRepositroy USER_REPOSITORY;
    private User sessionOwner;

    /**
     * @see Session#get()
     */
    public static MuSchuSession get() {
        return (MuSchuSession) WebSession.get();
    }

    public MuSchuSession(Request request) {
        super(request);
    }

    /**
     * @see AuthenticatedWebSession#authenticate(String, String)
     */
    @Override
    protected boolean authenticate(String user, String password) {
        Injector.get().inject(this);
        sessionOwner = USER_REPOSITORY.findFirstByUsernameAndPassword(user, password);
        if (sessionOwner != null) {
            bind();
            return true;
        } else {
            return false;
        }
    }

    /**
     * @see AuthenticatedWebSession#getRoles()
     */
    @Override
    public Roles getRoles() {
        if (sessionOwner == null) {
            return new Roles("Unregistered");
        } else {
            return new Roles("Admin");
        }
    }
}
