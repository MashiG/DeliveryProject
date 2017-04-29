package Model;

import java.math.BigDecimal;

/**
 * Created by murtaza on 4/29/17.
 */

public class Packages {
    String packageID, width, height, length, weight;
    BigDecimal price;

    public Packages() {
    }

    public Packages(String packageID, String width, String height, String length, String weight, BigDecimal price) {
        this.packageID = packageID;
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.price = price;
    }

    public String getPackageID() {
        return packageID;
    }

    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
