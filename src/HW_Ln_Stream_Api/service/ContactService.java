package HW_Ln_Stream_Api.service;

import HW_Ln_Stream_Api.model.Contact;

import java.util.List;

public interface ContactService {
    String addContactToPhone(int phoneId, Contact contact);

    // with stream (телефонду phoneId мн табып, ичинен контантактардын  арасынан contactName мн табып кайтарып берсин)

    void findContactByName(int phoneId, String contactName);

    // with stream

    Contact findContactByPhoneNumber(int phoneId, String phoneNumber);

    // with stream (телефонду phoneId мн табып, ичинен контантактарды аттарын осуу тартибинде чыгарып берсин)

   List<Contact> sortContactsByName(int phoneId);

   void deleteContactByNameFromPhone(int phoneId, String contactName);

}
