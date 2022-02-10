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
            if(input.equals("freq")) {
                System.out.println("Entrer le chemin du fichier");
                String pathString = scanner.nextLine();
                Path path = Paths.get(pathString);
                String text = "";
                if (!Files.exists(path)) {
                    System.out.println("Unreadable file: ");
                    continue;
                }
                try {
                    text = Files.readString(path);
                    text = text.replaceAll("[.!?\\-,\\n]", " ").toLowerCase(Locale.ROOT);
                    List<String> tab = List.of(text.split(" "));
                    Map<String, Long> list = tab.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

                    Map<String, Long> result = list.entrySet().stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .limit(3)
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
                    List<String> list3 = new ArrayList<>(result.keySet());
                    String res = String.join(" ", list3);
                    System.out.println(res);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                continue;
            }
            System.out.println("Unknown command");
        }
        scanner.close();
    }
}
