package com.malsolec.formpage;
import com.malsolec.model.User;

public class AddressFormPage implements FormPage {

    private static final String VIEW_LABEL = "Address";

    @Override
    public void save(String value, User user) {
        user.address = value;
    }

    @Override
    public FormPage next() {
        return new PhoneFormPage();
    }

    @Override
    public FormPage back() {
        return new SurnameFormPage();
    }

    @Override
    public String getLabel() {
        return VIEW_LABEL;
    }

    @Override
    public String getValue(User user) {
        return user.address;
    }

    @Override
    public FormPagePosition getViewPosition() {
        return FormPagePosition.MIDDLE;
    }
}
