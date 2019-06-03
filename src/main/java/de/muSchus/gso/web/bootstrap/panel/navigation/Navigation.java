package de.muSchus.gso.web.bootstrap.panel.navigation;

import de.muSchus.gso.web.MuSchuSession;
import de.muSchus.gso.web.bootstrap.panel.Panel;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;

import java.util.Collection;

/**
 * Simple Navigation basierend auf Bootstrap, welche {@link Page}s anzeigt. Der Klassenname wird automatisch verwendet
 * um daraus ein Label zu generieren.
 */
public class Navigation extends Panel<Collection<Class<? extends Page>>> {

    private RepeatingView navigationItems;

    public Navigation(String id, IModel<Collection<Class<? extends Page>>> model) {
        super(id, model);
        initComponents();
        onModelChanged();
    }

    /**
     * Rendert alle {@link Page}'s der Navigation neu, wenn sich das Model ändert.
     *
     * @see Component#onModelChanged()
     */
    @Override
    protected void onModelChanged() {
        super.onModelChanged();
        navigationItems.removeAll();
        getModelObject().forEach(this::addItem);
    }

    private void initComponents() {
        add(navigationItems = new RepeatingView("navItems"));
    }

    private void addItem(Class<? extends Page> page) {
        if (isInstaniationAuthorized(page)) {
            WebMarkupContainer listItem = new WebMarkupContainer(navigationItems.newChildId());
            listItem.add(new BookmarkablePageLink<Page>("pageLink", page) {
                @Override
                protected void onComponentTag(ComponentTag tag) {
                    super.onComponentTag(tag);
                    if (getPage().getClass().equals(page)) {
                        tag.put("class", tag.getAttribute("class") + " active");
                    }
                }
            }.setBody(new ResourceModel(page.getSimpleName())));
            navigationItems.add(listItem);
        }
    }

    private boolean isInstaniationAuthorized(Class<? extends Page> page) {
        AuthorizeInstantiation[] instantiations = page.getAnnotationsByType(AuthorizeInstantiation.class);
        if (instantiations.length == 0) {
            return true;
        } else {
            for (AuthorizeInstantiation instantiation : instantiations) {
                if (MuSchuSession.get().getRoles().hasAnyRole(new Roles(instantiation.value()))) {
                    return true;
                }
            }
            return false;
        }
    }

}
