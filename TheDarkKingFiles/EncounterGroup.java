import java.util.HashMap;

public class EncounterGroup {

    static HashMap <String, String[]> encounterLocation(String location){
        HashMap <String, String[]> encounters;

        if(location.equals("FOREST")){
            encounters = Forest();
        }else if(location.equals("CAVE")){
            encounters = Cave();
        }else{
            encounters = Castle();
        }

        return encounters;
    }

    static HashMap <String, String[]> Forest(){
        HashMap <String, String[]> forestEncounters = new HashMap<String, String[]>();
        // Everything is stored as a string but can and will turn into an int when necessary.
        //                    name,  health, attack, gold, xp
        String[] monster1 = {"Small spider", "1", "1", "0", "2"};
        String[] monster2 = {"Slime", "5", "2", "3", "4"};
        String[] monster3 = {"Boar", "10", "4", "5", "6"};
        String[] monster4 = {"Shade Elk", "20", "6", "10", "10"};
        String[] monster5 = {"Bear", "30", "10", "20", "20"};


        forestEncounters.put("Monster 1", monster1);
        forestEncounters.put("Monster 2", monster2);
        forestEncounters.put("Monster 3", monster3);
        forestEncounters.put("Monster 4", monster4);
        forestEncounters.put("Monster 5", monster5);

        return forestEncounters;
    }

    static HashMap <String, String[]> Cave(){
        HashMap <String, String[]> caveEncounters = new HashMap<String, String[]>();
        // Everything is stored as a string but can and will turn into an int when necessary.
        //                    name,  health, attack, gold, xp
        String[] monster1 = {"Cave Spider", "40", "15", "20", "50"};
        String[] monster2 = {"Cave Bear", "50", "25", "30", "75"};
        String[] monster3 = {"Bolder Beast", "100", "25", "10", "100"};
        String[] monster4 = {"Creeping Shadow", "75", "60", "10", "150"};
        String[] monster5 = {"Demi Dragon", "200", "50", "100", "200"};


        caveEncounters.put("Monster 1", monster1);
        caveEncounters.put("Monster 2", monster2);
        caveEncounters.put("Monster 3", monster3);
        caveEncounters.put("Monster 4", monster4);
        caveEncounters.put("Monster 5", monster5);

        return caveEncounters;
    }

    static HashMap <String, String[]> Castle(){
        HashMap <String, String[]> castleEncounters = new HashMap<String, String[]>();
        // Everything is stored as a string but can and will turn into an int when necessary.
        //                    name,  health, attack, gold, xp
        String[] monster1 = {"Shade spider", "100", "50", "25", "200"};
        String[] monster2 = {"Dark Solider", "75", "40", "10", "300"};
        String[] monster3 = {"Sprinting Shadow", "50", "120", "0", "400"};
        String[] monster4 = {"Shadow Dragon", "400", "100", "75", "500"};
        String[] monster5 = {"Shade Beast", "200", "80", "20", "600"};


        castleEncounters.put("Monster 1", monster1);
        castleEncounters.put("Monster 2", monster2);
        castleEncounters.put("Monster 3", monster3);
        castleEncounters.put("Monster 4", monster4);
        castleEncounters.put("Monster 5", monster5);

        return castleEncounters;
    }

    static String[] bosses(String location){
        //                  0        1         2        3      4       5
        String[] boss = {"name", "health", "damage", "gold", "xp", "area map"};

        if (location.equals("FOREST")){
            boss[0] = "Giant Spider";
            boss[1] = "100";
            boss[2] = "25";
            boss[3] = "100";
            boss[4] = "200";
            boss[5] = "Cave Map";
        }else if(location.equals("CAVE")){
            boss[0] = "Dragon";
            boss[1] = "400";
            boss[2] = "50";
            boss[3] = "5000";
            boss[4] = "500";
            boss[5] = "Castle Map";
        }else if(location.equals("Castle")){
            boss[0] = "The Dark King";
            boss[1] = "1000";
            boss[2] = "1000";
            boss[3] = "1000";
            boss[4] = "1000";
            boss[5] = "The Dark King's Crown";
        }

        return boss;
    }

}
