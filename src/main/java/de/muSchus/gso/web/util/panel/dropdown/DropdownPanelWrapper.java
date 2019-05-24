package de.muSchus.gso.web.util.panel.dropdown;

import de.muSchus.gso.web.util.model.labeledItem.PanelItem;
import de.muSchus.gso.web.util.panel.Panel;
import org.apache.wicket.model.IModel;

public class DropdownPanelWrapper extends Panel<PanelItem> {

    public DropdownPanelWrapper(String id, IModel<PanelItem> model) {
        super(id, model);
        initComponents();
    }

    private void initComponents() {
        add(getModelObject().createPanel("content"));
    }
}
