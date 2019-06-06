package de.muSchus.gso.web.panel.stunde.list;

import de.muSchus.gso.database.entity.Stunde;
import de.muSchus.gso.database.repository.StundeRepository;
import de.muSchus.gso.web.bootstrap.panel.Panel;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StundenPanel extends Panel<Stunde> {

    @SpringBean
    private StundeRepository stundeRepository;

    public StundenPanel(String id, String datePrefix, IModel<Stunde> model) {
        super(id, model);
        initComponents(datePrefix);
    }

    private void initComponents(String datePrefix) {
        WebMarkupContainer detailsPanel = new WebMarkupContainer("details");
        add(detailsPanel);
        detailsPanel.setOutputMarkupId(true);
        add(new Button("stundenToggle", createStundenLabel(datePrefix)) {
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                tag.put("data-target", "#" + detailsPanel.getMarkupId());
            }
        });
        Label raumWarning = new Label("raumWarning", new ResourceModel("Stunde.raum.null"));
        if (getModelObject().getRaum() != null) {
            raumWarning.setVisible(false);
        }
        detailsPanel.add(raumWarning);
        Form<Stunde> form = new Form<>("form", new CompoundPropertyModel<>(getModel()));
        form.setOutputMarkupId(true);
        detailsPanel.add(form);
        TextArea inhalt = new TextArea<>("inhalt");
        inhalt.setLabel(new ResourceModel("Stunde.inhalt.label"));
        inhalt.add(new AjaxFormComponentUpdatingBehavior("focusout") {
            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                stundeRepository.save(getModelObject());
            }
        });
        inhalt.setConvertEmptyInputStringToNull(true);
        form.add(inhalt);
    }

    public IModel<String> createStundenLabel(String datePrefix) {
        String zeit = DateTimeFormatter.ofPattern(datePrefix + " HH:mm").format(getModelObject().getStart());
        zeit = zeit + " - " + DateTimeFormatter.ofPattern("HH:mm").format(getModelObject().getStart().plusMinutes(getModelObject().getDauer()));
        String schueler = getModelObject().getKurs().getVertraege().stream().map(vertrag -> vertrag.getSchueler().getVorname()).collect(Collectors.joining(", "));
        List<String> list = new ArrayList<>();
        list.add(zeit);
        if (getModelObject().getRaum() != null) {
            list.add(getModelObject().getRaum().getBezeichnung());
        }
        list.add(getModelObject().getKurs().getKursTyp().getBezeichnung() + " mit " + schueler);
        return Model.of(String.join(" | ", list));
    }
}
