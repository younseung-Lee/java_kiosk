package kiosk.Lv6;


import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String category;
    private List<MenuItem> menuItems = new ArrayList<>();

    public Menu(String category) {
        this.category = category;
    }

    public void addMenuItem(String name, double price, String content) {
        menuItems.add(new MenuItem(name, price, content));
    }


    public String getCategory(){
        return category;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    //메뉴아이템 출력
    public void printMenu() {
        System.out.println(" [ " + category + " 메뉴 ] ");
        for ( int i = 0; i < menuItems.size(); i++){
            MenuItem item = menuItems.get(i);
            System.out.println((i+1)+". "+item.getName()+ " - $"+item.getPrice()+ ":" + item.getContent());
        }
    }
}
