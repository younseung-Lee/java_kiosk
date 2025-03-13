package kiosk.Lv6;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private List<MenuItem> cart = new ArrayList<>();

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
                System.out.println("[ ORDER MENU ]");
                System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
                System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
                System.out.print("원하는 숫자를 입력하세요: ");
                int choice = scanner.nextInt();

                if (choice == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (choice == 4) {
                    showCart();
                } else if (choice == 5) {
                    cancelOrder();
                } else if (choice > 0 && choice <= menus.size()) {
                    Menu selectedMenu = menus.get(choice - 1);
                    selectedMenu.printMenu();
                    selectMenuItem(selectedMenu);
                }  else {
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
                    cart.add(selectedItem);  // 장바구니에 추가
                    System.out.println("장바구니에 추가됨: " + selectedItem.getName());
                    return;
                }else {
                    System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                }
            }catch(Exception e){
                System.out.println("숫자를 입력해주세요!");
                scanner.nextLine(); // 버퍼 초기화 후 다시 입력받음
            }
        }
    }
    private void showCart() {
        while (true) { // 사용자가 0을 입력할 때까지 반복
            System.out.println(" [ 장바구니 ] ");

            if (cart.isEmpty()) {
                System.out.println("장바구니가 비어 있습니다.");
            } else {
                double total = calculateTotal();  // 총 가격 계산
                for (int i = 0; i < cart.size(); i++) {
                    MenuItem item = cart.get(i);
                    System.out.println((i + 1) + ". " + item.getName() + " - $" + item.getPrice());
                }
                System.out.println("총 가격: $" + total);
            }

            System.out.println("1. 주문하기");
            System.out.println("0. 뒤로 가기");
            System.out.print("입력: ");

            try {
                int choice = scanner.nextInt();
                if (choice == 0) {
                    System.out.println("메인 메뉴로 돌아갑니다.");
                    return; // 메서드 종료 → 메인 메뉴로 돌아감
                } else if (choice == 1) {
                    if (cart.isEmpty()) {
                        System.out.println("장바구니가 비어 있어 주문할 수 없습니다.");
                    } else {
                        placeOrder(); // 주문 확정 메서드 실행
                        return;
                    }
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                }
            } catch (Exception e) {
                System.out.println("숫자를 입력해주세요!");
                scanner.nextLine(); // 버퍼 초기화
            }
        }
    }

    private double calculateTotal() {
        double total = 0;
        for (MenuItem item : cart) {
            total += item.getPrice();
        }
        return total;
    }

    private void placeOrder() {
        System.out.println("주문이 완료되었습니다!");
        System.out.println("결제 금액: $" + calculateTotal());
        cart.clear(); // 장바구니 비우기
        System.out.println("장바구니가 초기화되었습니다.");
    }

    // 주문 취소 메서드
    private void cancelOrder() {
        if (!cart.isEmpty()) {
            System.out.println("주문을 취소합니다.");
            cart.clear();  // 장바구니 비우기
            System.out.println("장바구니가 비었습니다.");
        } else {
            System.out.println("취소할 주문이 없습니다.");
        }
    }
}
