package pft.module.addressbook.tests;

import org.testng.annotations.Test;
import pft.module.addressbook.model.ContactData;
import pft.module.addressbook.model.Groups;

import java.io.File;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    Groups groups = app.db().groups();
    File photo = new File("src/test/resources/stru.png");
    ContactData newContact = new ContactData().withFirstname("test_name").withLastname("test_surname").withPhoto(photo)
            .inGroup(groups.iterator().next());
    app.goTo().gotoHomePage();
    app.contact().initContactCreation();
    app.contact().fillContactForm(newContact, true);
    app.contact().submitContactCreation();
    app.contact().returnToHomePage();
  }

}
