package de.muSchus.gso.web.component.stunde.list;

import de.muSchus.gso.database.entity.Stunde;
import de.muSchus.gso.web.general.panel.Panel;
import de.muSchus.gso.web.general.render.LabelRenderer;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.Collection;

public class StundenList extends Panel<Collection<Stunde>> {

    private RepeatingView stundenItems;
    private LabelRenderer<Stunde> labelRenderer;

    public StundenList(String id, LabelRenderer<Stunde> labelRenderer) {
        super(id);
        this.labelRenderer = labelRenderer;
        initComponents();
    }



    private void initComponents() {
        add(stundenItems = new RepeatingView("stundenItems"));
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
        stundenItems.add(new StundenPanel(stundenItems.newChildId(), model, labelRenderer));
    }
}
