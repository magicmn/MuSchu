package de.muSchus.gso.web.panel.stunde.list;

import de.muSchus.gso.database.entity.Stunde;
import de.muSchus.gso.database.util.Rolle;
import de.muSchus.gso.web.bootstrap.panel.Panel;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.Collection;

@AuthorizeAction(roles = Rolle.Constants.LEHRER, action = "RENDER")
public class StundenList extends Panel<Collection<Stunde>> {

    private RepeatingView stundenItems;

    private final String datePrefix;


    public StundenList(String id, String datePrefix, IModel<String> label, IModel<Collection<Stunde>> model) {
        super(id);
        this.datePrefix = datePrefix;
        initComponents(label);
        setModel(model);
    }

    private void initComponents(IModel<String> label) {
        add(new Label("titel", label));
        stundenItems = new RepeatingView("stundenItems");
        add(stundenItems);
    }

    @Override
    protected void onModelChanged() {
        super.onModelChanged();
        stundenItems.removeAll();
        if (getModelObject() != null) {
            addItems(getModel());
        }
    }

    private void addItems(IModel<Collection<Stunde>> model) {
        model.getObject().forEach(stunde -> addItem(Model.of(stunde)));
    }

    private void addItem(IModel<Stunde> model) {
        stundenItems.add(new StundenPanel(stundenItems.newChildId(), datePrefix, model));
    }
}
