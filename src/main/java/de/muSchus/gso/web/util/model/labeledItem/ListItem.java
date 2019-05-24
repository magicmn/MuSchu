package de.muSchus.gso.web.util.model.labeledItem;

import de.muSchus.gso.web.util.page.BasePage;
import lombok.*;
import org.apache.wicket.model.IModel;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Ein ListItem welche {@link ILabeledItem}'s enthält. Hierbei kann ein ListItem auch, ein
 * anderes ListItem enthalten und ermöglicht somit theretisch komplexe Verschachtlungen. Diese müssen jedoch von der
 * Komponente unterstützt werden.
 */
@Data
public class ListItem implements ILabeledItem, Iterable<ILabeledItem> {

    /**
     * Generiert ListItem aus Array an LabeledItems
     */
    public static ListItem of(IModel<String> label, ILabeledItem... items) {
        return new ListItem(label, Arrays.asList(items));
    }

    /**
     * Generiert ListItem bestehend aus {@link PageLinkItem} aus Array an {@link BasePage}'s
     */
    @SafeVarargs
    public static ListItem of(IModel<String> label, Class<? extends BasePage>... pages) {
        return of(label, Arrays.asList(pages));
    }

    /**
     * Generiert ListItem bestehend aus {@link PageLinkItem} aus Collection an {@link BasePage}'s
     */
    public static ListItem of(IModel<String> label, Collection<Class<? extends BasePage>> pages) {
        return new ListItem(label, PageLinkItem.of(pages));
    }

    private final IModel<String> label;
    /**
     * Collection der enthaltenen LabeledItems
     */
    private final Collection<? extends ILabeledItem> items;

    @SuppressWarnings("unchecked")
    @Override
    public Iterator<ILabeledItem> iterator() {
        return (Iterator<ILabeledItem>) items.iterator();
    }

    @Override
    public void forEach(Consumer<? super ILabeledItem> consumer) {
        items.forEach(consumer);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Spliterator<ILabeledItem> spliterator() {
        return (Spliterator<ILabeledItem>) items.spliterator();
    }
}
