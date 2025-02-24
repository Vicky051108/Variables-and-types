public class App {
    public static void main(String[] args) {
        SliceOHeaven order1 = new SliceOHeaven();
        
        // 处理订单
        order1.takeOrder(2, 1, 2);  // 2个披萨，1份配菜，2杯饮料
        order1.makePizza();
        order1.printReceipt();
    }
}
