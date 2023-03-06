package n1exercici2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path=Paths.get(args[0]);
        MostrarDirectoris mostrarDirectoris=new MostrarDirectoris();
        Files.walkFileTree(path,mostrarDirectoris);
    }
}
