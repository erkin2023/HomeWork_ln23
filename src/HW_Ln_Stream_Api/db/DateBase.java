package HW_Ln_Stream_Api.db;

import HW_Ln_Stream_Api.model.Contact;
import HW_Ln_Stream_Api.model.Phone;

import java.util.List;

public class DateBase {
    private List<Phone> phone ;
    private List<Contact>contacts;

    public DateBase(List<Phone> phone, List<Contact> contacts) {
        this.phone = phone;
        this.contacts = contacts;
    }
    public List<Phone> getPhone() {
        return phone;
    }
    public List<Contact> getContacts() {
        return contacts;
    }
    @Override
    public String toString() {
        return "db{" +
                "phone=" + phone +
                '}';
    }
}
