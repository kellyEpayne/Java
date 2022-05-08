public class TheDarkKing {
    public static void main(String[] args) {
        System.out.println("The Dark King Rises");

        Player player = new Player();
        String playerChoice = "Nothing";
        String prompt = "NEW GAME  LOAD GAME  LORE  QUIT";
        String[] validInputs = {"NEW", "NEW GAME", "LOAD", "LOAD GAME", "QUIT", "LORE"};

        while(!(playerChoice.equals("QUIT"))){
            playerChoice = player.PlayerAction(validInputs, prompt);
            if (playerChoice.equals("NEW") || playerChoice.equals("NEW GAME")){
                Save.newGame(player);
            }else if(playerChoice.equals("LOAD") || playerChoice.equals("LOAD GAME")){
                Save.loadGame(player);
                do{
                    //Do loop so that players location does not get locked as MAIN SCREEN
                    Location.selectLocation(player);
                }while(player.isAlive() && !(player.getPlayerLocation().equals("MAIN SCREEN")));
            }else if(playerChoice.equals("LORE")){
                System.out.println("Every thousand years the Dark King rises and threatens to destroy the world.");
            }
        }
    }
}
