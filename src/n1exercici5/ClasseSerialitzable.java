/*** S1.5 Nivell 1 exercici 5 ***/

package n1exercici5;

import java.io.*;
import java.util.List;

public class ClasseSerialitzable implements Serializable {  //Making class serializable
    private String nom;
    private int edat;
    private transient String DNI;  //Excluding DNI from serialization

    public ClasseSerialitzable(String nom, int edat, String DNI) {  //Constructor
        this.nom=nom;
        this.edat=edat;
        this.DNI=DNI;
    }

    public String getNom() {
        return nom;
    }  //Getters ans setters

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void serialitza(File f) {  //Serializing method
        try {
            ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream((f)));  //Creating the Object stream
            out.writeObject(this);  //Writing object to the Output.txt stream
            out.close();
        }
        catch (Exception e) {

        }
    }

    public static ClasseSerialitzable deserialitza(File f) {  //Static method deserializing
        ClasseSerialitzable classeSerialitzable;
        try {
           ObjectInputStream in= new ObjectInputStream(new FileInputStream(f));  //Creating the stream from a FileStream
           Object o=in.readObject();  //Assigning the object read
           classeSerialitzable=(ClasseSerialitzable) o;  //Casting object to the given class
           in.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return classeSerialitzable;
    }

    public static File creatingFile(String path) {
        File f=new File(path);  //fora.ser
        try {
            f.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return f;
    }
}
