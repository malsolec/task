package test.java.com.malsolec;

import org.junit.Test;
import com.malsolec.formpage.AddressFormPage;
import com.malsolec.formpage.FormPage;
import com.malsolec.formpage.PhoneFormPage;
import com.malsolec.formpage.SurnameFormPage;
import com.malsolec.model.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddressFormPageTest {

    @Test
    public void saveUserAddressTest(){
        User user = new User();
        String name = "Name", surname = "Surname";
        user.name = name;
        user.surname = surname;
        FormPage formPage = new AddressFormPage();

        String newAddress = "newAddress";
        formPage.save(newAddress, user);

        assertEquals("User's address should be changed", newAddress, user.address);
        assertEquals("User's name should not be changed ", name, user.name);
        assertEquals("User's surname should not be changed ", surname, user.surname);
    }


    @Test
    public void changeViewTest() {
        FormPage formPage = new AddressFormPage();
        formPage = formPage.next();
        assertTrue("Next formPage should be PhoneFormPage", formPage.getClass().equals(PhoneFormPage.class));
    }

    @Test
    public void changeBackViewTest() {
        FormPage formPage = new AddressFormPage();
        formPage = formPage.back();
        assertTrue("Next formPage should be SurnameFormPage", formPage.getClass().equals(SurnameFormPage.class));
    }

    @Test public void getLabelTest(){
        FormPage formPage = new AddressFormPage();
        assertEquals("AddressFormPage should have correct label value", "Address", formPage.getLabel());
    }

    @Test
    public void getValueTest(){
        User user = new User();
        String userAddress = "userAddress";
        user.address = userAddress;

        FormPage formPage = new AddressFormPage();
        assertEquals("AddressFormPage should return user's address", userAddress, formPage.getValue(user));
    }

}
