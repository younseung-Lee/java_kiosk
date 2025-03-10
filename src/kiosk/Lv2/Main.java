package kiosk.Lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner sc = new Scanner(System.in);


        while (true) {
            try {
                System.out.println("[ SHAKESHACK MENU ]");
                for (int i = 0; i < menuItems.size(); i++) {
                    MenuItem menuItem = menuItems.get(i);
                    System.out.printf("%d. %s | W %.1f | %s%n", i + 1, menuItem.getName(), menuItem.getPrice(), menuItem.getContent());
                }
                System.out.println("0. 종료");
                System.out.print("원하는 숫자를 입력하세요: ");

                int choice = sc.nextInt();

                /*
                * if (choice >= 1 && choice <= menuItems.size()) 사용자가 올바른 범위 내에서 숫자를 입력했는지 검증
                * MenuItem menuItem = menuItems.get(choice - 1) 리스트의 인덱스는 0부터 시작하기때문
                * */
                if (choice >= 1 && choice <= menuItems.size()) {
                    MenuItem menuItem = menuItems.get(choice - 1);
                    menuItem.printMenu();
                } else if (choice == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                } else {
                    System.out.println("다시 입력하세요");
                }
            } catch (Exception e) {
                System.out.println("올바른 숫자를 입력하세요.");
                sc.nextLine();

            }
        }
    }
}


