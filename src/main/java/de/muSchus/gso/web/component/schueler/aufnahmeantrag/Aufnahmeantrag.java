package de.muSchus.gso.web.component.schueler.aufnahmeantrag;

import com.googlecode.wicket.jquery.ui.form.datepicker.DatePicker;
import de.muSchus.gso.database.entity.Schueler;
import de.muSchus.gso.web.general.panel.Panel;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.util.convert.IConverter;

public class Aufnahmeantrag extends Panel {

    public Aufnahmeantrag(String id) {
        super(id);
        initComponents();
    }

    @Override
    protected IConverter<?> createConverter(Class<?> type) {
        return super.createConverter(type);
    }

    private void initComponents() {
        Form<Schueler> antrag = new StatelessForm<>("antrag", new CompoundPropertyModel<>(new Schueler()));
        antrag.add(new TextField<>("nachname").setLabel(new ResourceModel("Schueler.nachname")));
        antrag.add(new TextField<>("vorname").setLabel(new ResourceModel("Schueler.vorname")));
        antrag.add(new DatePicker("geburtsdatum").setLabel(new ResourceModel("Schueler.geburtsdatum")));
        antrag.add(new TextField<>("postleitzahl").setLabel(new ResourceModel("Schueler.postleitzahl")));
        antrag.add(new TextField<>("ort").setLabel(new ResourceModel("Schueler.ort")));
        antrag.add(new TextField<>("strasse").setLabel(new ResourceModel("Schueler.strasse")));
        antrag.add(new TextField<>("telefonnummer").setLabel(new ResourceModel("Schueler.telefonnummer")));
        antrag.add(new TextField<>("email").setLabel(new ResourceModel("Schueler.email")));
        //antrag.add(new Palette<>("wunschkurse", new AllKuryTypLDM(), new ChoiceRenderer<>("bezeichnung"), 5, false));
        add(antrag);
    }
}
