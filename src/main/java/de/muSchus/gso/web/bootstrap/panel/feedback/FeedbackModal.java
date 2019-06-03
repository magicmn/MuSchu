package de.muSchus.gso.web.bootstrap.panel.feedback;

import org.apache.wicket.feedback.IFeedbackMessageFilter;

public class FeedbackModal extends FeedbackPanel {

    public FeedbackModal(String id) {
        super(id);
    }

    public FeedbackModal(String id, IFeedbackMessageFilter filter) {
        super(id, filter);
    }
}
