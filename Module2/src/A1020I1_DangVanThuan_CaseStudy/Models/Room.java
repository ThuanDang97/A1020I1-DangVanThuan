package A1020I1_DangVanThuan_CaseStudy.Models;

public class Room extends Services {

    private String freeServices;
    private String unit;
    private String amount;


    public Room() {
    }

    public Room(String freeServices) {
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public void showInfor() {
        System.out.println(
                super.toString()
                        + "Free Services: " + this.freeServices + "\n"
                        + "Unit: " + this.unit + "\n"
                        + "Amount: " + this.amount + "\n"
                        + "----------------------------");
    }
}
