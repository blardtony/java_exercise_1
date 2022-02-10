import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Fibo implements Command {

    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Entrer un nombre :");
        int fibo = parseInt(scanner.nextLine());
        int nb1 = 0, nb2 = 1, sum = 0;
        for (int i = 1; i < fibo; i++) {
            sum = nb1 + nb2;
            nb1 = nb2;
            nb2 = sum;
        }
        System.out.println("" + sum);
        return true;
    }
}
