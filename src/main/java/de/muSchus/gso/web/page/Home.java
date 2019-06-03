package de.muSchus.gso.web.page;

import de.muSchus.gso.web.bootstrap.page.BasePage;
import de.muSchus.gso.web.panel.AccountInfo;
import de.muSchus.gso.web.panel.Login;
import org.apache.wicket.devutils.stateless.StatelessComponent;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Startseite, welche nur sporadisch vorhanden ist. Könnte sicherlich mit sinnvollem Inhalt gefüllt werden.
 */
@StatelessComponent
public class Home extends BasePage {

    public Home() {
        initComponents();
    }

    public Home(IModel<?> model) {
        super(model);
        initComponents();
    }

    public Home(PageParameters parameters) {
        super(parameters);
        initComponents();
    }

    private void initComponents() {
        add(new Login("login"));
        add(new AccountInfo("accountInfo"));
    }
}
