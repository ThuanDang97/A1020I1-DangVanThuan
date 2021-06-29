package A1020I1_DangVanThuan_CaseStudy.Manager;

import A1020I1_DangVanThuan_CaseStudy.Models.House;
import A1020I1_DangVanThuan_CaseStudy.Models.Room;
import A1020I1_DangVanThuan_CaseStudy.Models.Villa;

import java.util.Scanner;

import static A1020I1_DangVanThuan_CaseStudy.Controllers.MainController.displayMainMenu;
import static A1020I1_DangVanThuan_CaseStudy.Manager.HouseManager.*;
import static A1020I1_DangVanThuan_CaseStudy.Manager.RoomManager.*;
import static A1020I1_DangVanThuan_CaseStudy.Manager.VillaManager.*;

public class ServicesManager {


    public static void addNewServices() {
        Scanner input = new Scanner(System.in);
        boolean check = true;

        do {
            System.out.println("--Menu Add New Services--");
            System.out.println("1. Add New Villa" + "\n" +
                    "2. Add New House" + "\n" +
                    "3. Add New Room" + "\n" +
                    "4. Back to menu" + "\n" +
                    "5. Exit");
            System.out.println("--------------------------------");
            System.out.print("Vui lòng chọn chức năng muốn thực hiện: ");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    Villa villa = new Villa();
                    addNewVilla(villa);
                    System.out.println("Thêm thành công Villa, Enter để tiếp tục!!!");
                    input.nextLine();
                    displayMainMenu();
                    break;

                case 2:
                    House house = new House();
                    addNewHouse(house);
                    System.out.println("Thêm thành công House, Enter để tiếp tục!!!");
                    input.nextLine();
                    displayMainMenu();
                    break;

                case 3:
                    Room room = new Room();
                    addNewRoom(room);
                    System.out.println("Thêm thành công Room, Enter để tiếp tục!!!");
                    input.nextLine();
                    displayMainMenu();
                    break;
                case 4:
                    displayMainMenu();
                    break;
                case 5:
                    check = false;
                    break;
                default:
                    System.out.println("Fail!!! Please choose again, Enter to continue....");
                    input.nextLine();
                    addNewServices();
            }
        } while (check);
    }

    // ---------------- Show Services ----------------- //

    public static void showServices() {
        Scanner input = new Scanner(System.in);
        boolean check = true;
        do {
            System.out.println("--Menu Show Services--" + "\n"
                    + "1. Show all Villa" + "\n"
                    + "2. Show all House" + "\n"
                    + "3. Show all Room" + "\n"
                    + "4. Show All Name Villa Not Duplicate" + "\n"
                    + "5. Show All Name House Not Duplicate" + "\n"
                    + "6. Show All Name Name Not Duplicate" + "\n"
                    + "7. Back to menu" + "\n"
                    + "8. Exit");
            System.out.print("Vui lòng chọn chức năng muốn thực hiện: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    showAllVilla();
                    break;
                case 2:
                    showAllHouse();
                    break;
                case 3:
                    showAllRoom();
                    break;
                case 4:
                    showAllNameVillaNotDup();
                    displayMainMenu();
                    break;
                case 5:
                    showAllNameHouseNotDup();
                    displayMainMenu();
                    break;
                case 6:
                    showAllNameRoomNotDup();
                    displayMainMenu();
                    break;
                case 7:
                    displayMainMenu();
                    break;
                case 8:
                    check = false;
                    break;
                default:
                    System.out.println("Fail!!! Please choose again, Enter to continue....");
                    input.nextLine();
                    showServices();
            }
        } while (check);
    }
}
