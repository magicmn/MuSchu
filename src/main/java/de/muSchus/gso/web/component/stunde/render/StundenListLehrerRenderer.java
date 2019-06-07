package de.muSchus.gso.web.component.stunde.render;

import de.muSchus.gso.database.entity.Stunde;
import de.muSchus.gso.web.general.render.LabelRenderer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StundenListLehrerRenderer implements LabelRenderer<Stunde> {
    private final String datePattern;

    public StundenListLehrerRenderer(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public IModel<String> getLabel(Stunde object) {
        List<String> list = new ArrayList<>();
        list.add(
                DateTimeFormatter.ofPattern(datePattern + " HH:mm").format(object.getStart()) +
                        " - " +
                        DateTimeFormatter.ofPattern("HH:mm").format(object.getStart().plusMinutes(object.getDauer()))
        );
        String schueler = object.getKurs().getVertraege().stream().map(vertrag -> vertrag.getSchueler().getVorname()).collect(Collectors.joining(", "));
        list.add(object.getKurs().getKursTyp().getBezeichnung() + " mit " + schueler);
        if (object.getRaum() != null) {
            list.add(object.getRaum().getBezeichnung());
        }
        return Model.of(String.join(" | ", list));
    }
}
