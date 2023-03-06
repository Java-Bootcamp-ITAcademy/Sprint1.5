/*** S1.5 Nivell 1 exercici 1 ***/
package n1exercici1;

import java.io.File;
import java.util.Arrays;
import java.util.*;

public class Alfabetic {
    public static void llistar(String s) {
        File f=new File(s);
        File[] ff=f.listFiles();
        Arrays.sort(ff);
        for(File file:ff) {
            System.out.println(file.getName());
        }

    }

}
