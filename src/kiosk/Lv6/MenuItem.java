package kiosk.Lv6;

public class MenuItem {
    private  String name;
    private  double price;
    private  String content;

    public MenuItem(String name, double price, String content) {
        this.name = name;
        this.price = price;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getContent() {
        return content;
    }


}
