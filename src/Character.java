public abstract class Character {
    protected String name;
    protected int health;
    protected int strength;
    protected int agility;
    protected int experience = 0;
    protected int gold = 0;

    public Character(String name, int health, int strength, int agility) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int attack() {
        int randomValue = (int) (Math.random() * 100);
        if (agility * 3 > randomValue) {
            int damage = (Math.random() < 0.1) ? strength * 2 : strength; // 10% шанс критического удара
            return damage;
        } else {
            return 0; // промах
        }
    }

    public void takeDamage(int damage) {
        health -= damage;
    }
}

