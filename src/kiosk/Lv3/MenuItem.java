package kiosk.Lv3;

public class MenuItem {
    private String name;
    private double price;
    private String content;

    public MenuItem(String name, double price, String content){
        this.name = name;
        this.content = content;
        this.price = price;
    }

    public void printMenu() {
        System.out.println(name + "-" + price + "원: " + content);
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
