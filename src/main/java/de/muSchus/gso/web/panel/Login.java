package de.muSchus.gso.web.panel;

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
import org.apache.wicket.model.ResourceModel;

@StatelessComponent
@AuthorizeAction(action = "RENDER", roles = Rolle.Constants.LOGGED_OUT)
public class Login extends Panel {

    public Login(String id) {
        super(id);
        setOutputMarkupId(true);
        add(new Label("login.info", new ResourceModel("Login")));
        Form<Account> loginForm = new StatelessForm<Account>("accountForm", new CompoundPropertyModel<>(new Account())) {
            @Override
            protected void onSubmit() {
                Account account = getModelObject();
                if (MuSchuSession.get().signIn(account.getNutzername(), account.getPasswort())) {
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
        loginForm.add(new PasswordTextField("passwort") {
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                tag.put("placeholder", new ResourceModel("Login.passwort.hint").getObject());
            }
        }.add(new LengthValidator().min(4).max(30)).setLabel(new ResourceModel("Login.passwort.label")));
        loginForm.add(new Button("submit", new ResourceModel("Login.submit")));
        add(loginForm);
        add(new FeedbackPanel("feedbackModal"));
    }


}
