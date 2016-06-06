package com.malsolec.formpage;

import com.malsolec.model.User;

public class PhoneFormPage implements FormPage {

    private static final String VIEW_LABEL = "Phone number";

    @Override
    public void save(String value, User user) {
        user.phoneNumber = value;
    }

    @Override
    public FormPage next() {
        return null;
    }

    @Override
    public FormPage back() {
        return new AddressFormPage();
    }

    @Override
    public String getLabel() {
        return VIEW_LABEL;
    }

    @Override
    public String getValue(User user) {
        return user.phoneNumber;
    }

    @Override
    public FormPagePosition getViewPosition() {
        return FormPagePosition.LAST;
    }
}
