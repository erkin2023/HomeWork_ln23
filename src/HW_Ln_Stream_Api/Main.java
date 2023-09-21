package HW_Ln_Stream_Api;
import HW_Ln_Stream_Api.db.DateBase;
import HW_Ln_Stream_Api.model.Contact;
import HW_Ln_Stream_Api.model.Phone;
import HW_Ln_Stream_Api.service.Impl.ContactServiceImpl;
import HW_Ln_Stream_Api.service.Impl.PhoneServiceImpl;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Contact> contacts = new LinkedList<>();
        List<Phone>phones =new LinkedList<>();
        DateBase dateBase = new DateBase(phones,contacts);
        PhoneServiceImpl phoneService = new PhoneServiceImpl(dateBase);
        ContactServiceImpl contactService = new ContactServiceImpl(dateBase);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact by Name");
            System.out.println("3. Search Contact by Phone Number");
            System.out.println("4. List Sorted Contacts by Name");
            System.out.println("5. Delete Contact by Name");
            System.out.println("6. Find Phone by ID");
            System.out.println("7. Delete Phone by ID");
            System.out.println("8. Add Phone");
            System.out.println("9. Update Phone Name by ID");
            System.out.println("10. List All Phones");
            System.out.println("11. List Phones by Brand");
            System.out.println("12. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Введите id  телефона, к которому добавить контакт:");
                    int phoneId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Введите имя контакта:");
                    String name = scanner.nextLine();
                    System.out.println("Введите номер телефона контакта:");
                    String phoneNumber = scanner.nextLine();
                    Contact contact = new Contact(name, phoneNumber);

                    System.out.println(contactService.addContactToPhone(phoneId, contact));
                    break;

                case 2:
                    System.out.println("Введите имя контакта для поиска:");
                    String searchName = scanner.nextLine();
                    System.out.println("Введите id телефона, в котором искать контакт:");
                    int searchPhoneId = scanner.nextInt();
                    scanner.nextLine();

                    contactService.findContactByName(searchPhoneId, searchName);
                    break;
                case 3:
                    System.out.println("Enter the phone number to search:");
                    String searchPhoneNumber = scanner.nextLine();
                    System.out.println("Enter the phone ID to search in:");
                    int searchPhoneIdByNumber = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println(contactService.findContactByPhoneNumber(searchPhoneIdByNumber, searchPhoneNumber));
                    break;
                case 4:
                    System.out.println("Enter the phone ID to list sorted contacts:");
                    int phoneIdToSort = scanner.nextInt();
                    scanner.nextLine();

                    contactService.sortContactsByName(phoneIdToSort);
                    break;

                case 5:
                    System.out.println("Enter contact name to delete:");
                    String contactNameToDelete = scanner.nextLine();
                    System.out.println("Enter phone ID to delete the contact from:");
                    int phoneIdToDeleteContact = scanner.nextInt();
                    scanner.nextLine();

                    contactService.deleteContactByNameFromPhone(phoneIdToDeleteContact, contactNameToDelete);
                    break;

                case 6:
                    System.out.println("Введите ID телефона для поиска:");
                    int phoneIdToFind = scanner.nextInt();
                    scanner.nextLine();

                    phoneService.getPhoneById(phoneIdToFind);
                    break;
                case 7:
                    System.out.println("Введите ID телефона для удаления:");
                    int phoneIdToDelete = scanner.nextInt();
                    scanner.nextLine();

                    phoneService.deletePhoneById(phoneIdToDelete);
                    break;

                case 8:

                    System.out.println("Ведите название телефона");
                    name =scanner.nextLine();
                    System.out.println("Введите марку телефона:");
                    String brand = scanner.nextLine();
                    Phone newPhone = new Phone(name ,brand,contacts);

                    System.out.println(phoneService.addPhone(newPhone));
                    break;

                case 9:
                    System.out.println("Введите ID телефона для обновления:");
                    int phoneIdToUpdate = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Введите новое имя для телефона:");
                    String newName = scanner.nextLine();

                    System.out.println(phoneService.updatePhoneNameById(phoneIdToUpdate, newName));
                    break;

                case 10:
                    System.out.println(phoneService.getAllPhones());
                    break;

                case 11:
                    System.out.println("Введите марку телефона для поиска:");
                    String brandToSearch = scanner.nextLine();
                    System.out.println(phoneService.getAllPhonesByBrand(brandToSearch));
                    break;

                case 12:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте ещё раз.");
                    break;
            }
        }
    }
}

