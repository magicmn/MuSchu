package de.muSchus.gso.web.general.page;

import de.muSchus.gso.web.general.panel.Panel;
import de.muSchus.gso.web.general.panel.navigation.Navigation;
import de.muSchus.gso.web.page.Anmeldung;
import de.muSchus.gso.web.page.Home;
import org.apache.wicket.Page;
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

    private Panel<Collection<Class<? extends Page>>> navigation;

    protected BasePage() {
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
        navigation = new Navigation("navigation", createNavigationModel());
        add(navigation);
    }

    /**
     * Wird bei der Initialisierung der Navigation aufgerufen und erzeugt deren Inhalte.
     * @return Navigationsinhalte, welche auf der Seite angezeigt werden sollen.
     */
    protected IModel<Collection<Class<? extends Page>>> createNavigationModel() {
        List<Class<? extends Page>> itemList = new ArrayList<>();
        itemList.add(Home.class);
        itemList.add(Anmeldung.class);
        return Model.of(itemList);
    }

    /**
     * Setzt den Titel der Seite z.B. für den Browsertab. Standardmäßig wird hierzu aus der properties.xml ein Wert verwendet,
     * welcher dem Klassennamen entspricht.
     * @return Titel der Seite
     */
    protected IModel<String> getTitleModel() {
        return new StringResourceModel(this.getClass().getSimpleName(), this, null);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        response.getResponse().write("<title>" + getTitleModel().getObject() + "</title>");
    }
}
