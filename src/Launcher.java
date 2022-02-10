import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue");
        Scanner scanner = new Scanner(System.in);
        List<Command> commands = new ArrayList<Command>();
        commands.add(new Fibo());
        commands.add(new Freq());
        commands.add(new Quit());

        while (true) {
            System.out.println("Entrer commande :");
            String input = scanner.nextLine();
            Command command = commands.stream().filter(cmd -> input.equals(cmd.name())).findAny().orElse(null);

            if (Objects.isNull(command)) {
                System.out.println("Unknown command");
            }
            else {
                boolean isRunning = command.run(scanner);
                if (isRunning && command.name().equals("quit")) {
                    break;
                }
            }
        }
        scanner.close();
    }
}
