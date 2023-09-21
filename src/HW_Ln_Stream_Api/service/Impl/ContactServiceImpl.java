package HW_Ln_Stream_Api.service.Impl;

import HW_Ln_Stream_Api.db.DateBase;
import HW_Ln_Stream_Api.model.Contact;
import HW_Ln_Stream_Api.model.Phone;
import HW_Ln_Stream_Api.service.ContactService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ContactServiceImpl implements ContactService {
    DateBase dateBase;

    public ContactServiceImpl(DateBase dateBase) {
        this.dateBase = dateBase;
    }

    public DateBase db() {
        return dateBase;
    }

    public void setDateBase(DateBase dateBase) {
        this.dateBase = dateBase;
    }

    @Override
    public String addContactToPhone(int phoneId, Contact contact) {
        List<Phone> list = db().getPhone();
        for (Phone phone : list) {
            if (phone.getId() == phoneId) {
                List<Contact> contacts = dateBase.getContacts();
                contacts.add(contact);
            }else {
                System.out.println("unfortunately, there is no phone with this id "+phoneId);
            }
        }
        return "added new contact\n"+contact ;
    }

    @Override
    public void findContactByName(int phoneId, String contactName) {
        List<Phone> phones = dateBase.getPhone();
        Optional<Phone> foundPhone = phones
                .stream()
                .filter(phone -> phone
                .getId() == phoneId)
                .findFirst();

        if (foundPhone.isPresent()) {
            Phone phone = foundPhone.get();
            List<Contact> contacts = phone.getContacts();
            System.out.println(contacts.stream().filter(contact -> contact.getName().equals(contactName)).findFirst());

        }
    }

    @Override
    public Contact findContactByPhoneNumber(int phoneId, String phoneNumber) {
        List<Phone> phones = dateBase.getPhone();
        Optional<Phone> foundPhone = phones.stream().filter(phone -> phone.getId() == phoneId).findFirst();
        if (foundPhone.isPresent()) {
            Phone phone = foundPhone.get();
            List<Contact> contacts = phone.getContacts();
            Optional<Contact> foundContact = contacts
                    .stream()
                    .filter(contact -> contact
                            .getPhoneNumbers()
                            .equals(phoneNumber)).findFirst();

            if (foundContact.isPresent()) {
                return foundContact.get();
            }
            else {
                System.out.println("unfortunately, there is no phone with this id "+phoneId);
            }
        }
        return null;
    }

    @Override
    public List<Contact> sortContactsByName(int phoneId) {
            List<Phone> phones = dateBase.getPhone();
            if (phones == null) {
                return Collections.emptyList();
            }
            List<Contact> sortedContacts = phones.stream()
                    .filter(phone -> phone.getId() == phoneId)
                    .flatMap(phone -> phone.getContacts().stream())
                    .sorted(Comparator.comparing(Contact::getName))
                    .collect(Collectors.toList());
            sortedContacts.forEach(System.out::println);
            return sortedContacts;
        }

    @Override
    public void deleteContactByNameFromPhone(int phoneId, String contactName) {
        Phone phone = dateBase.getPhone().get(phoneId);
        if (phone != null) {
            phone.getContacts().removeIf(pp -> pp.getName().equals(contactName));
            System.out.println("contact deleted "+contactName);
        }else {
            System.out.println("unfortunately, there is no phone with this id "+phoneId);
        }
    }
}

