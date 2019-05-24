package de.muSchus.gso.web.util.model.labeledItem;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import java.lang.reflect.InvocationTargetException;

/**
 * Das PanelItem erlaubt es Komponenten ganze {@link Panel} hinzuzufügen. Da ein Panel nur mit einer Wicket-Id
 * erstellt werden kann, dieser beim erstellen des PanelItems jedoch nicht fest steht, wird Reflection verwendet um
 * aus der Panel-Klasse ein Panel mit Id zu erzeugen. Deshalb muss das angegebene Panel einen Konstruktor haben, welcher
 * nur einen String-Parameter benötigt.
 * Wurde das Panel durch eine Komponente erzeugt, kann mit {@link #getPanel()} auf dieses zugegriffen werden.
 * @param <T> Panel das verwendet wird.
 */
@Data
public class PanelItem<T extends Panel> implements ILabeledItem {

    private final IModel<String> label;
    /**
     * Klasse des Panels.
     */
    private final Class<T> panelClass;
    @Setter(value = AccessLevel.PRIVATE) private T panel;

    /**
     * Erzeugt das Panel mithilfe von Reflection.
     * @param id Id des Panels
     * @return Erzeugtes Panel
     */
    public T createPanel(String id) {
        try {
            T panel = panelClass.getDeclaredConstructor(String.class).newInstance(id);
            setPanel(panel);
            return panel;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }
}
