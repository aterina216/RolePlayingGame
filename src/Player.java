public class Player extends Character {
    private int level = 1;
    private int experienceToNextLevel = 100;

    public Player(String name) {
        super(name, 100, 10, 5); // Начальные параметры игрока
    }

    public void gainExperience(int exp) {
        experience += exp;
        while (experience >= experienceToNextLevel) {
            experience -= experienceToNextLevel;
            levelUp();
        }
    }

    private void levelUp() {
        level++;
        experienceToNextLevel += level * 50;
        strength += 2;
        agility += 1;
        health += 10;
        System.out.println(name + " получил новый уровень: " + level);
    }

    public void heal() {
        health = Math.min(health + 20, 100); // Лечится на 20 очков здоровья
    }

    public boolean buyPotion(int cost) {
        if (gold >= cost) {
            gold -= cost;
            return true;
        } else {
            System.out.println("Недостаточно золота.");
            return false;
        }
    }
}




