package de.muSchus.gso.web.util.panel.dropdown;

import de.muSchus.gso.web.util.model.labeledItem.*;
import de.muSchus.gso.web.util.panel.Panel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.Collection;

public class Dropdown extends Panel<ListItem> {

    protected RepeatingView dropdownItems;

    public Dropdown(String id, IModel<ListItem> model) {
        super(id, model);
        initComponents();
        onModelChanged();
    }

    @Override
    protected void onModelChanged() {
        super.onModelChanged();
        dropdownItems.removeAll();
        addItems(getModelObject().getItems());
    }

    private void initComponents() {
        dropdownItems = new RepeatingView("linkListItems");
        add(dropdownItems);
        add(new Label("dropdownLabel", getModelObject().getLabel()));
    }

    private void addItems(Collection<? extends ILabeledItem> labeledItems) {
        labeledItems.forEach(this::addItem);
    }

    private void addItem(ILabeledItem labeledItem) {
        if (labeledItem instanceof ILinkItem) addItem((PageLinkItem) labeledItem);
        else if (labeledItem instanceof PanelItem) addItem((PanelItem) labeledItem);
        else if (labeledItem == null) addBorder();
        else throw new UnsupportedOperationException("Kann ILabeledItem nicht hinzufügen, da nicht durch Komponente unterstützt!" + labeledItem.getClass());
    }

    private void addItem(ILinkItem linkItem) {
        dropdownItems.add(new DropdownLink(dropdownItems.newChildId(), Model.of(linkItem)));
    }

    private void addItem(PanelItem panelItem) {
        dropdownItems.add(new DropdownPanelWrapper(dropdownItems.newChildId(), Model.of(panelItem)));
    }

    private void addBorder() {
        dropdownItems.add(new DropdownBorder(dropdownItems.newChildId()));
    }
}
