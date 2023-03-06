package n1exercici5;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main (String[] args) {
        File f=ClasseSerialitzable.creatingFile(args[0]);  //Creating destination file
        ClasseSerialitzable classeSerialitzable=new ClasseSerialitzable(args[1],Integer.parseInt(args[2]),args[3]);
        classeSerialitzable.serialitza(f);  //Serializing file
        ClasseSerialitzable desSerialitzat=ClasseSerialitzable.deserialitza(f);  //Deserializing file
        System.out.println(desSerialitzat.getNom()+" "+desSerialitzat.getEdat()+" "+desSerialitzat.getDNI());
    }

}
