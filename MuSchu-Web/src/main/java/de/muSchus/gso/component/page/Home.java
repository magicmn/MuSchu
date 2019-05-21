package de.muSchus.gso.component.page;

import de.muSchus.gso.util.page.BasePage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Startseite
 */
public class Home extends BasePage {

    public Home(final PageParameters parameters) {
        super(parameters);
        add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

        // TODO Add your page's panel here

    }


}
