package de.muSchus.gso.web.component.stunde.list;

import de.muSchus.gso.database.entity.Stunde;
import de.muSchus.gso.database.repository.StundeRepository;
import de.muSchus.gso.web.general.panel.Panel;
import de.muSchus.gso.web.general.panel.feedback.FeedbackPanel;
import de.muSchus.gso.web.general.render.LabelRenderer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
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
    private LabelRenderer<Stunde> labelRenderer;

    public StundenPanel(String id, IModel<Stunde> model, LabelRenderer<Stunde> labelRenderer) {
        super(id, model);
        this.labelRenderer = labelRenderer;
        initComponents();
    }

    private void initComponents() {
        WebMarkupContainer detailsPanel = new WebMarkupContainer("details");
        add(detailsPanel);
        detailsPanel.setOutputMarkupId(true);
        add(new Button("stundenToggle", labelRenderer.getLabel(getModelObject())) {
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                tag.put("data-target", "#" + detailsPanel.getMarkupId());
            }
        });
        Label raumWarn = new Label("raumWarning", new ResourceModel("Stunde.raum.null"));
        detailsPanel.add(raumWarn);
        if (getModelObject().getRaum() != null) {
            raumWarn.setVisible(false);
        }
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
}
