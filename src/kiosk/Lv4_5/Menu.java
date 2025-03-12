package kiosk.Lv4_5;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final String categoryName;
    private final List<MenuItem> menuItems;

    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }

    public void addMenuItem(String name, double price, String content) {
        menuItems.add(new MenuItem(name, price, content));
    }

    public void printMenuItems() {
        System.out.println("[ " + categoryName + " 메뉴 ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.print(i + 1 + ". " );
            menuItems.get(i).printMenuItem();
        }
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public String getCategoryName() {
        return categoryName;
    }


}


