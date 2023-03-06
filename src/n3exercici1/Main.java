package n3exercici1;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        File countries=new File(args[0]);
        File countriesEncrypted=new File(args[1]);
        File countriesDecrypted=new File(args[2]);
        File directoris=new File(args[3]);
        File directorisEncrypted=new File(args[4]);
        File directorisDecrypted=new File(args[5]);

        Encriptacio encriptacio=new Encriptacio();
        encriptacio.init();
        encriptacio.encrypt(countries,countriesEncrypted);
        encriptacio.encrypt(directoris,directorisEncrypted);
        encriptacio.deCrypt(countriesEncrypted,countriesDecrypted);
        encriptacio.deCrypt(directorisEncrypted,directorisDecrypted);

    }
}
