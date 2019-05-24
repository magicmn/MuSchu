package de.muSchus.gso.web.util.panel.navigation;

import de.muSchus.gso.web.util.model.labeledItem.ILinkItem;
import de.muSchus.gso.web.util.model.labeledItem.PageLinkItem;
import de.muSchus.gso.web.util.panel.Panel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;

/**
 * Erzeugt aus einem {@link PageLinkItem} ein {@link BookmarkablePageLink} mit HTML.
 */
public class NavigationLink extends Panel<ILinkItem> {

    public NavigationLink(String id, IModel<ILinkItem> model) {
        super(id, model);
        initComponets();
    }

    private void initComponets() {
        Link link = getModelObject().createLink("link");
        link.add(new Label("linkText", getModelObject().getLabel()));
        add(link);
    }
}