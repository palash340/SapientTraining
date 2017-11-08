package com.traningTest;

import java.io.*;

/**
 * Created by Palash on 11/7/2017.
 */
public class CSerial extends  BSerial implements Serializable {
    CSerial(){
        System.out.println("CSerial.CSerial");
    }

    public static void main(String[] args) {
        CSerial c = new CSerial();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("f.txt"))) {
            oos.writeObject(c);
            oos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CSerial c2 = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("f.txt"))) {
            c2 = (CSerial) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class ASerial {
    ASerial(){
        System.out.println("ASerial.ASerial");
    }
}

class BSerial extends  ASerial{
    BSerial(){
        System.out.println("BSerial.BSerial");
    }
}
