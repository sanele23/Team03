package team03;
import java.util.HashMap;
import java.util.Map;

public class Player {

    private String name;
    private int health;
    private int mana;
    private int gold;
    private Map<String, Integer> equipment;

    public Player() {
        name = "Unspecified";
        health = 0;
        mana = 0;
        gold = 0;
        equipment = new HashMap<>();
    }

    // Display the Player
    public void display() {
        System.out.format("Player: %s%n", name);
        System.out.format("Health: %s%n", health);
        System.out.format("Mana: %s%n", mana);
        System.out.format("Gold: %s%n", gold);
        System.out.format("Equipment: %s%n", equipment);
        equipment.forEach((n,c) -> {System.out.format("\tName: %s; Cost: %d%n", n, c); });
    }

    // Getter and Setter (Player : Name)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter (Player : Health)
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    // Getter and Setter (Player : Mana)
    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }

    // Getter and Setter (Player : Gold)
    public int getGold() {
        return gold;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }

    // Add equipment to the player
    public void equip(String name, int cost) {
        equipment.put(name, cost);
    }
}
