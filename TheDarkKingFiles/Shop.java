import java.util.ArrayList;;

public class Shop {
    //I felt that Location would get to crowded with townShops logic so new class
    public static void shop(Player player){
        shopInventory();
        String playerChoice = "None";
        String[] validInputs = {"1", "2", "3", "4", "LEAVE"};
        String prompt = "Which items do you want to buy? LEAVE to quit shoping";

        while(!(playerChoice.equals("LEAVE"))){
            System.out.printf("Gold: %d%n", player.gold);
            playerChoice = player.PlayerAction(validInputs, prompt);
            boolean canPurchase = priceCheck(player, playerChoice);

            if (canPurchase){
                purchase(player, playerChoice);
            }

        }

    }

    private static void shopInventory(){
        ArrayList<String> inventory = new ArrayList<String>();
        inventory.add("Lesser Health Potion");
        inventory.add("Health Potion");
        inventory.add("Greater Health Potion");
        inventory.add("Max Health Potion");

        Item.displayItemsShop(inventory);
    }

    private static boolean priceCheck(Player player, String playerChoice){
        //Checks if player can buy the item
        /*
        1.Lesser Health Potion - 25
        2.Health Potion - 50
        3.Greater Health Potion - 100
        4.Max Health Potion - 200
        */
        boolean canBuy = false;
        if(playerChoice.equals("1")){
            if (player.gold >= 25){
                canBuy = true;
            }else{
                System.out.println("You don't have enough money");}
        }else if(playerChoice.equals("2")){
            if (player.gold >= 50){
                canBuy = true;
            }else{
                System.out.println("You don't have enough money");}
        }else if(playerChoice.equals("3")){
            if (player.gold >= 100){
                canBuy = true;
            }else{
                System.out.println("You don't have enough money");}
        }else if(playerChoice.equals("4")){
            if (player.gold >= 200){
                canBuy = true;
            }else{
                System.out.println("You don't have enough money");
            }
        }

        return canBuy;
    }

    private static void purchase(Player player, String playerChoice){
        //Removes the cost of the item and adds it to the players inventory
        /*
        1.Lesser Health Potion - 25
        2.Health Potion - 50
        3.Greater Health Potion - 100
        4.Max Health Potion - 200
        */
        if(playerChoice.equals("1")){
            player.gold -= 25;
            player.addToInventory("Lesser Health Potion");
        }else if(playerChoice.equals("2")){
            player.gold -= 50;
            player.addToInventory("Health Potion");
        }else if(playerChoice.equals("3")){
            player.gold -= 100;
            player.addToInventory("Greater Health Potion");
        }else if(playerChoice.equals("4")){
            player.gold -= 200;
            player.addToInventory("Max Health Potion");
        }
    }
}
