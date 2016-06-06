package com.malsolec.formpage;

import com.malsolec.model.User;

public class NameFormPage implements FormPage {

    private static final String VIEW_LABEL = "Name";

    @Override
    public void save(String value, User user) {
        user.name = value;
    }

    @Override
    public FormPage next() {
        return new SurnameFormPage();
    }

    @Override
    public FormPage back() {
        return null;
    }

    @Override
    public String getLabel() {
        return VIEW_LABEL;
    }

    @Override
    public String getValue(User user) {
        return user.name;
    }

    @Override
    public FormPagePosition getViewPosition() {
        return FormPagePosition.FIRST;
    }


}
