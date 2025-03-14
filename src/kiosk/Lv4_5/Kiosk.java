package kiosk.Lv4_5;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // 메뉴 추가 메서드
    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    // 키오스크 시작 메서드
    public void start() {
        while (true) {
            try{
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategory());
            }
            System.out.println("0. 종료");
            System.out.print("원하는 숫자를 입력하세요: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (choice > 0 && choice <= menus.size()) {
                Menu selectedMenu = menus.get(choice - 1);
                selectedMenu.printMenu();
                selectMenuItem(selectedMenu);
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
            }
        }catch (Exception e) {
                System.out.println("숫자를 입력해주세요!");
                scanner.nextLine();
            }
        }
    }

    // 메뉴 아이템 선택 메서드
    private void selectMenuItem(Menu menu) {
        while (true) {
            try {
                System.out.print("주문할 메뉴 번호를 입력하세요 (0: 뒤로 가기): ");
                int choice = scanner.nextInt();
                if (choice == 0) {
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    return; // 상위 카테고리로 복귀
                } else if (choice > 0 && choice <= menu.getMenuItems().size()) {
                    MenuItem selectedItem = menu.getMenuItems().get(choice - 1);
                    System.out.println(selectedItem.getName() + " | $ " + selectedItem.getPrice() + " | " + selectedItem.getContent());
                    break;
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                }
                }catch(Exception e){
                System.out.println("숫자를 입력해주세요!");
                scanner.nextLine(); // 버퍼 초기화 후 다시 입력받음
            }
        }


    }
}

