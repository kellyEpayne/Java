public class Battle {
    
    static void battle(Player player, String location){
        //Starts when a player selects HUNT
        
        //Generates the monster that the player will be fighting
        Monster monster = new Monster(location);
        String[] validBattleInputs = {"FIGHT","ITEM","RUN"};
        String battlePrompt = "FIGHT ITEM RUN";
        
        if(bossCheck(player, monster)){
            return;
        }
        
        System.out.printf("You spot a %s%n", monster.name);
        String playerAction = player.PlayerAction(validBattleInputs,battlePrompt);
        if (playerAction.equals("RUN")){
            //lets players check which monster it is before fighting
            monster.alive = false;
        }
        while (player.isAlive() && monster.alive){
            if (playerAction.equals("FIGHT")){
                playerAttack(player, monster);
            }else if (playerAction.equals("ITEM")){
                Item.useItem(player);
            }else{
                System.out.println("You ran away!");
                //player runs away after finding they are out matched
                break;
            }
            //If the monster is still alive it will fight the player
            if (monster.health <= 0){
                monster.alive = false;
                System.out.println("You won!");
                monsterDefeat(player, monster);
            }else{
                monsterAttack(player, monster);
                if (player.alive){
                    playerAction = player.PlayerAction( validBattleInputs, battlePrompt);
                }
            }
            
        }
    }    

    private static void playerAttack(Player player, Monster monster){
        monster.health = monster.health - player.attack;
        System.out.printf("You dealt %d damage%n%n", player.attack);
    }

    private static void monsterAttack(Player player, Monster monster){
        player.health = player.health - monster.attack;
        System.out.printf("The %s dealt %d damage%n", monster.name, monster.attack);
        player.displayCurrentHealth();
        if (player.health <= 0){
            player.alive = false;
            System.out.println("You have died.");
        }
    }

    private static void monsterDefeat(Player player, Monster monster){
        //This will be called when a monster is defeated. This gives the player their rewards
        player.exp += monster.exp;
        player.gold += monster.gold;

        if (monster.hasMap){
            player.inventory.add(monster.map);
            mapSwitch(player, monster.map);
            System.out.println("You have killed the boss for this area.");
        }

        if(player.exp >= player.expToLevel){
            playerLevelUp(player);
        }
    }

    private static void playerLevelUp(Player player){
        //This method increases the players level, sets the next exp requirement and heals the player
        while (player.exp >= player.expToLevel){
            player.exp = player.exp - player.expToLevel;
            player.maxHealth = player.maxHealth + (player.level * 5);
            player.attack = player.attack + (player.level * 2);
            player.expToLevel *= 2;
            player.level ++;
            System.out.println("You have leveled up!\n");
        }
        System.out.printf("Current exp %d :Exp to next level %d :%n", player.exp, player.expToLevel);
        player.fullHealPlayer();

    }

    private static boolean bossCheck(Player player, Monster monster){
        //checks if the player has already defeated a boss. You can't kill a boss twice
        //Cave Map, Castle Map and The Dark Kings Crown are all boss drops
        boolean areaBossDefeated = false;

        if (monster.hasMap){
            if(monster.map.equals("Cave Map")){
                if(player.hasCaveMap){
                    corpseMessage(monster.name);
                    areaBossDefeated = true;
                }
            }else if(monster.map.equals("Castle Map")){
                if(player.hasCastleMap){
                    corpseMessage(monster.name);
                    areaBossDefeated = true;
                }
            }else if(monster.map.equals("The Dark King's Crown")){
                if(player.hasCrown){
                corpseMessage(monster.name);
                areaBossDefeated = true;
                }
            }
        }

        return areaBossDefeated;
    }

    private static void corpseMessage(String monsterName){
        //Only to be called for bosses
        System.out.printf("You found the corpse of the%s%n", monsterName);
    }

    private static void mapSwitch(Player player, String Map){
        //Toggles hasBLANKMap in play to true
        if(Map.equals("Cave Map")){
            player.hasCaveMap = true;
        }else if(Map.equals("Castle Map")){
            player.hasCastleMap = true;
        }
    }
}