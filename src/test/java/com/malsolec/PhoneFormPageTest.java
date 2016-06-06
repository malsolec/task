package com.malsolec;

import org.junit.Test;
import com.malsolec.formpage.AddressFormPage;
import com.malsolec.formpage.PhoneFormPage;
import com.malsolec.formpage.FormPage;
import com.malsolec.model.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PhoneFormPageTest {
    @Test
    public void saveUserPhoneTest(){
        User user = new User();
        FormPage formPage = new PhoneFormPage();

        String phoneNumber = "123 456 789";
        formPage.save(phoneNumber, user);

        assertEquals("User's phone number should be changed", phoneNumber, user.phoneNumber);
    }

    @Test
    public void changeViewTest() {
        FormPage formPage = new PhoneFormPage();
        formPage = formPage.back();
        assertTrue("Next formPage should be addressFormPage", formPage.getClass().equals(AddressFormPage.class));
    }

    @Test
    public void getLabelTest(){
        FormPage formPage = new PhoneFormPage();
        assertEquals("PhoneFormPage should have correct label value", "Phone number", formPage.getLabel());
    }

    @Test
    public void getValueTest(){
        User user = new User();
        String userPhoneNumber = "123 456 789";
        user.phoneNumber = userPhoneNumber;

        FormPage formPage = new PhoneFormPage();
        assertEquals("PhoneFormPage should return user's phone number", userPhoneNumber, formPage.getValue(user));
    }
}
