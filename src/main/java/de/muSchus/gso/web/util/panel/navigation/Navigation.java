package de.muSchus.gso.web.util.panel.navigation;

import de.muSchus.gso.web.util.model.labeledItem.*;
import de.muSchus.gso.web.util.panel.Panel;
import de.muSchus.gso.web.util.panel.dropdown.Dropdown;
import org.apache.wicket.Component;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.Collection;

/**
 * Simple Navigation basierend auf Bootstrap, welche {@link PageLinkItem}'s direkt zeigt und für {@link ListItem} und {@link PanelItem}
 * ein {@link Dropdown} erstellt.
 */
public class Navigation extends Panel<Collection<ILabeledItem>> {

    private RepeatingView navigationItems;

    public Navigation(String id, IModel<Collection<ILabeledItem>> model) {
        super(id, model);
        initComponents();
        onModelChanged();
    }

    /**
     * Rendert alle {@link ILabeledItem}'s der Navigation neu, wenn sich das Model ändert.
     * @see Component#onModelChanged()
     */
    @Override
    protected void onModelChanged() {
        super.onModelChanged();
        navigationItems.removeAll();
        getModelObject().forEach(this::addItem);
    }

    private void initComponents() {
        navigationItems = new RepeatingView("navItems");
        add(navigationItems);
    }

    private void addItem(ILabeledItem labeledItem) {
        if (labeledItem instanceof ILinkItem) addItem((ILinkItem) labeledItem);
        else if (labeledItem instanceof ListItem) addItem((ListItem) labeledItem);
        else if (labeledItem instanceof PanelItem) addItem((PanelItem) labeledItem);
        else throw new UnsupportedOperationException("Kann ILabeledItem nicht hinzufügen, da nicht durch Komponente unterstützt!");
    }

    private void addItem(ILinkItem pageLinkItem) {
        navigationItems.add(new NavigationLink(navigationItems.newChildId(), Model.of(pageLinkItem)));
    }

    private void addItem(ListItem listItem) {
        navigationItems.add(new Dropdown(navigationItems.newChildId(), Model.of(listItem)));
    }

    @SuppressWarnings("unchecked")
    private void addItem(PanelItem panelItem) {
        addItem(ListItem.of(panelItem.getLabel(), panelItem));
    }
}
