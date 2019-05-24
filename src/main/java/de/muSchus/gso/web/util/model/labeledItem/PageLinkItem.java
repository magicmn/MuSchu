package de.muSchus.gso.web.util.model.labeledItem;

import de.muSchus.gso.web.util.page.BasePage;
import lombok.Data;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Ein PageLinkItem enthält eine {@link BasePage}, welche von Komponenten dazu verwendet wird {@link BookmarkablePageLink}'s
 * zu erzeugen.
 */
@Data
public class PageLinkItem<T extends BasePage> implements ILinkItem<T> {

    @SafeVarargs
    public static Collection<PageLinkItem> of(Class<? extends BasePage>... pages) {
        return of(Arrays.asList(pages));
    }

    public static Collection<PageLinkItem> of(Collection<Class<? extends BasePage>> pages) {
        Collection<PageLinkItem> navigationItems = new ArrayList<>();
        pages.forEach(pageClass -> navigationItems.add(of(pageClass)));
        return navigationItems;
    }

    public static PageLinkItem of(Class<? extends BasePage> page) {
        return page != null ? new PageLinkItem(new ResourceModel(page.getSimpleName()), page) : null;
    }

    private final IModel<String> label;
    /**
     * Seite zu der verlinkt werden soll.
     */
    private final Class<? extends BasePage> page;

    @Override
    public Link<T> createLink(String id) {
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
