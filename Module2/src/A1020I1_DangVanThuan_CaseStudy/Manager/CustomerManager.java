package A1020I1_DangVanThuan_CaseStudy.Manager;

import A1020I1_DangVanThuan_CaseStudy.Commons.FileUtils;
import A1020I1_DangVanThuan_CaseStudy.Commons.FuncValidation.CheckCustomer;
import A1020I1_DangVanThuan_CaseStudy.Commons.ExceptionCustomer.*;
import A1020I1_DangVanThuan_CaseStudy.Models.Booking;
import A1020I1_DangVanThuan_CaseStudy.Models.Customer;

import java.util.*;

import static A1020I1_DangVanThuan_CaseStudy.Controllers.MainController.displayMainMenu;
import static A1020I1_DangVanThuan_CaseStudy.Manager.BookingManager.FILE_NAME_BOOKING;

public class CustomerManager {
    public static final String FILE_NAME_CUSTOMER = "src\\A1020I1_DangVanThuan_CaseStudy\\Data\\Customer.csv";
    private static ArrayList<A1020I1_DangVanThuan_CaseStudy.Models.Customer> listCustomer = new ArrayList<>();
    public static final String COMMA = ",";
    static Scanner input = new Scanner(System.in);
    static boolean check;

    public static void addNewCustomer(A1020I1_DangVanThuan_CaseStudy.Models.Customer customer) {
        String fullName;
        String dateOfBirth;
        String gender;
        String email;
        String address;
        String typeCustomer;
        String phone;
        String idCard;
        // Name
        do {
            check = true;
            try {
                System.out.println("Input Full Name Customer: ");
                fullName = input.nextLine();
                CheckCustomer.checkNameCustomer(fullName);
                customer.setNameCustomer(fullName);
            } catch (NameException e) {
                System.err.println(e);
                check = false;
            }
        } while (!check);
        // dob
        do {
            check = true;
            try {
                System.out.println("Input Day of Birth Customer: ");
                dateOfBirth = input.nextLine();
                CheckCustomer.checkDayOfBirth(dateOfBirth);
                customer.setDayOfBirth(dateOfBirth);
            } catch (BirthdayException e) {
                System.err.println(e);
                check = false;
            }
        } while (!check);
        // gender
        do {
            check = true;
            try {
                String tempGender = "";
                System.out.println("Input Gender Customer: ");
                gender = input.nextLine().toLowerCase();
                CheckCustomer.checkGender(gender);
                for (int i = 0; i < gender.length(); i++) {
                    if (i == 0) {
                        tempGender += gender.charAt(i);
                        tempGender = tempGender.toUpperCase();
                        continue;
                    }
                    tempGender += gender.charAt(i);
                }
                customer.setGender(gender);
            } catch (GenderException e) {
                System.err.println(e);
                check = false;
            }
        } while (!check);
        // idCard
        do {
            check = true;
            try {
                System.out.println("Input ID Card Customer: ");
                idCard = input.nextLine();
                CheckCustomer.checkCardNumber(idCard);
                customer.setCardNumber(idCard);
            } catch (IdCardException e) {
                System.err.println(e);
                check = false;
            }
        } while (!check);
        // phone
        System.out.println("Input Phone Number Customer: ");
        phone = input.nextLine();
        customer.setPhoneNumber(phone);
        // email
        do {
            check = true;
            try {
                System.out.println("Input Email Customer: ");
                email = input.nextLine();
                CheckCustomer.checkEmail(email);
                customer.setEmail(email);
            } catch (EmailException e) {
                System.err.println(e);
                check = false;
            }
        } while (!check);
        check = true;
        // typeCustomer
        do {
            check = true;
            try {
                System.out.println("Input Type Customer: ");
                typeCustomer = input.nextLine();
                CheckCustomer.checkTypeCustomer(typeCustomer);
                customer.setTypeCustomer(typeCustomer);
            } catch (TypeCustomerException e) {
                System.err.println(e);
                check = false;
            }
        } while (!check);
        check = true;
        // address
        System.out.println("Input Address Customer: ");
        address = input.nextLine();
        customer.setAddress(address);
        listCustomer.add(customer);
        String line;
        line = customer.getNameCustomer() + COMMA + customer.getDayOfBirth() + COMMA + customer.getGender()
                + COMMA + customer.getCardNumber() + COMMA + customer.getPhoneNumber()
                + COMMA + customer.getEmail() + COMMA + customer.getTypeCustomer() + COMMA + customer.getAddress();
        FileUtils.writeFile(FILE_NAME_CUSTOMER, line);
        System.out.println("Thêm thành công Customer, Enter để tiếp tục!!!");
        input.nextLine();
        displayMainMenu();
    }

    public static void showInformationCustomers() {
        listCustomer = FileUtils.getFileCSVToListCustomer();
        Collections.sort(listCustomer);

        for (int i = 0; i < listCustomer.size(); i++) {
            listCustomer.get(i).showInfor();
        }
        displayMainMenu();
    }

    public static void bookingCinema(List<Booking> bookingList, Booking booking, int choose) {
        List<Customer> customerList = FileUtils.getFileCSVToListCustomer();
        for (int i = 0; i < customerList.size(); i++) {
            System.out.print("ID: " + (i + 1) + " ");
            customerList.get(i).showInfor();
        }
        System.out.println("Choose one customer to booking ticket: ");
        choose = input.nextInt();
        Customer customer = customerList.get(choose - 1);
        booking.setIdCustomer(customer.getNameCustomer());
//        booking.setIdService("Booking ticket 4D");
        bookingList.add(booking);
        Queue<String> bookings = new LinkedList<>();
        bookings.offer(booking.getIdCustomer());
        for (int i = 0; i < bookings.size(); i++){
            bookings.offer(bookingList.get(i).getIdCustomer());
        }
        System.out.println("");
        displayMainMenu();
    }
}
