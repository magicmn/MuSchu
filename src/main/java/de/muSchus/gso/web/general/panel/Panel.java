package de.muSchus.gso.web.general.panel;

import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

/**
 * {@link org.apache.wicket.markup.html.panel.Panel} mit Möglichkeit zur
 * Typsicherheit für in Panels eingebette {@link IModel}.
 * @param <T> Typ des Models.
 */
@SuppressWarnings("unchecked")
public class Panel<T> extends org.apache.wicket.markup.html.panel.Panel {

    public Panel(String id) {
        super(id);
    }

    public Panel(String id, IModel<T> model) {
        super(id, model);
    }

    /**
     * Gibts das im Panel eingebettet Objekt zurück. Ist das Model null wird null zurück gegeben.
     * @return Objekt des Models
     */
    public T getModelObject() {
        return (T) getDefaultModelObject();
    }

    /**
     * Setzt das Objekt das im Panel eingebettet ist. Es wird ebenfalls
     * {@link Component#onModelChanged()} und {@link Component#onModelChanging()} aufegrufen.
     * @param object
     */
    public Panel<T> setModelObject(T object) {
        return (Panel<T>) setDefaultModelObject(object);
    }

    /**
     * @return Das eingebettete Model
     */
    public IModel<T> getModel() {
        return (IModel<T>) getDefaultModel();
    }

    /**
     * @param model Das gesetzt werden soll. Löst {@link Component#onModelChanged()} und {@link Component#onModelChanging()} aus.
     */
    public Panel<T> setModel(IModel<T> model) {
        return (Panel<T>) setDefaultModel(model);
    }
}
