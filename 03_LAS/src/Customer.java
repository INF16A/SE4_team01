public class Customer {
    private int id;
    private Town town;

    public Customer(int id,Town town) {
        this.id = id;
        this.town = town;
    }

    public int getId() {
        return id;
    }

    public Town getTown() {
        return town;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ Customer : ").append("id = ").append(id).append(", ");
        stringBuilder.append("town = ").append(town).append(" }");
        return stringBuilder.toString();
    }
}