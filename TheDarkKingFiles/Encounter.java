public class Encounter {
    static String[] encounterRoll(String location){

        int randInt = (int)(Math.random() * 101);
        String[] monster;
        
        if (randInt < 10){
            monster = EncounterGroup.encounterLocation(location).get("Monster 5");
            //monster = EncounterGroup.Forest().get("Monster 5");
        } else if (randInt < 25){
            monster = EncounterGroup.encounterLocation(location).get("Monster 4");
        } else if (randInt < 45){
            monster = EncounterGroup.encounterLocation(location).get("Monster 3");
        } else if (randInt < 60){
            monster = EncounterGroup.encounterLocation(location).get("Monster 2");
        } else if (randInt < 95){
            monster = EncounterGroup.encounterLocation(location).get("Monster 1");
        }else{
            monster = EncounterGroup.bosses(location);
        }

        return monster;

    }
}