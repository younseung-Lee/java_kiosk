package kiosk.Lv4_5;

// MenuItem 클래스 (각 메뉴 아이템 관리)
class MenuItem {
    private final String name;
    private final double price;
    private final String content;

    public MenuItem(String name, double price, String content) {
        this.name = name;
        this.price = price;
        this.content = content;
    }

   public String getName(){
        return name;
   }

   public double getPrice() {
        return price;
   }

   public String getContent(){
        return content;
   }

}