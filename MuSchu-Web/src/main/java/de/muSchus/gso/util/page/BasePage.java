package de.muSchus.gso.util.page;

import de.muSchus.gso.component.page.Home;
import de.muSchus.gso.util.panel.navigation.Navigation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class BasePage extends WebPage {

    private Navigation navigation;

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
        navigation = createNavigation("navigation");
        navigation.addNavItem(Home.class);
        add(navigation);
    }

    protected Navigation createNavigation(String id) {
        return new Navigation(id);
    }
}
