package kiosk.Lv4_5;

class MenuItem {
    private final String name;
    private final double price;
    private final String content;

    public MenuItem(String name, double price, String content) {
        this.name = name;
        this.price = price;
        this.content = content;
    }

    public void printMenuItem() {
        System.out.println(name + " | W " + price + " | " + content);
    }

}