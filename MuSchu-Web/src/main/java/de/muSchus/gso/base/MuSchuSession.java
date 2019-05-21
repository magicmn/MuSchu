package de.muSchus.gso.base;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

/**
 * {@link WebSession} die für jeden Benutzer erstellt wird. Enthält somit alles, was global den Benutzer betrifft.
 */
public class MuSchuSession extends AuthenticatedWebSession {

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
