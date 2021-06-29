package A1020I1_DangVanThuan_CaseStudy.Manager;

import A1020I1_DangVanThuan_CaseStudy.Commons.FileUtils;
import A1020I1_DangVanThuan_CaseStudy.Commons.FuncValidation.CheckService;
import A1020I1_DangVanThuan_CaseStudy.Models.Booking;
import A1020I1_DangVanThuan_CaseStudy.Models.Customer;
import A1020I1_DangVanThuan_CaseStudy.Models.House;

import java.util.*;

import static A1020I1_DangVanThuan_CaseStudy.Manager.BookingManager.FILE_NAME_BOOKING;

public class HouseManager {
    private static List<House> listHouse = new ArrayList<>();
    public static final String FILE_NAME_HOUSE = "src\\A1020I1_DangVanThuan_CaseStudy\\Data\\House.csv";
    public static final String COMMA = ",";
    public static Scanner input = new Scanner(System.in);

    public static void addNewHouse(House house) {
        System.out.println("Nhập ID House (SVHO-XXXX) : ");
        String idHouseTemp = input.nextLine();
        while (!CheckService.checkID(idHouseTemp)) {
            System.err.println("Invalid!!! please Input again!!!");
            idHouseTemp = input.nextLine();
        }
        house.setId(idHouseTemp);
        System.out.println("Nhập Tên House: ");
        String nameServicesHouseTemp = input.nextLine();
        while (!CheckService.checkNameServices(nameServicesHouseTemp)) {
            System.err.println("Invalid!!! please Input again!!!");
            nameServicesHouseTemp = input.nextLine();
        }
        house.setNameServices(nameServicesHouseTemp);
        System.out.println("Nhập Diện Tích Sử Dụng: ");
        String areaUseHouseTemp = input.nextLine();
        while (!CheckService.checkArea(areaUseHouseTemp)) {
            System.err.println("Invalid!!! Area is larger 30!!!");
            areaUseHouseTemp = input.nextLine();
        }
        house.setAreaUse(areaUseHouseTemp);
        System.out.println("Nhập Chi Phí Thuê: ");
        String rentPriceHouseTemp = input.nextLine();
        while (!CheckService.checkRentPrice(rentPriceHouseTemp)) {
            System.err.println("Invalid!!! Rent is positive numbers!!!");
            rentPriceHouseTemp = input.nextLine();
        }
        house.setRentPrice(rentPriceHouseTemp);
        System.out.println("Nhập Số Lượng Người Tối Đa: ");
        String maxNumberOfPeopleHouseTemp = input.nextLine();
        while (!CheckService.checkMaxNumberOfPeople(maxNumberOfPeopleHouseTemp)) {
            System.err.println("Invalid!!! Max number of people must be greater than 0 and less than 20");
            maxNumberOfPeopleHouseTemp = input.nextLine();
        }
        house.setMaxNumberOfPeople(maxNumberOfPeopleHouseTemp);
        System.out.println("Thuê theo năm, tháng, ngày hoặc giờ: ");
        String typeRentHouseTemp = input.nextLine();
        while (!CheckService.checkTypeRent(typeRentHouseTemp)) {
            System.err.println("Invalid!!! please Input again!!!");
            typeRentHouseTemp = input.nextLine();
        }
        house.setTypeRent(typeRentHouseTemp);
        System.out.println("Nhập Tiêu Chuẩn Phòng: ");
        String standardRoomHouseTemp = input.nextLine();
        while (!CheckService.checkStandardRoom(standardRoomHouseTemp)) {
            System.err.println("Invalid!!! please Input again!!! (ex: Vip, Business, Normal)");
            standardRoomHouseTemp = input.nextLine();
        }
        house.setStandardRoom(standardRoomHouseTemp);
        System.out.println("Nhập Mô Tả Tiện Nghi Khác: ");
        house.setDescribeConvenient(input.nextLine());
        System.out.println("Nhập Số Tầng: ");
        String numberOfFloorsHouseTemp = input.nextLine();
        while (!CheckService.checkNumberOfFloors(numberOfFloorsHouseTemp)) {
            System.err.println("Invalid!!! Number of floors is positive numbers!!!");
            numberOfFloorsHouseTemp = input.nextLine();
        }
        house.setNumberOfFloors(numberOfFloorsHouseTemp);
        listHouse.add(house);
        String line;
        line = house.getId() + COMMA + house.getNameServices() + COMMA + house.getAreaUse()
                + COMMA + house.getRentPrice() + COMMA + house.getMaxNumberOfPeople()
                + COMMA + house.getTypeRent() + COMMA + house.getStandardRoom() + COMMA + house.getDescribeConvenient()
                + COMMA + house.getNumberOfFloors();
        FileUtils.writeFile(FILE_NAME_HOUSE, line);
    }

    // ---------------- Show All House ----------------- //

    public static void showAllHouse() {
        listHouse = FileUtils.getFileCSVToListHouse();
        for (House house : listHouse) {
            house.showInfor();
        }
    }

    // ---------------- Booking House ----------------- //
    public static void bookingHouse(List<Booking> bookingList, List<Customer> customerList, Booking booking, int choose) {
        List<House> houseList = FileUtils.getFileCSVToListHouse();
        for (int i = 1; i < houseList.size(); i++) {
            System.out.print("ID: " + (i + 1) + " ");
            houseList.get(i).showInfor();
        }
        System.out.println("Choose one House: ");
        int chooseHouse = input.nextInt();
        House house = houseList.get(chooseHouse - 1);
        booking.setIdService(house.getId());
        bookingList.add(booking);
        String lineBooking;
        for (Booking booking1 : bookingList) {
            lineBooking = booking1.getIdCustomer() + COMMA + booking1.getIdService();
            FileUtils.writeFile(FILE_NAME_BOOKING, lineBooking);
        }
        System.out.println("Đã Booking House thành công cho khách hàng: " + customerList.get(choose - 1).getNameCustomer());
    }

    // ---------------- Show All Name House Not Duplicate ----------------- //

    public static void showAllNameHouseNotDup() {
        Set<String> nameHouseNotDup = new TreeSet<>();
        List<House> houseList = FileUtils.getFileCSVToListHouse();
        for (int i = 0; i < houseList.size(); i++) {
            nameHouseNotDup.add(houseList.get(i).getNameServices());
        }
        System.out.println("Danh sách các Room không trùng nhau: ");
        for (String nameHouse : nameHouseNotDup) {
            System.out.println(nameHouse);
        }
    }
}
