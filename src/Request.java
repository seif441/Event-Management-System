public class Request {
    private int id;
    private String description;
    private double price;
    private String readyDate;

    public Request(int id, String description) {
        this.id = id;
        this.description = description;
        this.price = 0.0;
        this.readyDate = "Not set";
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setReadyDate(String readyDate) {
        this.readyDate = readyDate;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Request ID: " + id + ", Description: " + description + ", Price: $" + price + ", Ready Date: " + readyDate;
    }
}
