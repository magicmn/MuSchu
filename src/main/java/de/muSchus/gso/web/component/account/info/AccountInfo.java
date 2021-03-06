package de.muSchus.gso.web.component.account.info;

import de.muSchus.gso.database.entity.Account;
import de.muSchus.gso.web.general.MuSchuSession;
import de.muSchus.gso.web.general.panel.Panel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.model.StringResourceModel;

public class AccountInfo extends Panel<Account> {

    public AccountInfo(String id) {
        super(id, Model.of(MuSchuSession.get().getAccount()));
        initComponents();
    }

    private void initComponents() {
        add(new Label("account.info", new ResourceModel("Account.info")));
        add(new Label("account.welcome", new StringResourceModel("Account.welcome", this, getModel())));
        add(new StatelessLink<Void>("logout") {
            @Override
            public void onClick() {
                MuSchuSession.get().invalidate();
                setResponsePage(getPage().getClass());
            }
        }.setBody(new ResourceModel("Logout")));
    }
}
