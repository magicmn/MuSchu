package de.muSchus.gso.util;

import org.apache.wicket.model.IModel;

/**
 * {@link org.apache.wicket.markup.html.panel.Panel} mit Möglichkeit zur
 * Typsicherheit für in Panels eingebette {@link IModel}.
 * @param <T> Typ des Models.
 */
public class Panel<T> extends org.apache.wicket.markup.html.panel.Panel {

    public Panel(String id) {
        super(id);
    }

    public Panel(String id, IModel<T> model) {
        super(id, model);
    }

    @SuppressWarnings("unchecked")
    public T getModelObject() {
        return (T) getDefaultModelObject();
    }

    public void setModelObject(T object) {
        setDefaultModelObject(object);
    }

    @SuppressWarnings("unchecked")
    public IModel<T> getModel() {
        return (IModel<T>) getDefaultModel();
    }

    public void setModel(IModel<T> model) {
        setDefaultModel(model);
    }


}
