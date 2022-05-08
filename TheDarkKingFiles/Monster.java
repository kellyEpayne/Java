public class Monster{
    String name;
    int health;
    int attack;
    int gold;
    int exp;
    boolean alive;
    String map;
    boolean hasMap;

    public Monster(String location){
    String[] monsterStats = Encounter.encounterRoll(location);
    //name,  health, attack, gold, xp
    name = monsterStats[0];
    health = Integer.parseInt(monsterStats[1]);
    attack = Integer.parseInt(monsterStats[2]);
    gold = Integer.parseInt(monsterStats[3]);
    exp = Integer.parseInt(monsterStats[4]);
    alive = true;
    if (monsterStats.length == 6){
        map = monsterStats[5];
        hasMap = true;
    } else{
        hasMap = false;
    }
}
}