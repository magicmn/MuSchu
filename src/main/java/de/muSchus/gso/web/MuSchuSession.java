package de.muSchus.gso.web;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

/**
 * {@link WebSession} die für jeden User erstellt wird, sobald dieser auf eine Seite kommt, welche nicht Stateless ist.
 * Enthält somit alles, was global den User betrifft.
 */
public class MuSchuSession extends AuthenticatedWebSession {

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
        return false;
    }

    /**
     * @see AuthenticatedWebSession#getRoles()
     */
    @Override
    public Roles getRoles() {
        return null;
    }
}
