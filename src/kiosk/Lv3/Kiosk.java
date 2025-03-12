package kiosk.Lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> menuItems;
    private Scanner scanner;

    public Kiosk() {
        this.menuItems = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        BurgerMenu(); // 메뉴 초기화
    }

    private void BurgerMenu() {
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    public void Start() {
        while (true) { // 프로그램이 종료될 때까지 반복 실행
            try {
                // 메뉴 출력
                System.out.println("[ SHAKESHACK MENU ]");
                for (int i = 0; i < menuItems.size(); i++) {
                    MenuItem menuItem = menuItems.get(i);
                    System.out.printf("%d. %s | W %.1f | %s%n", i + 1, menuItem.getName(), menuItem.getPrice(), menuItem.getContent());
                }
                System.out.println("0. 종료");
                System.out.print("원하는 숫자를 입력하세요: ");

                int choice = scanner.nextInt();

                // 입력값 처리
                if (choice >= 1 && choice <= menuItems.size()) {
                    MenuItem menuItem = menuItems.get(choice - 1);
                    menuItem.printMenu();
                } else if (choice == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break; // while 루프 종료 -> 프로그램 종료
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                }
            } catch (Exception e) {
                System.out.println("올바른 숫자를 입력하세요.");
                scanner.nextLine(); // 잘못된 입력 처리 (버퍼 정리)
            }
        }
        scanner.close(); // 리소스 정리
    }
}
