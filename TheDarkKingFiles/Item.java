import java.util.ArrayList;
import java.util.HashMap;
public class Item {

    public static void useItem(Player player){
        displayItems(player.getPlayerInventory());
        ArrayList<String> validInput = new ArrayList<String>();
        if (player.getPlayerInventory().size ()> 0){
        for (int i = 1; i  < player.getPlayerInventory().size() + 1; i ++){
            validInput.add(String.valueOf(i));
        }
    
        String playerChoice = player.PlayerAction(validInput, "\nWhich Item would you like to use");
        int playerChoiceInt = Integer.parseInt(playerChoice) - 1;
        potionUse(player,playerChoiceInt);
        player.removeFromInventory(playerChoiceInt);
        }
    }

    public static void displayItems(ArrayList<String> itemlist){
        int num = 0;
        if (itemlist.size() == 0){
            System.out.println("You have no items");
        }
        for (String item : itemlist){
            num ++;
            System.out.printf("%d. %s - %s%n", num, item, itemDescription(item));
            
        }
        
    }

    public static void displayItemsShop(ArrayList<String> itemlist){
        //I wanted the shop to display the prices along side the description so I just duplicated this function
        int num = 0;
        if (itemlist.size() == 0){
            System.out.println("You have no items");
        }
        for (String item : itemlist){
            num ++;
            System.out.printf("%d. %s - %s%n", num, item, itemDescriptionPrices(item));
            
        }
        
    }

    public static String itemDescription(String item){
        String desc;

        HashMap <String, String> itemDescriptions = new HashMap<String,String>();

        String lesserHealthPotion = "This potion heals 25 hp";
        String healthPotion = "This potion heals 50 hp";
        String greaterHealthPotion = "This potion heals 100 hp";
        String maxHealthPotion = "This potion heals to max hp";

        String caveMap = "This map shows where the cave is located.";
        String castleMap = "This map shows where the castle is located.";
        String crown = "This is the Dark King's Crown. The world is saved!";

        itemDescriptions.put("Lesser Health Potion", lesserHealthPotion);
        itemDescriptions.put("Health Potion", healthPotion);
        itemDescriptions.put("Greater Health Potion", greaterHealthPotion);
        itemDescriptions.put("Max Health Potion", maxHealthPotion);

        itemDescriptions.put("Cave Map", caveMap);
        itemDescriptions.put("Castle Map", castleMap);
        itemDescriptions.put("The Dark King's Crown", crown);

        
        desc = itemDescriptions.get(item);
        
        if(desc == null){
            desc = "item has no descritption";
        }
        return desc;
    }

    public static String itemDescriptionPrices(String item){
        //I wanted the shop to display the prices along side the description so I just duplicated this function
        String desc;

        HashMap <String, String> itemDescriptions = new HashMap<String,String>();

        String lesserHealthPotion = "This potion heals 25 hp - 25 gold";
        String healthPotion = "This potion heals 50 hp - 50 gold";
        String greaterHealthPotion = "This potion heals 100 hp - 100 gold";
        String maxHealthPotion = "This potion heals to max hp - 200 gold";

        itemDescriptions.put("Lesser Health Potion", lesserHealthPotion);
        itemDescriptions.put("Health Potion", healthPotion);
        itemDescriptions.put("Greater Health Potion", greaterHealthPotion);
        itemDescriptions.put("Max Health Potion", maxHealthPotion);

        try{
            desc = itemDescriptions.get(item);
        }
        catch (Exception e){
            desc = "item has no descritption";
        }
        return desc;
    }

    private static void potionUse(Player player, int index){

        if (player.getPlayerItem(index).equals("Lesser Health Potion")){
            player.amountHealPlayer(25);
        }else if (player.getPlayerItem(index).equals("Health Potion")){
            player.amountHealPlayer(50);
        }else if (player.getPlayerItem(index).equals("Greater Health Potion")){
            player.amountHealPlayer(100);
        }else if (player.getPlayerItem(index).equals("Max Health Potion")){
            player.fullHealPlayer();
        }else{
            System.out.println("ERROR");
        }
    }
}
