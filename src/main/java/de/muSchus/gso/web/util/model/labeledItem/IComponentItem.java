package de.muSchus.gso.web.util.model.labeledItem;

public interface IComponentItem<T> extends ILabeledItem {

    T createComponent(String id);
}
