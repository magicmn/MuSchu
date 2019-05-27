package de.muSchus.gso.web.util.model.labeledItem;

import lombok.Data;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.model.IModel;

@Data
public abstract class EventLinkItem<T> implements ILinkItem<T> {

    private final IModel<String> label;
    private boolean stateless = true;
    public abstract void onClick();

    @Override
    public Link<T> createComponent(String id) {
        if (stateless) {
            return new StatelessLink<T>(id) {
                @Override
                public void onClick() {
                    EventLinkItem.this.onClick();
                }
            };
        } else {
            return new Link<T>(id) {
                @Override
                public void onClick() {
                    EventLinkItem.this.onClick();
                }
            };
        }
    }

}
