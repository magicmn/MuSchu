package de.muSchus.gso.util.panel.navigation;

import de.muSchus.gso.util.Panel;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.io.IClusterable;

public class NavigationLink extends Panel<Class<? extends Page>> implements IClusterable {

    public NavigationLink(String id, Class<? extends Page> page) {
        super(id, Model.of(page));
        BookmarkablePageLink pageLink = new BookmarkablePageLink("link", getModelObject());
        add(pageLink);
        pageLink.add(new Label("linkText", getModelObject().getSimpleName()));
    }
}