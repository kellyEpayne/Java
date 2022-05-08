import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save {

    Scanner fileScanner = new Scanner("TheDarkKingFiles\\TDKRsavefile.txt");
    
    public static void createSaveFile(){
        //Creates a save file for the game if there is none
        try{
            File saveFile = new File("TheDarkKingFiles\\TDKRsavefile.txt");
            if(saveFile.createNewFile()){
                System.out.println("No save file present");
                System.out.println("Creating save file");
            }
        }catch (IOException e){
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
    
    public static void newGame(Player player){
        //newGame is given the player character so I could use their scanner to create a name for the player
        //orignaly I created a sperate scanner for this but then VSC would yell that the scanner was not closed
        //closing this second scanner broke the program

        //I run createSaveFile here just to make sure this is a save file to write to
        createSaveFile();

        try{
            FileWriter defaultSave = new FileWriter("TheDarkKingFiles\\TDKRsavefile.txt");

            //Players are allowed to chose their name upon creating a new save file
            System.out.println("What is your name?");
            String playerName = player.playerInput.nextLine();
            //These lines are the players default stats
            int maxHealth = 10;
            int health = 10;
            int attack = 1;
            int gold = 10;
            int exp = 0;
            int expToLevel = 10;
            int level = 1;
            boolean hasCaveMap = false;
            boolean hasCastleMap = false;
            boolean hasCrown = false;

            //These lines puts all the default stats into the save file
            defaultSave.write(playerName);
            defaultSave.write("\n");
            defaultSave.write(String.valueOf(maxHealth));
            defaultSave.write("\n");
            defaultSave.write(String.valueOf(health));
            defaultSave.write("\n");
            defaultSave.write(String.valueOf(attack));
            defaultSave.write("\n");
            defaultSave.write(String.valueOf(gold));
            defaultSave.write("\n");
            defaultSave.write(String.valueOf(exp));
            defaultSave.write("\n");
            defaultSave.write(String.valueOf(expToLevel));
            defaultSave.write("\n");
            defaultSave.write(String.valueOf(level));
            defaultSave.write("\n");
            defaultSave.write(String.valueOf(hasCaveMap));
            defaultSave.write("\n");
            defaultSave.write(String.valueOf(hasCastleMap));
            defaultSave.write("\n");
            defaultSave.write(String.valueOf(hasCrown));
            defaultSave.write("\n");          
            defaultSave.write("Lesser Health Potion");
            defaultSave.write("\n");
            defaultSave.write("Lesser Health Potion");
            defaultSave.write("\n");

            defaultSave.close();
        } catch (IOException e){
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public static void saveGame(Player player){


        try{
        FileWriter playerSave = new FileWriter("TheDarkKingFiles\\TDKRsavefile.txt");


        playerSave.write(player.pName);
        playerSave.write("\n");
        playerSave.write(String.valueOf(player.maxHealth));
        playerSave.write("\n");
        playerSave.write(String.valueOf(player.health));
        playerSave.write("\n");
        playerSave.write(String.valueOf(player.attack));
        playerSave.write("\n");
        playerSave.write(String.valueOf(player.gold));
        playerSave.write("\n");
        playerSave.write(String.valueOf(player.exp));
        playerSave.write("\n");
        playerSave.write(String.valueOf(player.expToLevel));
        playerSave.write("\n");
        playerSave.write(String.valueOf(player.level));
        playerSave.write("\n");
        playerSave.write(String.valueOf(player.hasCaveMap));
        playerSave.write("\n");
        playerSave.write(String.valueOf(player.hasCastleMap));
        playerSave.write("\n");
        playerSave.write(String.valueOf(player.hasCrown));
        playerSave.write("\n");

        for(int i = 0; i < player.getPlayerInventory().size(); i++){
            //Saves the players inventory
            playerSave.write(player.getPlayerItem(i));
            playerSave.write("\n");
        }
        
        
        playerSave.close();
        }catch (IOException e){
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public static void loadGame(Player player){
        //Load player stats from TDKRsavefile

        try{
            File loadSave = new File("TheDarkKingFiles\\TDKRsavefile.txt");
            Scanner saveReader = new Scanner(loadSave);
            //if there is no file it loads the default player save
            if(loadSave.createNewFile()){
                newGame(player);
            }

            player.pName = saveReader.nextLine();
            player.maxHealth = saveReader.nextInt();
            player.health = saveReader.nextInt();
            player.attack = saveReader.nextInt();
            player.gold = saveReader.nextInt();
            player.exp = saveReader.nextInt();
            player.expToLevel = saveReader.nextInt();
            player.level = saveReader.nextInt();
            player.hasCaveMap = saveReader.nextBoolean();
            player.hasCastleMap = saveReader.nextBoolean();
            player.hasCrown = saveReader.nextBoolean();

            //If the player goes to the title screen and reloads their save it would duplicate their items
            //this line stops that
            player.inventory.clear();

            while ( saveReader.hasNext()){
                player.inventory.add(saveReader.nextLine());
            }

            //Removes the first item added which is null
            player.inventory.remove(0);
            saveReader.close();

        }catch(IOException e){
            System.out.println("An error occured.");
        }
    }
}
