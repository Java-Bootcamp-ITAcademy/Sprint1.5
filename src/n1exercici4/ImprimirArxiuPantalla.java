/*** S1.5 Nivell 1 exercici 4 ***/

package n1exercici4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ImprimirArxiuPantalla {
    public static void imprimirArxiuPantalla(String s)  {  //Defining static method for reading and printing through the file
        try {
            String linia="";
            BufferedReader bufferedReader=new BufferedReader(new FileReader(s));  //Instantiating BufferReader
            while((linia=bufferedReader.readLine())!=null) {  //Reading line
                System.out.println(linia);  //Printing line
            }
        } catch (Exception e) {
            System.out.println("Something's wrong!");
            throw new RuntimeException(e);
        }
    }
}
