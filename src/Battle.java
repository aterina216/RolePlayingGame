public class Battle implements Runnable {
    private Player player;
    private Character enemy;
    private boolean playerWon;

    public Battle(Player player, Character enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    @Override
    public void run() {
        System.out.println("Начался бой с " + enemy.name + "!");
        while (player.isAlive() && enemy.isAlive()) {
            int playerAttack = player.attack();
            enemy.takeDamage(playerAttack);
            System.out.println(player.name + " атакует на " + playerAttack + " урона.");

            if (enemy.isAlive()) {
                int enemyAttack = enemy.attack();
                player.takeDamage(enemyAttack);
                System.out.println(enemy.name + " наносит ответный удар на " + enemyAttack + " урона.");
            }
        }

        if (player.isAlive()) {
            System.out.println("Вы победили " + enemy.name + "!");
            player.gainExperience(50);
            player.gold += 10;
            System.out.println("Ваше золото " + player.gold + ". Ваш опыт " + player.experience);
            playerWon = true;
        } else {
            System.out.println("Вы были побеждены...");
            playerWon = false;
        }
    }

    public boolean isPlayerWon() {
        return playerWon;
    }
}

