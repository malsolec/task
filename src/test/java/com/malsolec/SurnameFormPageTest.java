package com.malsolec;

import org.junit.Test;
import com.malsolec.formpage.AddressFormPage;
import com.malsolec.formpage.NameFormPage;
import com.malsolec.formpage.FormPage;
import com.malsolec.formpage.SurnameFormPage;
import com.malsolec.model.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SurnameFormPageTest {

    @Test
    public void saveUserSurnameTest(){
        User user = new User();
        String name = "Name";
        user.name = name;
        FormPage formPage = new SurnameFormPage();

        String newSurname = "newSurname";
        formPage.save(newSurname, user);

        assertEquals("User's surname should be changed", newSurname, user.surname);
        assertEquals("User's name should not be changed ", name, user.name);
    }


    @Test
    public void changeViewTest() {
        FormPage formPage = new SurnameFormPage();
        formPage = formPage.next();
        assertTrue("Next formPage should be addressFormPage", formPage.getClass().equals(AddressFormPage.class));
    }

    @Test
    public void changeBackViewTest() {
        FormPage formPage = new SurnameFormPage();
        formPage = formPage.back();
        assertTrue("Next formPage should be nameFormPage", formPage.getClass().equals(NameFormPage.class));
    }

    @Test public void getLabelTest(){
        FormPage formPage = new SurnameFormPage();
        assertEquals("SurnameFormPage should have correct label value", "Surname", formPage.getLabel());
    }

    @Test
    public void getValueTest(){
        User user = new User();
        String userSurname = "userSurname";
        user.surname = userSurname;

        FormPage formPage = new SurnameFormPage();
        assertEquals("SurnameFormPage should return user's surname", userSurname, formPage.getValue(user));
    }

}
