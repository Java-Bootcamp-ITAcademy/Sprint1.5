package n1exercici5;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main (String[] args) {
        File f=new File(args[0]);  //fora.ser
        try {
            f.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ClasseSerialitzable classeSerialitzable=new ClasseSerialitzable(args[1],Integer.parseInt(args[2]),args[3]);
        classeSerialitzable.serialitza(f);
        ClasseSerialitzable desSerialitzat=ClasseSerialitzable.deserialitza(f);
        System.out.println(desSerialitzat.getNom()+" "+desSerialitzat.getEdat()+" "+desSerialitzat.getDNI());
    }

}
