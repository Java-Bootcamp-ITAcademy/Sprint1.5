package n1exercici3;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        DirectorisAFitxer directorisAFitxer=new DirectorisAFitxer(args[0],args[1]);
        Writer netejador=new PrintWriter(directorisAFitxer.getArxiuDeDesti());  //Instantiating file cleaner
        netejador.write("");  //Cleaning file
        Files.walkFileTree(Paths.get(directorisAFitxer.getDirectoriOrigen()),directorisAFitxer);  //Executing File visitor
    }
}
