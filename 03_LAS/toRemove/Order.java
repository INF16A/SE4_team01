package toRemove;

public class Order {
    private int id;
    private Customer customer;
    private Product product;
    private int quantity;
    private int deliveryTimeInHours;

    public Order(int id,Customer customer,Product product,int quantity,int deliveryTimeInHours) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.deliveryTimeInHours = deliveryTimeInHours;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(id).append(";").append(customer.getId()).append(";");
        stringBuilder.append(customer.getTown().getId()).append(";").append(customer.getTown().getRegion()).append(";");
        stringBuilder.append(product.getId()).append(";").append(product.getName()).append(";").append(product.getPrice()).append(";");
        stringBuilder.append(quantity).append(";").append(deliveryTimeInHours);
        return stringBuilder.toString();
    }
}