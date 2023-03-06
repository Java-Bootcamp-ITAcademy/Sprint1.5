package n3exercici1;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encriptacio {
    private SecretKey key;
    private Cipher cipher;
    private byte[] iv=new byte[16];
    private File countries=new File("countries.txt");
    private File countriesEncrypted=new File("countriesEncrypted.txt");
    private File countriesDecrypted=new File("countriesDecrypted.txt");


    public void init() throws NoSuchAlgorithmException {  //Generating key
        KeyGenerator keyGenerator=KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        key = keyGenerator.generateKey();
    }

    /* Encrypting */
    public void encrypt(File inputFile, File outputFile) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        FileInputStream fileInputStream=new FileInputStream(inputFile);
        byte[] inputBytes=new byte[(int) inputFile.length()];
        fileInputStream.read(inputBytes);
        cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes=cipher.doFinal(inputBytes);

        FileOutputStream outputStream = new FileOutputStream(outputFile);
        outputStream.write(encryptedBytes);
        outputStream.close();
        fileInputStream.close();
    }

    /* Decrypting */
    public void deCrypt(File inputFile, File outputFile) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        FileInputStream fileInputStream=new FileInputStream(inputFile);
        byte[] inputBytes=new byte[(int) inputFile.length()];
        fileInputStream.read(inputBytes);
        Cipher encryptedCipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        GCMParameterSpec spec = new GCMParameterSpec(128, cipher.getIV());
        cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(iv));
        byte[] encryptedBytes=cipher.doFinal(inputBytes);

        FileOutputStream outputStream = new FileOutputStream(outputFile);
        outputStream.write(encryptedBytes);
        outputStream.close();
        fileInputStream.close();
    }
}
