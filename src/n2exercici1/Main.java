package n2exercici1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException {
        DirectorisAFitxerParametritzat.setProperties(DirectorisAFitxerParametritzat.definirProperties(args[0]));  //Setting properties from file
        DirectorisAFitxerParametritzat directorisAFitxerParametritzat=new DirectorisAFitxerParametritzat();  //Instantiating class
        Files.walkFileTree(Paths.get(DirectorisAFitxerParametritzat.getProperties().getProperty("directoriALlegir")),directorisAFitxerParametritzat);  //Executing File visitor
    }
}
