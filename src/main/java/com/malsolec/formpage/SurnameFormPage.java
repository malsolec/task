package com.malsolec.formpage;

import com.malsolec.model.User;

public class SurnameFormPage implements FormPage {

    private static final String VIEW_LABEL = "Surname";

    @Override
    public void save(String value, User user) {
        user.surname = value;
    }

    @Override
    public FormPage next() {
        return new AddressFormPage();
    }

    @Override
    public FormPage back() {
        return new NameFormPage();
    }

    @Override
    public String getLabel() {
        return VIEW_LABEL;
    }

    @Override
    public String getValue(User user) {
        return user.surname;
    }

    @Override
    public FormPagePosition getViewPosition() {
        return FormPagePosition.MIDDLE;
    }
}
