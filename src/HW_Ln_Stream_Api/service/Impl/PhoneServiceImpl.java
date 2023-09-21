package HW_Ln_Stream_Api.service.Impl;

import HW_Ln_Stream_Api.db.DateBase;
import HW_Ln_Stream_Api.model.Phone;
import HW_Ln_Stream_Api.service.PhoneService;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PhoneServiceImpl implements PhoneService {
    private DateBase db;

    public PhoneServiceImpl(DateBase db) {
        this.db = db;
    }

    public DateBase getDb() {
        return db;
    }

    @Override
    public String addPhone(Phone phone) {
        List<Phone>list=db.getPhone();
        list.add(phone);
        return "added new Phone : "+phone;
    }

    @Override
    public void getPhoneById(int phoneId) {
        List<Phone>list=db.getPhone();
        list.stream().filter(phone -> phone.getId() == phoneId)
                .forEach(System.out::println);
    }

    @Override
    public Phone updatePhoneNameById(int phoneId, String newName) {
        List<Phone> list = db.getPhone();
        Optional<Phone> phoneToUpdate = list.stream()
                .filter(phone -> phone.getId() == phoneId)
                .findFirst();
        if (phoneToUpdate.isPresent()) {
            Phone updatedPhone = phoneToUpdate.get();
            updatedPhone.setName(newName);
            return updatedPhone;
        } else {
            System.out.println("К сожалению, телефон с ID " + phoneId + " не найден");
        }
        return null;
    }

    @Override
    public List<Phone> getAllPhones() {
        List<Phone>list=db.getPhone();
        if(list.isEmpty()){
            list.forEach(System.out::println);
        }else {
            System.out.println("Unfortunately you don't have a phone !");
        }
        return list;
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        List<Phone>list=db.getPhone();
        if (!list.isEmpty()) {
            List<Phone> phonesByBrand = list.stream()
                    .filter(phone -> phone.getBrand().equals(brand))
                    .collect(Collectors.toList());
            return phonesByBrand;
        } else {
            System.out.println("К сожалению, у вас нет телефона такого бренда");
        }
        return null;
    }

    @Override
    public void deletePhoneById(int phoneId) {
        List<Phone> list = db.getPhone();

        if (!list.isEmpty()) {
            Iterator<Phone> iterator = list.iterator();
            while (iterator.hasNext()) {
                Phone phone = iterator.next();
                if (phone.getId() == phoneId) {
                    iterator.remove();
                    System.out.println("Deleted phone with ID: " + phoneId);
                }
            }
        } else {
            System.out.println("The list of phones is empty.");
        }
    }
}
