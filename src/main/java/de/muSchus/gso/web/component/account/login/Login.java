package de.muSchus.gso.web.component.account.login;

import de.muSchus.gso.database.entity.Account;
import de.muSchus.gso.web.general.MuSchuSession;
import de.muSchus.gso.web.general.panel.feedback.FeedbackPanel;
import de.muSchus.gso.web.general.validator.LengthValidator;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.ResourceModel;

public class Login extends Panel {

    public Login(String id) {
        super(id);
        setOutputMarkupId(true);
        add(new Label("login.info", new ResourceModel("Login")));
        Form<Account> loginForm = new StatelessForm<>("accountForm", new CompoundPropertyModel<>(new Account())) {
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
