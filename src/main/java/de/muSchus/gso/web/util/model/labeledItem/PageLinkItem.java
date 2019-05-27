package de.muSchus.gso.web.util.model.labeledItem;

import de.muSchus.gso.web.util.page.BasePage;
import lombok.Data;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;

/**
 * Ein PageLinkItem enthält eine {@link BasePage}, welche von Komponenten dazu verwendet wird {@link BookmarkablePageLink}'s
 * zu erzeugen.
 */
@Data
public class PageLinkItem<T extends BasePage> implements ILinkItem<T> {

    public static PageLinkItem of(Class<? extends BasePage> page) {
        return page != null ? new PageLinkItem(new ResourceModel(page.getSimpleName()), page) : null;
    }

    private final IModel<String> label;
    /**
     * Seite zu der verlinkt werden soll.
     */
    private final Class<? extends BasePage> page;

    @Override
    public BookmarkablePageLink<T> createComponent(String id) {
        return new BookmarkablePageLink<T>(id, page) {
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                if (page.equals(getPage().getClass())) {
                    tag.put("class", tag.getAttribute("class") + " active");
                }
            }
        };
    }

}
