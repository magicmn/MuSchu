package de.muSchus.gso.web;

import de.muSchus.gso.database.entity.Account;
import de.muSchus.gso.database.repository.AccountRepository;
import de.muSchus.gso.database.util.Rolle;
import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * {@link WebSession} die für jeden Account erstellt wird, sobald dieser auf eine Seite kommt, welche nicht Stateless ist.
 * Enthält somit alles, was global den Account betrifft.
 */
public class MuSchuSession extends AuthenticatedWebSession {

    @SpringBean
    private AccountRepository ACCOUNT_REPOSITORY;
    private Account account = null;
    private Roles roles = new Roles(Rolle.LOGGED_OUT.name());

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
        account = ACCOUNT_REPOSITORY.findFirstByNutzernameAndPasswort(user, password);
        if (account != null) {
            bind();
            roles.clear();
            roles.add(Rolle.LOGGED_IN.name());
            roles.add(account.getRolle().name());
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
        return roles;
    }

    public Account getAccount() {
        return account;
    }
}
