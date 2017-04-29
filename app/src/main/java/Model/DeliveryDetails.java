package Model;

import java.math.BigDecimal;

/**
 * Created by murtaza on 4/29/17.
 */

public class DeliveryDetails {
    String deliveryID, from, to, packageID, userID, status, DeliveryDate, DeliveryAgentID;
    BigDecimal price;

    public DeliveryDetails(String deliveryID, String from, String to, String packageID, String userID, String status, String deliveryDate, String deliveryAgentID, BigDecimal price) {
        this.deliveryID = deliveryID;
        this.from = from;
        this.to = to;
        this.packageID = packageID;
        this.userID = userID;
        this.status = status;
        DeliveryDate = deliveryDate;
        DeliveryAgentID = deliveryAgentID;
        this.price = price;
    }

    public DeliveryDetails() {
    }

    public String getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(String deliveryID) {
        this.deliveryID = deliveryID;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getPackageID() {
        return packageID;
    }

    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeliveryDate() {
        return DeliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        DeliveryDate = deliveryDate;
    }

    public String getDeliveryAgentID() {
        return DeliveryAgentID;
    }

    public void setDeliveryAgentID(String deliveryAgentID) {
        DeliveryAgentID = deliveryAgentID;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
