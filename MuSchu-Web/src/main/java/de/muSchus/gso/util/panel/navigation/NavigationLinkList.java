package de.muSchus.gso.util.panel.navigation;

import de.muSchus.gso.util.Panel;
import org.apache.wicket.Page;
import org.apache.wicket.model.util.ListModel;

import java.util.List;

public class NavigationLinkList extends Panel<List<Class<? extends Page>>> {

    public NavigationLinkList(String id, List<Class<? extends Page>> pageList) {
        super(id, new ListModel<>(pageList));
    }
}
