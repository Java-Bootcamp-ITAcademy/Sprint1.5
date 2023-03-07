/*** S1.5 Nivell 2 exercici 1 ***/

package n2exercici1;



import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Properties;

public class DirectorisAFitxerParametritzat implements FileVisitor<Path> {
    private static Properties properties;
    private PrintWriter printWriter;

    public static Properties getProperties() {
        return properties;
    }

    public static void setProperties(Properties properties) {
        DirectorisAFitxerParametritzat.properties = properties;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        printWriter.append("D: " + dir + "\n");
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        printWriter.append("  |__F: " + file + "\n");

        return FileVisitResult.CONTINUE;

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

    public void initPrintWriter() throws FileNotFoundException {
        this.printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(properties.getProperty("arxiuAEscriure"), true)));  //Declaring printWriter and appending lines to the file.

    }
    public void closePrintWriter() {
        this.printWriter.close();
    }

}
