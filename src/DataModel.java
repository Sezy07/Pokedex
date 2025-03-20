public class DataModel {
    private int id;
    private String name;
    private int height;
    private int weight;
    private int hp;
    private int attack;
    private int defense;
    private int s_attack;
    private int s_defense;
    private int speed;
    private String primaryType;  // Primary type of Pokémon
    private String secondaryType;  // Secondary type of Pokémon (if any)
    private int evo_set;

    // Constructor
    public DataModel(int id, String name, int height, int weight, int hp, int attack, int defense, int s_attack,
                     int s_defense, int speed, String primaryType, String secondaryType, int evo_set) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.s_attack = s_attack;
        this.s_defense = s_defense;
        this.speed = speed;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
        this.evo_set = evo_set;
    }

    // Getters for all fields
    public String getPrimaryType() {
        return primaryType;
    }

    public String getSecondaryType() {
        return secondaryType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getS_attack() {
        return s_attack;
    }

    public int getS_defense() {
        return s_defense;
    }

    public int getSpeed() {
        return speed;
    }

    public int getEvo_set() {
        return evo_set;
    }
}


