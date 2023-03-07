/*** S1.5 Nivell 1 exercici 3 ***/

package n1exercici3;


import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirectorisAFitxer implements FileVisitor<Path> {

    private String directoriOrigen;
    private  String arxiuDeDesti;
    private PrintWriter printWriter;

    public DirectorisAFitxer(String directoriOrigen, String arxiuDeDesti) {
        this.directoriOrigen=directoriOrigen;
        this.arxiuDeDesti=arxiuDeDesti;
    }

    public String getDirectoriOrigen() {
        return directoriOrigen;
    }

    public void setDirectoriOrigen(String directoriOrigen) {
        this.directoriOrigen = directoriOrigen;
    }

    public String getArxiuDeDesti() {
        return arxiuDeDesti;
    }

    public void setArxiuDeDesti(String arxiuDeDesti) {
        this.arxiuDeDesti = arxiuDeDesti;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        printWriter.append("D: "+new File(dir.toUri()).getName()+"\n");
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        printWriter.append("  |__F: "+file.getFileName()+" ha estat modificat per últim cop el "+attrs.lastModifiedTime()+"\n");
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

    public void initPrintWriter() throws FileNotFoundException {
        this.printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(arxiuDeDesti, true)));  //Declaring printWriter and appending lines to the file.

    }
    public void closePrintWriter() {
        this.printWriter.close();
    }
}