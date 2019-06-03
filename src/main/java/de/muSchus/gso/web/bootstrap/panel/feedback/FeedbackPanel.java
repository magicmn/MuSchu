package de.muSchus.gso.web.bootstrap.panel.feedback;

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
        String css;
        switch (message.getLevel()){
            case FeedbackMessage.SUCCESS:
                css = "alert-success";
                break;
            case FeedbackMessage.INFO:
                css = "alert-info";
                break;
            case FeedbackMessage.ERROR:
                css = "alert-danger";
                break;
            default:
                css = "alert-dark";
        }

        return css;
    }
}
