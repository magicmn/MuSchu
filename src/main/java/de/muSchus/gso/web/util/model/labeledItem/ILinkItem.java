package de.muSchus.gso.web.util.model.labeledItem;

import org.apache.wicket.markup.html.link.Link;

public interface ILinkItem<T> extends ILabeledItem {

    Link<T> createLink(String id);
}
