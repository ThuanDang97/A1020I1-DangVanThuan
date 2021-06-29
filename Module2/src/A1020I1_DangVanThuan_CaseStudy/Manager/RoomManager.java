package A1020I1_DangVanThuan_CaseStudy.Manager;

import A1020I1_DangVanThuan_CaseStudy.Commons.FileUtils;
import A1020I1_DangVanThuan_CaseStudy.Commons.FuncValidation.CheckService;
import A1020I1_DangVanThuan_CaseStudy.Models.Booking;
import A1020I1_DangVanThuan_CaseStudy.Models.Customer;
import A1020I1_DangVanThuan_CaseStudy.Models.Room;

import java.util.*;

import static A1020I1_DangVanThuan_CaseStudy.Manager.BookingManager.FILE_NAME_BOOKING;

public class RoomManager {
    private static List<Room> listRoom = new ArrayList<>();
    public static final String FILE_NAME_ROOM = "src\\A1020I1_DangVanThuan_CaseStudy\\Data\\Room.csv";
    public static final String COMMA = ",";
    public static Scanner input = new Scanner(System.in);

    public static void addNewRoom(Room room) {
        System.out.println("Nhập ID Room (SVRO-XXXX): ");
        String idRoomTemp = input.nextLine();
        while (!CheckService.checkID(idRoomTemp)) {
            System.out.println("Invalid!!! please Input again!!!");
            idRoomTemp = input.nextLine();
        }
        room.setId(idRoomTemp);
        System.out.println("Nhập Tên Room: ");
        String nameServicesRoomTemp = input.nextLine();
        while (!CheckService.checkNameServices(nameServicesRoomTemp)) {
            System.out.println("Invalid!!! please Input again!!!");
            nameServicesRoomTemp = input.nextLine();
        }
        room.setNameServices(nameServicesRoomTemp);
        System.out.println("Nhập Diện Tích Sử Dụng: ");
        String areaUseRoomTemp = input.nextLine();
        while (!CheckService.checkArea(areaUseRoomTemp)) {
            System.out.println("Invalid!!! Area is larger 30!!!");
            areaUseRoomTemp = input.nextLine();
        }
        room.setAreaUse(areaUseRoomTemp);
        System.out.println("Nhập Chi Phí Thuê: ");
        String rentPriceRoomTemp = input.nextLine();
        while (!CheckService.checkRentPrice(rentPriceRoomTemp)) {
            System.out.println("Invalid!!! Rent is positive numbers!!!");
            rentPriceRoomTemp = input.nextLine();
        }
        room.setRentPrice(rentPriceRoomTemp);
        System.out.println("Nhập Số Lượng Người Tối Đa: ");
        String maxNumberOfPeopleRoomTemp = input.nextLine();
        while (!CheckService.checkMaxNumberOfPeople(maxNumberOfPeopleRoomTemp)) {
            System.out.println("Invalid!!! Max number of people must be greater than 0 and less than 20");
            maxNumberOfPeopleRoomTemp = input.nextLine();
        }
        room.setMaxNumberOfPeople(maxNumberOfPeopleRoomTemp);
        System.out.println("Thuê theo năm, tháng, ngày hoặc giờ: ");
        String typeRentTemp = input.nextLine();
        while (!CheckService.checkTypeRent(typeRentTemp)){
            System.out.println("Invalid!!! please Input again!!!");
            typeRentTemp = input.nextLine();
        }
        room.setTypeRent(typeRentTemp);
        System.out.println("Nhập Dịch Vụ Miễn Phí Đi Kèm: ");
        String freeServicesTemp = input.nextLine();
        while (!CheckService.checkFreeServices(freeServicesTemp)) {
            System.out.println("Invalid!!! Free Services: Massage, Karaoke, Drink, Food, Car!!!");
            freeServicesTemp = input.nextLine();
        }
        room.setFreeServices(freeServicesTemp);
        listRoom.add(room);
        String line;
        line = room.getId() + COMMA + room.getNameServices() + COMMA + room.getAreaUse()
                + COMMA + room.getRentPrice() + COMMA + room.getMaxNumberOfPeople()
                + COMMA + room.getTypeRent() + COMMA + room.getFreeServices();
        FileUtils.writeFile(FILE_NAME_ROOM, line);
    }

    // ---------------- Show All Room ----------------- //

    public static void showAllRoom() {
        listRoom = FileUtils.getFileCSVToListRoom();
        for (Room room : listRoom) {
            room.showInfor();
        }
    }

    // ---------------- Booking Room ----------------- //
    public static void bookingRoom(List<Booking> bookingList, List<Customer> customerList, Booking booking, int choose) {
        List<Room> roomList = FileUtils.getFileCSVToListRoom();
        for (int i = 1; i < roomList.size(); i++) {
            System.out.print("ID: " + (i + 1) + " ");
            roomList.get(i).showInfor();
        }
        System.out.println("Choose one Room: ");
        int chooseRoom = input.nextInt();
        Room room = roomList.get(chooseRoom - 1);
        booking.setIdService(room.getId());
        bookingList.add(booking);
        String lineBooking;
        for (Booking booking1 : bookingList) {
            lineBooking = booking1.getIdCustomer() + COMMA + booking1.getIdService();
            FileUtils.writeFile(FILE_NAME_BOOKING, lineBooking);
        }
        System.out.println("Đã Booking Room thành công cho khách hàng: " + customerList.get(choose - 1).getNameCustomer());
    }

    // ---------------- Show All Name Room Not Duplicate ----------------- //

    public static void showAllNameRoomNotDup() {
        Set<String> nameRoomNotDup = new TreeSet<>();
        List<Room> roomList = FileUtils.getFileCSVToListRoom();
        for (int i = 0; i < roomList.size(); i++) {
            nameRoomNotDup.add(roomList.get(i).getNameServices());
        }
        System.out.println("Danh sách các Room không trùng nhau: ");
        for (String nameRoom : nameRoomNotDup) {
            System.out.println(nameRoom);
        }
    }
}
