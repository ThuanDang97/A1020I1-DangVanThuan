package A1020I1_DangVanThuan_CaseStudy.Manager;

import A1020I1_DangVanThuan_CaseStudy.Commons.FileUtils;
import A1020I1_DangVanThuan_CaseStudy.Commons.FuncValidation.CheckService;
import A1020I1_DangVanThuan_CaseStudy.Models.Booking;
import A1020I1_DangVanThuan_CaseStudy.Models.Customer;
import A1020I1_DangVanThuan_CaseStudy.Models.Villa;

import java.util.*;

import static A1020I1_DangVanThuan_CaseStudy.Manager.BookingManager.FILE_NAME_BOOKING;

public class VillaManager {
    public static final String FILE_NAME_VILLA = "src\\A1020I1_DangVanThuan_CaseStudy\\Data\\Villa.csv";
    private static List<Villa> listVilla = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);
    public static final String COMMA = ",";

    public static void addNewVilla(Villa villa) {
        System.out.println("Nhập ID Villa (SVVL-XXXX ): ");
        String idVillaTemp = input.nextLine();
        while (!CheckService.checkID(idVillaTemp)) {
            System.err.println("Invalid!!! please Input again!!!");
            idVillaTemp = input.nextLine();
        }
        villa.setId(idVillaTemp);
        System.out.println("Nhập Tên Villa: ");
        String nameServicesVillaTemp = input.nextLine();
        while (!CheckService.checkNameServices(nameServicesVillaTemp)) {
            System.err.println("Invalid!!! please Input again!!!");
            nameServicesVillaTemp = input.nextLine();
        }
        villa.setNameServices(nameServicesVillaTemp);
        System.out.println("Nhập Diện Tích Sử Dụng: ");
        String areaUseVillaTemp = input.nextLine();
        while (!CheckService.checkArea(areaUseVillaTemp)) {
            System.err.println("Invalid!!! Area is larger 30!!!");
            areaUseVillaTemp = input.nextLine();
        }
        villa.setAreaUse(areaUseVillaTemp + "");
        System.out.println("Nhập Chi Phí Thuê: ");
        String rentPriceVillaTemp = input.nextLine();
        while (!CheckService.checkRentPrice(rentPriceVillaTemp)) {
            System.err.println("Invalid!!! Rent is positive numbers!!!");
            rentPriceVillaTemp = input.nextLine();
        }
        villa.setRentPrice(rentPriceVillaTemp);
        System.out.println("Nhập Số Lượng Người Tối Đa: ");
        String maxNumberOfPeopleVillaTemp = input.nextLine();
        while (!CheckService.checkMaxNumberOfPeople(maxNumberOfPeopleVillaTemp)) {
            System.err.println("Invalid!!! Max number of people must be greater than 0 and less than 20");
            maxNumberOfPeopleVillaTemp = input.nextLine();
        }
        villa.setMaxNumberOfPeople(maxNumberOfPeopleVillaTemp);
        System.out.println("Thuê theo năm, tháng, ngày hoặc giờ: ");
        String typeRentVillaTemp = input.nextLine();
        while (!CheckService.checkTypeRent(typeRentVillaTemp)) {
            System.err.println("Invalid!!! please Input again!!!");
            typeRentVillaTemp = input.nextLine();
        }
        villa.setTypeRent(typeRentVillaTemp);
        System.out.println("Nhập Tiêu Chuẩn Phòng: ");
        String standardRoomVillaTemp = input.nextLine();
        while (!CheckService.checkStandardRoom(standardRoomVillaTemp)) {
            System.err.println("Invalid!!! please Input again!!! (ex: Vip, Business, Normal)");
            standardRoomVillaTemp = input.nextLine();
        }
        villa.setStandardRoom(standardRoomVillaTemp);
        System.out.println("Nhập Mô Tả Tiện Nghi Khác: ");
        villa.setDescribeConvenient(input.nextLine());
        System.out.println("Nhập Diện Tích Hồ Bơi: ");
        String areaPoolVillaTemp = input.nextLine();
        while (!CheckService.checkArea(areaPoolVillaTemp)) {
            System.err.println("Invalid!!! Area is larger 30!!!");
            areaPoolVillaTemp = input.nextLine();
        }
        villa.setAreaPool(areaPoolVillaTemp);
        System.out.println("Nhập Số Tầng: ");
        String numberOfFloorsVillaTemp = input.nextLine();
        while (!CheckService.checkNumberOfFloors(numberOfFloorsVillaTemp)) {
            System.err.println("Invalid!!! Number of floors is positive numbers!!!");
            numberOfFloorsVillaTemp = input.nextLine();
        }
        villa.setNumberOfFloors(numberOfFloorsVillaTemp);
        listVilla.add(villa);
        String line;
        line = villa.getId() + COMMA + villa.getNameServices() + COMMA + villa.getAreaUse()
                + COMMA + villa.getRentPrice() + COMMA + villa.getMaxNumberOfPeople()
                + COMMA + villa.getTypeRent() + COMMA + villa.getStandardRoom() + COMMA + villa.getDescribeConvenient()
                + COMMA + villa.getAreaPool() + COMMA + villa.getNumberOfFloors();
        FileUtils.writeFile(FILE_NAME_VILLA, line);
    }

    // ---------------- Show All Villa ----------------- //

    public static void showAllVilla() {
        listVilla = FileUtils.getFileCSVToListVilla();
        for (Villa villa : listVilla) {
            villa.showInfor();
        }
    }

    // ---------------- Booking Villa ----------------- //
    public static void bookingVilla(List<Booking> bookingList, List<Customer> customerList, Booking booking, int choose) {
        List<Villa> villaList = FileUtils.getFileCSVToListVilla();
        for (int i = 1; i < villaList.size(); i++) {
            System.out.print("ID: " + (i + 1) + " ");
            villaList.get(i).showInfor();
        }
        System.out.println("Choose one Villa: ");
        int chooseVilla = input.nextInt();
        Villa villa = villaList.get(chooseVilla - 1);
        booking.setIdService(villa.getId());
        bookingList.add(booking);
        String lineBooking;
        for (Booking booking1 : bookingList) {
            lineBooking = booking1.getIdCustomer() + COMMA + booking1.getIdService();
            FileUtils.writeFile(FILE_NAME_BOOKING, lineBooking);
        }
        System.out.println("Đã Booking Villa thành công cho khách hàng: " + customerList.get(choose).getNameCustomer());
    }


    // ---------------- Show All Name Villa Not Duplicate ----------------- //

    public static void showAllNameVillaNotDup() {
        Set<String> nameVillaNotDup = new TreeSet<>();
        List<Villa> villaList = FileUtils.getFileCSVToListVilla();
        for (int i = 0; i < villaList.size(); i++) {
            nameVillaNotDup.add(listVilla.get(i).getNameServices());
        }
        System.out.println("Danh sách các Villa không trùng nhau: ");
        for (String nameVilla : nameVillaNotDup) {
            System.out.println(nameVilla);
        }
    }
}
