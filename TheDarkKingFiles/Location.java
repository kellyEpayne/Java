public class Location {
public static void selectLocation(Player player){
    //Location select screen
    String[] vaildLocations = {"TOWN","FOREST","CAVE","CASTLE","TITLE SCREEN","TITLE","SCREEN"};
    String prompt = "Where do you want to go TOWN, FOREST, CAVE, CASTLE, or the TITLE SCREEN";
    String selectedLocation = player.PlayerAction(vaildLocations, prompt);
    player.setPlayerLocation(selectedLocation);

    if (player.getPlayerLocation().equals("TOWN")){
        locationWelcome(player.getPlayerLocation());
        townLocation(player);
    }else if(player.getPlayerLocation().equals("TITLE SCREEN") || player.getPlayerLocation().equals("TITLE") 
            || player.getPlayerLocation().equals("SCREEN") ){
                //Sets location to main screen so I don't have to test for all three possible inputs
                player.setPlayerLocation("MAIN SCREEN");
                return;
    }else{
        huntLocationValidation(player);
    }
    }

private static void huntLocationValidation(Player player){
    //Blocks the player from entering loactions till they have the proper map

    if(player.getPlayerLocation().equals("FOREST")){
        huntLocation(player);
    }else if(player.getPlayerLocation().equals("CAVE") && player.hasCaveMap){
        huntLocation(player);
    }else if(player.getPlayerLocation().equals("CASTLE") && player.hasCastleMap){
        huntLocation(player);
    }else{
        System.out.printf("You need a map to go to the %s%n", player.getPlayerLocation());
        player.setPlayerLocation("location select");
    }

}

private static void huntLocation(Player player){
    //All monster areas function the same
    locationWelcome(player.getPlayerLocation());
    String playerChoice = "No choice";
    String prompt = "HUNT ITEM LEAVE";
    String[] validInputs = {"HUNT", "ITEM", "LEAVE"};
    while (player.isAlive() && !(playerChoice.equals("LEAVE"))){
        playerChoice = player.PlayerAction(validInputs, prompt);

        if (playerChoice.equals("HUNT")){
            Battle.battle(player, player.getPlayerLocation());
        }else if (playerChoice.equals("ITEM")){
            Item.useItem(player);
        }
    }
}

private static void townLocation(Player player){
    String playerChoice = "none";
    String prompt = "What would you like to do? SHOP, vist the INN, SAVE your game, CHECK your stats, LEAVE town";
    String[] validInputs = {"SHOP", "INN", "SAVE", "CHECK", "LEAVE"};
    while (player.isAlive() && !(playerChoice.equals("LEAVE"))){
        playerChoice = player.PlayerAction(validInputs, prompt);

        if (playerChoice.equals("SHOP")){
            townShop(player);
        }else if (playerChoice.equals("INN")){
            townInn(player);
        }else if (playerChoice.equals("SAVE")){
            townSave(player);
        }else if (playerChoice.equals("CHECK")){
            townCheck(player);
        }

    }
}

private static void locationWelcome(String location){
    System.out.printf("Welcome to the %s%n", location);
}

private static void townShop(Player player){
    //I didn't want to fill location with shop logic
    Shop.shop(player);
}

private static void townInn(Player player){
    System.out.println("You rest up at the inn.");
    player.fullHealPlayer();
}

private static void townSave(Player player){
    //Saves players game
    Save.saveGame(player);
    System.out.println("Game Saved");
}

private static void townCheck(Player player){
    //Checks player stats
    System.out.printf("Name: %s%n", player.pName);
    System.out.printf("Hp: %d/%d%n", player.health, player.maxHealth);
    System.out.printf("Attack: %d%n", player.attack);
    System.out.printf("Gold: %d%n", player.gold);
    System.out.printf("Exp: %d%n",player.exp);
    System.out.printf("Exp to next level: %d%n", player.expToLevel);
    System.out.printf("Level : %d%n", player.level);
    System.out.println("\nItems\n");
    Item.displayItems(player.getPlayerInventory());
}

}