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
    private String type;
    private int evo_set;

    // Constructors
    public DataModel(int id, String name, int height, int weight, int hp, int attack, int defense, int s_attack,
                     int s_defense, int speed, String type, int evo_set) {
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
        this.type = type;
        this.evo_set = evo_set;
    }

    // Getter methods for all fields
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

    public String getType() {
        return type;
    }

    public int getEvo_set() {
        return evo_set;
    }
}

