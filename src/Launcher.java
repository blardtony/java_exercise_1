import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Entrer commande :");
            String input = scanner.nextLine();
            if (input.equals("quit")) {
                break;
            }
            if (input.equals("fibo")) {
                System.out.println("Entrer un nombre :");
                int fibo = parseInt(scanner.nextLine());
                int nb1 = 0, nb2 = 1, sum = 0;
                for (int i = 1; i < fibo; i++) {
                    sum = nb1 + nb2;
                    nb1 = nb2;
                    nb2 = sum;
                }
                System.out.println("" + sum);
                continue;
            }
            System.out.println("Unknown command");
        }

    }
}
