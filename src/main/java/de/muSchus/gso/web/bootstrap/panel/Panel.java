package de.muSchus.gso.web.bootstrap.panel;

import org.apache.wicket.Component;
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

    /**
     * Gibts das im Panel eingebettet Objekt zurück. Ist das Model null wird null zurück gegeben.
     * @return Objekt des Models
     */
    @SuppressWarnings("unchecked")
    public T getModelObject() {
        return (T) getDefaultModelObject();
    }

    /**
     * Setzt das Objekt das im Panel eingebettet ist. Es wird ebenfalls
     * {@link Component#onModelChanged()} und {@link Component#onModelChanging()} aufegrufen.
     * @param object
     */
    public void setModelObject(T object) {
        setDefaultModelObject(object);
    }

    /**
     * @return Das eingebettete Model
     */
    @SuppressWarnings("unchecked")
    public IModel<T> getModel() {
        return (IModel<T>) getDefaultModel();
    }

    /**
     * @param model Das gesetzt werden soll. Löst {@link Component#onModelChanged()} und {@link Component#onModelChanging()} aus.
     */
    public void setModel(IModel<T> model) {
        setDefaultModel(model);
    }


}
