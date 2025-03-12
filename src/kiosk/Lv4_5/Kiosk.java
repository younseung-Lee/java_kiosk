package kiosk.Lv4_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menus;
    private final Scanner scanner;

    public Kiosk() {
        this.menus = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        Category();
    }

    private void Category() {
        Menu burgerMenu = new Menu("버거");
        burgerMenu.addMenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        burgerMenu.addMenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼, 쉑소스가 토핑된 치즈버거");
        burgerMenu.addMenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        burgerMenu.addMenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        Menu drinkMenu = new Menu("음료");
        drinkMenu.addMenuItem("콜라", 1.5, "탄산음료");
        drinkMenu.addMenuItem("사이다", 1.5, "탄산음료");
        drinkMenu.addMenuItem("환타", 1.5, "탄산음료");

        Menu dessertMenu = new Menu("디저트");
        dessertMenu.addMenuItem("감자튀김",3.0,"감자튀김");


        menus.add(burgerMenu);
        menus.add(drinkMenu);
        menus.add(dessertMenu);
    }

    public void start() {
        while (true) {
            try {
                System.out.println("[ SHAKESHACK KIOSK ]");
                for (int i = 0; i < menus.size(); i++) {
                    System.out.println(i + 1 + ". " + menus.get(i).getCategoryName());
                }
                System.out.println("0. 종료");
                System.out.print("원하는 카테고리를 선택하세요: ");

                int categoryChoice = scanner.nextInt();
                switch (categoryChoice) {
                    case 0:
                        System.out.println("프로그램을 종료합니다.");
                        scanner.close();
                        return;
                    case 1:
                    case 2:
                    case 3:
                        Menu selectedMenu = menus.get(categoryChoice - 1);
                        selectedMenu.printMenuItems();

                        System.out.print("주문할 메뉴 번호를 입력하세요 (0: 뒤로 가기): ");
                        int itemChoice = scanner.nextInt();
                        switch (itemChoice) {
                            case 0:
                                break;
                            default:
                                if (itemChoice >= 1 && itemChoice <= selectedMenu.getMenuItems().size()) {
                                    MenuItem selectedItem = selectedMenu.getMenuItems().get(itemChoice - 1); //사용자가 입력한 번호는 1부터 시작하는 반면, getMenuItems()는 0부터 시작하는 인덱스를 사용
                                    selectedItem.printMenuItem();
                                } else {
                                    System.out.println("잘못된 입력입니다.");
                                }
                        }
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                }
            } catch (Exception e) {
                System.out.println("올바른 숫자를 입력하세요.");
                scanner.nextLine(); // 버퍼 정리
            }
        }
    }
}
