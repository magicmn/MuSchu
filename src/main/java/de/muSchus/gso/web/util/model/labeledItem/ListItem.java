package de.muSchus.gso.web.util.model.labeledItem;

import lombok.Data;
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
