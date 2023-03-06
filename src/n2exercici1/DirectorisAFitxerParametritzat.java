/*** S1.5 Nivell 2 exercici 1 ***/

package n2exercici1;



import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Properties;

public class DirectorisAFitxerParametritzat implements FileVisitor<Path> {
    private static Properties properties;
    public static void main(String[] args) throws IOException {
        properties=definirProperties(args[0]);  //Setting properties from file
        DirectorisAFitxerParametritzat directorisAFitxerParametritzat=new DirectorisAFitxerParametritzat();  //Instantiating class
        Files.walkFileTree(Paths.get(properties.getProperty("directoriALlegir")),directorisAFitxerParametritzat);  //Executing File visitor
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(properties.getProperty("arxiuAEscriure"), true)));  //Declaring printWriter and appending lines to the file.
            writer.append("D: " + dir + "\n");
            writer.close();
            return FileVisitResult.CONTINUE;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(properties.getProperty("arxiuAEscriure"), true)));  //Declaring printWriter and appending lines to the file.
            writer.append("  F: " + file + "\n");
            writer.close();
            return FileVisitResult.CONTINUE;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Invalid file!");
        return FileVisitResult.TERMINATE;
    }


    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public static Properties definirProperties(String configuracio) throws IOException {  //Defining and loading config file
        FileInputStream propsInput = new FileInputStream(configuracio);
        Properties prop = new Properties();
        prop.load(propsInput);
        return prop;
    }

}
