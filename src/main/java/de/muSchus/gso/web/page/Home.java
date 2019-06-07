package de.muSchus.gso.web.page;

import de.muSchus.gso.database.entity.Stunde;
import de.muSchus.gso.database.util.Rolle;
import de.muSchus.gso.web.component.account.info.AccountInfo;
import de.muSchus.gso.web.component.account.login.Login;
import de.muSchus.gso.web.component.account.test.TestLogin;
import de.muSchus.gso.web.component.stunde.list.StundenList;
import de.muSchus.gso.web.component.stunde.model.StundenTotalLDM;
import de.muSchus.gso.web.component.stunde.model.StundenWocheLDM;
import de.muSchus.gso.web.component.stunde.render.StundenListLehrerRenderer;
import de.muSchus.gso.web.general.MuSchuSession;
import de.muSchus.gso.web.general.page.BasePage;
import de.muSchus.gso.web.general.panel.Panel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.Collection;

/**
 * Startseite, welche nur sporadisch vorhanden ist. Könnte sicherlich mit sinnvollem Inhalt gefüllt werden.
 */
public class Home extends BasePage {

    private Login login;
    private AccountInfo accountInfo;
    private Label lehrerStundenWocheLabel;
    private Panel<Collection<Stunde>> lehrerStundenWocheList;
    private Label lehrerStundenTotalLabel;
    private Panel<Collection<Stunde>> lehrerStundenTotalList;
    private TestLogin testLogin;

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
        add(login = new Login("login"));
        add(accountInfo = new AccountInfo("accountInfo"));
        add(lehrerStundenWocheLabel = new Label("stundenWocheLabel", new ResourceModel("Stunde.woche")));
        add(lehrerStundenWocheList = new StundenList("stundenWoche", new StundenListLehrerRenderer("EEEE")).setModel(new StundenWocheLDM()));
        add(lehrerStundenTotalLabel= new Label("stundenTotalLabel", new ResourceModel("Stunde.total")));
        add(lehrerStundenTotalList = new StundenList("stundenTotal", new StundenListLehrerRenderer("dd.MM.yyyy")).setModel(new StundenTotalLDM()));
        add(testLogin = new TestLogin("testLogin"));
    }

    @Override
    protected void onConfigure() {
        super.onConfigure();
        if (MuSchuSession.get().getRoles().hasRole(Rolle.LOGGED_IN.name())) {
            login.setVisible(false);
            testLogin.setVisible(false);
        } else {
            accountInfo.setVisible(false);
            lehrerStundenTotalLabel.setVisible(false);
            lehrerStundenTotalList.setVisible(false);
            lehrerStundenWocheLabel.setVisible(false);
            lehrerStundenWocheList.setVisible(false);
        }
    }
}
