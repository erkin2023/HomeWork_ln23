package HW_Ln_Stream_Api.service;

import HW_Ln_Stream_Api.model.Phone;

import java.util.List;

public interface PhoneService {
    String addPhone(Phone phone);

    // with stream

    void getPhoneById(int phoneId);

    // with stream

    Phone updatePhoneNameById(int phoneId, String newName);

    // with stream

    List<Phone> getAllPhones();

    // with stream

    List<Phone> getAllPhonesByBrand(String brand);

    void deletePhoneById(int phoneId);
}
