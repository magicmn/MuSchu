package de.muSchus.gso.web.page;

import de.muSchus.gso.web.bootstrap.page.BasePage;
import de.muSchus.gso.web.panel.account.info.AccountInfo;
import de.muSchus.gso.web.panel.account.login.Login;
import de.muSchus.gso.web.panel.stunde.model.StundenTotalLDM;
import de.muSchus.gso.web.panel.stunde.list.StundenList;
import de.muSchus.gso.web.panel.stunde.model.StundenWocheLDM;
import de.muSchus.gso.web.panel.account.test.TestLogin;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Startseite, welche nur sporadisch vorhanden ist. Könnte sicherlich mit sinnvollem Inhalt gefüllt werden.
 */
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
        add(new StundenList("stundenWoche", "EEEE",new ResourceModel("Stunde.woche"), new StundenWocheLDM()));
        add(new StundenList("stundenTotal", "dd.MM.yyyy",new ResourceModel("Stunde.total"), new StundenTotalLDM()));
        add(new TestLogin("testLogin"));
    }
}
