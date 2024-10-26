import java.util.Scanner;

public class Game {
    private Player player;
    private Merchant merchant = new Merchant();

    // Метод для запуска основного игрового процесса
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя персонажа:");
        String name = scanner.nextLine();
        player = new Player(name);
        System.out.println("Здравствуй, " + player.name + "! Вам выпала честь спасти мир от монстров! Желаю успеха!");

        boolean playing = true;
        while (playing) {
            System.out.println("Куда вы хотите пойти?");
            System.out.println("1. К торговцу");
            System.out.println("2. В тёмный лес");
            System.out.println("3. На выход");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    merchant.trade(player);
                    break;
                case "2":
                    boolean inBattle = true;
                    while (inBattle) {
                        Character enemy = (Math.random() < 0.5) ? new Goblin() : new Skeleton();
                        Battle battle = new Battle(player, enemy);
                        Thread battleThread = new Thread(battle);
                        battleThread.start();

                        // Ждем завершения боя
                        try {
                            battleThread.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if (battle.isPlayerWon()) {
                            System.out.println("Хотите продолжить бой или вернуться в город?");
                            System.out.println("1. Продолжить бой");
                            System.out.println("2. Вернуться в город");
                            String postBattleChoice = scanner.nextLine();
                            inBattle = postBattleChoice.equals("1");
                        } else {
                            System.out.println("Вы были побеждены. Игра окончена.");
                            playing = false;
                            inBattle = false;
                        }
                    }
                    break;
                case "3":
                    System.out.println("Выход из игры.");
                    playing = false;
                    break;
                default:
                    System.out.println("Неверная команда.");
            }
        }
        scanner.close();
    }

    // Метод main, запускающий игру
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
