package de.muSchus.gso.util.panel.navigation;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;

import java.util.Arrays;
import java.util.List;

/**
 * Simple Navigation, welche sowohl einfache Links als auch DropDowns bestehend aus Links enthält.
 */
public class Navigation extends Panel {

    private RepeatingView navigationItems;

    public Navigation(String id) {
        super(id);
        init();
    }

    private void init() {
        navigationItems = new RepeatingView("navItems");
        add(navigationItems);
    }

    public void addNavItem(Class<? extends Page> navItem) {
        navigationItems.add(newNavItem(navigationItems.newChildId(), navItem));
    }

    public void addNavItem(List<Class<? extends Page>> navItem) {
        navigationItems.add(newNavItem(navigationItems.newChildId(), navItem));
    }

    public void addNavItem(Class<? extends Page>... navItem) {
        addNavItem(Arrays.asList(navItem));
    }

    protected MarkupContainer newNavItem(String id, Class<? extends Page> navItem) {
        return new WebMarkupContainer(id).add(new NavigationLink("listItem", navItem));
    }

    protected MarkupContainer newNavItem(String id, List<Class<? extends Page>> navItemList) {
        return new WebMarkupContainer(id).add(new NavigationLinkList("listItem", navItemList));
    }
}
