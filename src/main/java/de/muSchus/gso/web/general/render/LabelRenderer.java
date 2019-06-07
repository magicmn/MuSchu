package de.muSchus.gso.web.general.render;

import org.apache.wicket.model.IModel;

import java.io.Serializable;

public interface LabelRenderer<T> extends Serializable {
    IModel<String> getLabel(T object);
}
