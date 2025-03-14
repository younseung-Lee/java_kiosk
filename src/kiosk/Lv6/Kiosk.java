package kiosk.Lv6;

import java.util.*;

public class Kiosk {
    private List<Menu> menus = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Map<MenuItem, Integer> cart = new HashMap<>(); // 장바구니를 HashMap으로 변경

    // 메뉴 추가 메서드
    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    // 키오스크 시작 메서드
    public void start() {
        while (true) {
            try {
                System.out.println("[ SHAKESHACK MENU ]");
                for (int i = 0; i < menus.size(); i++) {
                    System.out.println((i + 1) + ". " + menus.get(i).getCategory());
                }
                System.out.println("0. 종료");
                System.out.println("[ ORDER MENU ]");
                System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
                System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
                System.out.print("원하는 숫자를 입력하세요: ");
                int choice = scanner.nextInt();

                if (choice == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (choice == 4) {
                    showCart(); // 장바구니 확인 메서드
                } else if (choice == 5) {
                    cancelOrder(); // 주문 취소 메서드
                } else if (choice > 0 && choice <= menus.size()) {
                    Menu selectedMenu = menus.get(choice - 1);  // 메뉴 카테고리 선택
                    selectedMenu.printMenu(); // 선택된 메뉴의 항목 출력
                    selectMenuItem(selectedMenu);  // 메뉴 항목 선택
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                }
            } catch (Exception e) {
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
                    return;
                } else if (choice > 0 && choice <= menu.getMenuItems().size()) {
                    MenuItem selectedItem = menu.getMenuItems().get(choice - 1);
                    cart.put(selectedItem, cart.getOrDefault(selectedItem, 0) + 1);
                    System.out.println("장바구니에 추가됨: " + selectedItem.getName() + " (수량: " + cart.get(selectedItem) + ")");
                    return;
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                }
            } catch (Exception e) {
                System.out.println("숫자를 입력해주세요!");
                scanner.nextLine();
            }
        }
    }

    //장바구니 확인 메서드
    private void showCart() {
        while (true) {
            System.out.println(" [ 장바구니 ] ");

            if (cart.isEmpty()) {
                System.out.println("장바구니가 비어 있습니다.");
            } else {
                double total = calculateTotal();
                for (Map.Entry<MenuItem, Integer> entry : cart.entrySet()) {
                    MenuItem item = entry.getKey(); // 메뉴 항목
                    int quantity = entry.getValue();  // 수량
                    System.out.println(item.getName() + " | W " + item.getPrice() + " | 수량: " + quantity);
                }
                System.out.printf("총 가격: $%.2f%n", total); // 소수점 두 자리까지 표시
            }

            System.out.println("1. 주문하기");
            System.out.println("0. 뒤로 가기");
            System.out.print("입력: ");

            try {
                int choice = scanner.nextInt();
                if (choice == 0) {
                    System.out.println("메인 메뉴로 돌아갑니다.");
                    return;
                } else if (choice == 1) {
                    if (cart.isEmpty()) {
                        System.out.println("장바구니가 비어 있어 주문할 수 없습니다.");
                    } else {
                        placeOrder();
                        return;
                    }
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                }
            } catch (Exception e) {
                System.out.println("숫자를 입력해주세요!");
                scanner.nextLine();
            }
        }
    }

    //총 가격 계산 메서드
    private double calculateTotal() {
        double total = 0;
        for (Map.Entry<MenuItem, Integer> entry : cart.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    //주문 처리 메서드
    private void placeOrder() {
        System.out.println("주문이 완료되었습니다!");
        System.out.println("결제 금액: $" + calculateTotal());
        cart.clear();
        System.out.println("장바구니가 초기화되었습니다.");
    }

    //주문 취소 메서드
    private void cancelOrder() {
        cart.clear();
        System.out.println("장바구니가 비었습니다.");
    }
}
