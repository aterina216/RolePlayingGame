import java.util.Scanner;

public class Merchant {
    private final int potionCost = 10;

    public void trade(Player player) {
        Scanner scanner = new Scanner(System.in);
        boolean trading = true;

        while (trading) {
            System.out.println("Вы хотите купить зелье за " + potionCost + " золота? (да/нет)");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("да") && player.buyPotion(potionCost)) {
                player.heal();
                System.out.println("Вы исцелены!");
            } else if (input.equalsIgnoreCase("нет")) {
                System.out.println("Торговля завершена.");
            } else {
                System.out.println("Недостаточно золота или неверный ввод.");
            }

            System.out.println("Хотите продолжить торговлю или вернуться в город?");
            System.out.println("1. Продолжить торговлю");
            System.out.println("2. Вернуться в город");
            String choice = scanner.nextLine();

            trading = choice.equals("1");
        }
    }
}

