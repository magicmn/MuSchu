package de.muSchus.gso.web.util.page;

import de.muSchus.gso.web.MuSchuSession;
import de.muSchus.gso.web.page.Home;
import de.muSchus.gso.web.panel.LoginTest;
import de.muSchus.gso.web.util.model.labeledItem.*;
import de.muSchus.gso.web.util.panel.Panel;
import de.muSchus.gso.web.util.panel.navigation.Navigation;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Abstrakte Seite, welche Komponenten enthält, die immer wieder verwendet werden. Zum Beispiel die Navigation.
 */
public abstract class BasePage extends WebPage {

    private Panel<Collection<ILabeledItem>> navigation;

    public BasePage() {
        init();
    }

    public BasePage(IModel<?> model) {
        super(model);
        init();
    }

    public BasePage(PageParameters parameters) {
        super(parameters);
        init();
    }

    private void init() {
        navigation = createNavigation("navigation", createNavigationModel());
        add(navigation);
    }

    /**
     * Wird bei der Initialisierung der Navigation aufgerufen und erzeugt deren Inhalte.
     * @return Navigationsinhalte, welche auf der Seite angezeigt werden sollen.
     */
    protected IModel<Collection<ILabeledItem>> createNavigationModel() {
        List<ILabeledItem> itemList = new ArrayList<>();
        itemList.add(PageLinkItem.of(Home.class));
        itemList.add(new EventLinkItem(Model.of("Logout")) {
            @Override
            public void onCLick() {
                MuSchuSession.get().invalidate();
            }
        });
        itemList.add(ListItem.of(Model.of("LinkListTest"), Home.class, null, Home.class));
        itemList.add(ListItem.of(Model.of("MischMaschTest"), PageLinkItem.of(Home.class), null, new PanelItem<>(Model.of("Test"), LoginTest.class)));
        return Model.of(itemList);
    }

    /**
     * Erstellt {@link Panel}, welches als Navigation verwendet wird. Kann überschrieben werden, um anderes NAvigatonspanel
     * zu verwenden.
     * @param id WicketId
     * @param model Menuitems
     * @return Navigation
     */
    protected Panel<Collection<ILabeledItem>> createNavigation(String id, IModel<Collection<ILabeledItem>> model) {
        return new Navigation(id, model);
    }

    /**
     * Setzt den Titel der Seite z.B. für den Browsertab. Standardmäßig wird hierzu aus der properties.xml ein Wert verwendet,
     * welcher dem Klassennamen entspricht.
     * @return Titel der Seite
     */
    protected IModel<String> getTitleModel() {
        return new StringResourceModel(this.getClass().getSimpleName(), this, null);
    }

    /**
     * @return Aufbau der Navigation, mit allen Unterpunkten basierend auf {@link ILabeledItem}'s.
     */
    public IModel<Collection<ILabeledItem>> getNavigationModel() {
        return navigation.getModel();
    }

    /**
     * Setzt das NavigationsModel. Nur bei Verwendung dieser Methoder wird die Navigation neu gerendert und der Inhalt
     * aktualisiert.
     * @param model Aufbau der gewünschten Navigation.
     */
    public void setNavigationModel(IModel<Collection<ILabeledItem>> model) {
        navigation.setModel(model);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        response.getResponse().write("<title>" + getTitleModel().getObject() + "</title>");
    }
}
