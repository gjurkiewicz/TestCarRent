public class Car {
    private Status status;
    private String model;
    private String brand;
    private double price;

    public Car(String model, String brand, double price) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.status = Status.FREE;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Car");
        stringBuilder.append("{");
        stringBuilder.append("brand:");
        stringBuilder.append(this.brand);
        stringBuilder.append(", model: ");
        stringBuilder.append(this.model);
        stringBuilder.append(", price: ");
        stringBuilder.append(this.price);
        stringBuilder.append(", status: ");
        stringBuilder.append(this.status);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


