package de.muSchus.gso.web.util.model.labeledItem;

import de.muSchus.gso.web.util.panel.navigation.Navigation;
import org.apache.wicket.model.IModel;

import java.io.Serializable;

/**
 * Interface für Items, welche bestimmte Inhalte umschließen. Der Inhalt wird zusätzlich durch ein {@link #getLabel()}
 * betitelt. DIes wird z.B. in der {@link Navigation} verwendet um aus den verschieden {@link ILabeledItem}s eine
 * vielseitig anpassbare Navigation zu erstellen. Ob und wie eine Implementation von {@link ILabeledItem} unterstützt
 * wird entscheidet die jeweilige Komponente.
 */
public interface ILabeledItem extends Serializable {

    /**
     * Anzeigetext für das Item.
     * @return Label des Items als Model.
     */
    IModel<String> getLabel();

    /**
     * Anzeigetext für das Item
     * @return Label des Itesm als String.
     */
    default String getLabelModel() {
        return getLabel().getObject();
    }
}
