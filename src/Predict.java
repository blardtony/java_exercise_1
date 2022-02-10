import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Predict implements Command{
    @Override
    public String name() {
        return "predict";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Entrer le chemin du fichier");
        String pathString = scanner.nextLine();
        Path path = Paths.get(pathString);
        try {
            String text = Files.readString(path);
        } catch (IOException e) {
            System.out.println("Unreadable file: " + e.getClass() + " " + e.getMessage());
            return false;
        }
        return false;
    }
}
