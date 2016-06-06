package com.malsolec;

import org.junit.Test;
import com.malsolec.formpage.FormPage;
import com.malsolec.formpage.NameFormPage;
import com.malsolec.formpage.SurnameFormPage;
import com.malsolec.model.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NameFormPageTest {

    @Test
    public void saveUserNameTest(){
        User user = new User();
        FormPage formPage = new NameFormPage();

        String newName = "newName";
        formPage.save(newName, user);

        assertEquals("User's name should be changed", newName, user.name);
    }

    @Test
    public void changeViewTest() {
        FormPage formPage = new NameFormPage();
        formPage = formPage.next();
        assertTrue("Next formPage should be surnameFormPage", formPage.getClass().equals(SurnameFormPage.class));
    }

    @Test
    public void getLabelTest(){
        FormPage formPage = new NameFormPage();
        assertEquals("NameFormPage should have correct label value", "Name", formPage.getLabel());
    }

    @Test
    public void getValueTest(){
        User user = new User();
        String userName = "userName";
        user.name = userName;

        FormPage formPage = new NameFormPage();
        assertEquals("NameFormPage should return user's name", userName, formPage.getValue(user));
    }


}
