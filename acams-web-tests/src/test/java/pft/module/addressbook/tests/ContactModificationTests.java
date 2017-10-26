package pft.module.addressbook.tests;

import org.testng.annotations.Test;
import pft.module.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test(enabled = false)
  public void testContactModification() {
    app.goTo().gotoHomePage();
    app.contact().initContactModification();
    app.contact().fillContactForm(
            new ContactData().withFirstname("test_name").withFirstname("test_surname"), false);
    app.contact().submitContactModification();
    app.contact().returnToHomePage();
  }

}
