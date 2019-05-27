package de.muSchus.gso.web.util.validator;

import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

public class LengthValidator extends Behavior implements IValidator<String> {

    private int min = -1;
    private int max = 1000;

    public LengthValidator min(int min) {
        this.min = min;
        return this;
    }

    public LengthValidator max(int max) {
        this.max = max;
        return this;
    }

    /*@Override
    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);
        tag.put("minlength", min);
        tag.put("maxlength", max);
    }*/

    @Override
    public void validate(IValidatable<String> validatable) {
        if (validatable.getValue() == null) {
            validatable.error(new ValidationError(this, "null"));
        } else {
            String value = validatable.getValue();
            if (value.length() < min && value.length() > max) {
                validatable.error(new ValidationError(this, "minMax")
                        .setVariable("min", min)
                        .setVariable("max", max));
            } else if (value.length() < min) {
                validatable.error(new ValidationError(this, "min").setVariable("min", min));
            } else if (value.length() > max) {
                validatable.error(new ValidationError(this, "max").setVariable("max", max));
            }
        }
    }
}
