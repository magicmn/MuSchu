package de.muSchus.gso.web.panel.account.login;

import de.muSchus.gso.database.entity.Account;
import de.muSchus.gso.database.util.Rolle;
import de.muSchus.gso.web.MuSchuSession;
import de.muSchus.gso.web.bootstrap.panel.feedback.FeedbackPanel;
import de.muSchus.gso.web.validator.LengthValidator;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.devutils.stateless.StatelessComponent;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;

import java.util.Locale;

@StatelessComponent
@AuthorizeAction(action = "RENDER", roles = Rolle.Constants.LOGGED_OUT)
public class Login extends Panel {

    public Login(String id) {
        super(id);
        setOutputMarkupId(true);
        Model<String> passwort = new Model<>();
        add(new Label("login.info", new ResourceModel("Login")));
        Form<Account> loginForm = new StatelessForm<>("accountForm", new CompoundPropertyModel<>(new Account())) {
            @Override
            protected void onSubmit() {
                if (MuSchuSession.get().signIn(getModelObject().getNutzername(), passwort.getObject())) {
                    setResponsePage(getPage().getClass());
                } else {
                    error(new ResourceModel("Login.failed").getObject());
                }
            }
        };
        loginForm.add(new TextField<String>("nutzername") {
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                tag.put("placeholder", new ResourceModel("Login.nutzername.hint").getObject());
            }
        }.setRequired(true).add(new LengthValidator().min(4).max(30)).setLabel(new ResourceModel("Login.nutzername.label")));
        loginForm.add(new Label("nutzername.help", new ResourceModel("Login.nutzername.help")).setEscapeModelStrings(false));
        loginForm.add(new PasswordTextField("passwort", passwort) {
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                tag.put("placeholder", new ResourceModel("Login.passwort.hint").getObject());
            }
        }.setLabel(new ResourceModel("Login.passwort.label")));
        loginForm.add(new Button("submit", new ResourceModel("Login.submit")));
        add(loginForm);
        add(new FeedbackPanel("feedbackModal"));
    }


}
