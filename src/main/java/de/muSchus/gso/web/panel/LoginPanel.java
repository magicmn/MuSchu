package de.muSchus.gso.web.panel;

import de.muSchus.gso.database.User;
import de.muSchus.gso.web.MuSchuSession;
import de.muSchus.gso.web.util.validator.LengthValidator;
import org.apache.wicket.devutils.stateless.StatelessComponent;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.ResourceModel;

@StatelessComponent
public class LoginPanel extends Panel {

    public LoginPanel(String id) {
        super(id);
        setOutputMarkupId(true);
        Form<User> loginForm = new StatelessForm<User>("userForm", new CompoundPropertyModel<>(new User())) {
            @Override
            protected void onSubmit() {
                User user = getModelObject();
                if (MuSchuSession.get().signIn(user.getUsername(), user.getPassword())) {
                    setResponsePage(getPage().getClass());
                } else {
                    error(new ResourceModel("Login.failed").getObject());
                }
            }
        };
        loginForm.add(new TextField<String>("username") {
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                tag.put("placeholder", new ResourceModel("Login.username.hint").getObject());
            }
        }.setRequired(true).add(new LengthValidator().min(4).max(30)).setLabel(new ResourceModel("Login.username.label")));
        loginForm.add(new Label("username.help", new ResourceModel("Login.username.help")));
        loginForm.add(new PasswordTextField("password") {
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                tag.put("placeholder", new ResourceModel("Login.password.hint").getObject());
            }
        }.add(new LengthValidator().min(4).max(30)).setLabel(new ResourceModel("Login.password.label")));
        loginForm.add(new Button("submit", new ResourceModel("Login.submit")));
        add(loginForm);
    }


}
