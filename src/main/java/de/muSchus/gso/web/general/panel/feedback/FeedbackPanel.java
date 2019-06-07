package de.muSchus.gso.web.general.panel.feedback;

import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.IFeedbackMessageFilter;

public class FeedbackPanel extends org.apache.wicket.markup.html.panel.FeedbackPanel {

    public FeedbackPanel(String id) {
        super(id);
    }

    public FeedbackPanel(String id, IFeedbackMessageFilter filter) {
        super(id, filter);
    }

    @Override
    protected String getCSSClass(FeedbackMessage message) {
        switch (message.getLevel()) {
            case FeedbackMessage.SUCCESS:
                return "alert-success";
            case FeedbackMessage.INFO:
                return "alert-info";
            case FeedbackMessage.ERROR:
                return "alert-danger";
            case FeedbackMessage.WARNING:
                return "alert-warning";
            default:
                return "alert-dark";
        }
    }
}
