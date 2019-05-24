package de.muSchus.gso.web.util.model.labeledItem;

import lombok.Data;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;

@Data
public abstract class EventLinkItem implements ILinkItem {

    private final IModel<String> label;
    private boolean stateless;
    public abstract void onCLick();

    @Override
    public Link<Void> createLink(String id) {
        return new Link<Void>(id) {
            @Override
            public void onClick() {
                EventLinkItem.this.onCLick();
            }
        };
    }

}
