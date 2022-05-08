import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    String location;
    String pName;
    int maxHealth;
    int health;
    int attack;
    int gold;
    int exp;
    int expToLevel;
    int level;
    boolean alive = true;
    //Has map felt easier then running through the inventory to check for maps
    boolean hasCaveMap;
    boolean hasCastleMap;
    boolean hasCrown;
    // The player will start with an empty inventory
    ArrayList<String> inventory = new ArrayList<String>();
    Scanner playerInput = new Scanner(System.in);
    
public boolean isAlive(){
    return alive;
}

public void displayCurrentHealth(){
    System.out.printf("Current hp %d/%d%n%n", health, maxHealth);
}

public void killPlayer(){
    alive = false;
}

public String getPlayerLocation(){
    return location;
}

public void setPlayerLocation(String newLocation){
    location = newLocation;
}

public ArrayList<String> getPlayerInventory(){
    return inventory;
}

public String getPlayerItem(int index){
    return inventory.get(index);
}

public void addToInventory(String item){
    inventory.add(item);
    System.out.printf("%s was added to your inventory%n", item);
}

public void removeFromInventory(int index){
    String item = inventory.get(index);
    if(item.equals("Cave Map") || item.equals("Castle Map") || item.equals("The Dark King's Crown")){
        //Prevents players from deleting map items
        System.out.printf("You cannot use %s%n", item);
    }else{
        inventory.remove(index);
        System.out.printf("%s was used%n", item);
    }
}

public void fullHealPlayer(){
    health = maxHealth;
    System.out.println("You have been fully healed");
    displayCurrentHealth();
}

public String PlayerAction(String[] validInputs, String prompt){
    //Used for most choices
    String playerChoice = "Nothing";
    boolean validChoice = false;

    // Runs till the player chooses a vaild option
    while( !(validChoice)){
        System.out.println(prompt);
        playerChoice = playerInput.nextLine().toUpperCase();

        // for loop checks if player input is one of the vaild inputs for the prompt
        for (String validInput: validInputs){
            if (playerChoice.equals(validInput)){
                validChoice = true;
            }
        }
    }

    return playerChoice;
    }

public String PlayerAction(ArrayList<String> validInputs, String prompt){
    //I wanted to use player action for the item selection but I needed an Arraylist to adapt to the players inventory
    String playerChoice = "Nothing";
    boolean validChoice = false;

    // Runs till the player chooses a vaild option
    while( !(validChoice)){
        System.out.println(prompt);
        playerChoice = playerInput.nextLine().toUpperCase();

        // for loop checks if player input is one of the vaild inputs for the prompt
        for (String validInput: validInputs){
            if (playerChoice.equals(validInput)){
                validChoice = true;
            }
        }
    }

    return playerChoice;
    }

public void amountHealPlayer(int amount){
    health += amount;
    if (health > maxHealth){
        health = maxHealth;
    }
    displayCurrentHealth();
    
}
}