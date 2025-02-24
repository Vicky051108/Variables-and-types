
    import java.util.Arrays;
    import java.util.List;
    import java.text.SimpleDateFormat;
    import java.util.Date;
    
    public class SliceOHeaven {
        
        private final String storeName = "Slice-o-Heaven";
        private final String storeAddress = "123 Pizza Paradise Blvd, Naples, Italy";
        private final String storePhone = "+39 081 1234567";
        
        
        private final List<String> storeMenu = Arrays.asList(
            "Margherita", 
            "Pepperoni", 
            "Quattro Formaggi",
            "Diavola"
        );
        
        
        private final List<String> pizzaIngredients = Arrays.asList(
            "Dough",
            "San Marzano tomatoes",
            "Fresh mozzarella",
            "Basil",
            "Extra virgin olive oil"
        );
        private final double pizzaPrice = 14.99;
        private final double sidePrice = 5.99;
        private final double drinkPrice = 3.99;
        
        
        private final List<String> sides = Arrays.asList(
            "Garlic Knots (6pc)",
            "Bruschetta",
            "Antipasto Salad"
        );
        private final List<String> drinks = Arrays.asList(
            "Italian Soda",
            "San Pellegrino",
            "Espresso"
        );
        
        
        private String orderID;
        private double orderTotal;
        private static int orderCounter = 0;
    
        
        public void takeOrder(int pizzaQty, int sidesQty, int drinksQty) {
            generateOrderID();
            calculateTotal(pizzaQty, sidesQty, drinksQty);
            System.out.println("✅ Order " + orderID + " received!");
        }
    
        private void generateOrderID() {
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            orderID = "ORDER-" + timestamp + "-" + (++orderCounter);
        }
    
        private void calculateTotal(int pizzas, int sides, int drinks) {
            orderTotal = (pizzas * pizzaPrice) 
                        + (sides * sidePrice) 
                        + (drinks * drinkPrice);
        }
    
        
        public void makePizza() {
            System.out.println("\n🔥 BAKING IN PROGRESS:");
            pizzaIngredients.forEach(ingredient -> 
                System.out.println("   Adding " + ingredient)
            );
            System.out.println("⌛ Your pizza is ready!");
        }
    
        
        public void printReceipt() {
            System.out.println("\n🧾 RECEIPT FOR ORDER " + orderID);
            System.out.println("=================================");
            System.out.println(storeName + "\n" + storeAddress);
            System.out.println("Tel: " + storePhone);
            System.out.println("=================================");
            System.out.printf("Total Amount: $%.2f\n", orderTotal);
            System.out.println("Thank you for choosing us!");
        }
    
        
        
    } 


