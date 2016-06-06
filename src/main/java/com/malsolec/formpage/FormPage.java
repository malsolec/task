package com.malsolec.formpage;

import com.malsolec.model.User;

public interface FormPage {
    void save(String value, User user);
    FormPage next();
    FormPage back();
    String getLabel();
    String getValue(User user);
    FormPagePosition getViewPosition();
}
