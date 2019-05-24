package de.muSchus.gso.web.page;

import de.muSchus.gso.web.util.model.labeledItem.ILabeledItem;
import de.muSchus.gso.web.util.model.labeledItem.PanelItem;
import de.muSchus.gso.web.panel.LoginTest;
import de.muSchus.gso.web.util.page.BasePage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.Collection;

/**
 * Startseite, welche nur sporadisch vorhanden ist. Könnte sicherlich mit sinnvollem Inhalt gefüllt werden.
 */
public class Home extends BasePage {

    public Home() {
        initComponents();
    }

    public Home(IModel<?> model) {
        super(model);
        initComponents();
    }

    public Home(PageParameters parameters) {
        super(parameters);
        initComponents();
    }

    private void initComponents() {
        add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
        StatelessForm<Void> testForm = new StatelessForm<Void>("test") {
            @Override
            protected void onSubmit() {
                Collection<ILabeledItem> menuModel = getNavigationModel().getObject();
                menuModel.add(new PanelItem<>(Model.of("Additiontest"), LoginTest.class));
                setNavigationModel(Model.of(menuModel));
            }
        };
        add(testForm);
        testForm.add(new Button("submitTest"));
    }
}
