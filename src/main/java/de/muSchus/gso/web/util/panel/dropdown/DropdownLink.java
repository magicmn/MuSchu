package de.muSchus.gso.web.util.panel.dropdown;

import de.muSchus.gso.web.util.model.labeledItem.ILinkItem;
import de.muSchus.gso.web.util.panel.Panel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;

public class DropdownLink extends Panel<ILinkItem> {

    public DropdownLink(String id, IModel<ILinkItem> linkItem) {
        super(id, linkItem);
        initComponents();
    }

    private void initComponents() {
        Link link = getModelObject().createComponent("link");
        link.add(new Label("linkText", getModelObject().getLabel()));
        add(link);
    }
}
