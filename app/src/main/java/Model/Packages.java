package Model;

import java.math.BigDecimal;

/**
 * Created by murtaza on 4/29/17.
 */

public class Packages {
    String packageID;
    String weight;
    String price, volume;

    public Packages() {
    }

    public Packages(String packageID, String volume, String weight, String price) {
        this.packageID = packageID;
        this.weight = weight;
        this.price = price;
        this.volume = volume;
    }

    public String getPackageID() {
        return packageID;
    }

    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
