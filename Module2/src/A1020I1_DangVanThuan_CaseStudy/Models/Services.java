package A1020I1_DangVanThuan_CaseStudy.Models;

public abstract class Services {
    private String id;
    private String nameServices;
    private String areaUse;
    private String rentPrice;
    private String maxNumberOfPeople;
    private String typeRent;

    public Services() {
    }

    public Services(String id, String nameServices, String areaUse, String rentPrice, String maxNumberOfPeople, String typeRent) {
        this.id = id;
        this.nameServices = nameServices;
        this.areaUse = areaUse;
        this.rentPrice = rentPrice;
        this.maxNumberOfPeople = maxNumberOfPeople;
        this.typeRent = typeRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameServices() {
        return nameServices;
    }

    public void setNameServices(String nameServices) {
        this.nameServices = nameServices;
    }

    public String getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(String areaUse) {
        this.areaUse = areaUse;
    }

    public String getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(String rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getMaxNumberOfPeople() {
        return maxNumberOfPeople;
    }

    public void setMaxNumberOfPeople(String maxNumberOfPeople) {
        this.maxNumberOfPeople = maxNumberOfPeople;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    @Override
    public String toString() {
        return "----------------------------" + "\n"
                + "ID: " + this.id + "\n"
                + "Name Services: " + this.nameServices + "\n"
                + "Area Use: " + this.areaUse + "\n"
                + "Rent Price: " + this.rentPrice + "\n"
                + "Max Number Of People: " + this.maxNumberOfPeople + "\n"
                + "Type Rent: " + this.typeRent + "\n";
    }

    public abstract void showInfor();

}
