package kiosk.Lv6;

public class Main {
    public static void main(String[] args) {

        Menu burgerMenu = new Menu(MenuCategory.Buger);
        burgerMenu.addMenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        burgerMenu.addMenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼, 쉑소스가 토핑된 치즈버거");
        burgerMenu.addMenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        burgerMenu.addMenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        Menu drinkMenu = new Menu(MenuCategory.DRINK);
        drinkMenu.addMenuItem("콜라", 1.5, "탄산음료");
        drinkMenu.addMenuItem("사이다", 1.5, "탄산음료");
        drinkMenu.addMenuItem("환타", 1.5, "탄산음료");

        Menu dessertMenu = new Menu(MenuCategory.DESEERT);
        dessertMenu.addMenuItem("감자튀김", 3.0, "감자튀김");
        dessertMenu.addMenuItem("아이스크림", 3.0, "시원한 아이스크림");


        Kiosk kiosk = new Kiosk();
        kiosk.addMenu(burgerMenu);
        kiosk.addMenu(drinkMenu);
        kiosk.addMenu(dessertMenu);
        kiosk.start();
    }
}
