public class RecordLine {
    private int id;
    private int customerId;
    private int customerTownId;
    private char customerRegion;
    private int productId;
    private String productName;
    private int productPrice;
    private int quanitity;
    private int deliveryTimeInHours;

    public RecordLine(int id, int customerId, int customerTownId, char customerRegion, int productId, String productName, int productPrice, int quanitity, int deliveryTimeInHours) {
        this.id = id;
        this.customerId = customerId;
        this.customerTownId = customerTownId;
        this.customerRegion = customerRegion;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quanitity = quanitity;
        this.deliveryTimeInHours = deliveryTimeInHours;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getCustomerTownId() {
        return customerTownId;
    }

    public char getCustomerRegion() {
        return customerRegion;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getQuanitity() {
        return quanitity;
    }

    public int getDeliveryTimeInHours() {
        return deliveryTimeInHours;
    }

    @Override
    public String toString() {
        return "RecordLine{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", customerTownId=" + customerTownId +
                ", customerRegion=" + customerRegion +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", quanitity=" + quanitity +
                ", deliveryTimeInHours=" + deliveryTimeInHours +
                '}';
    }
}
