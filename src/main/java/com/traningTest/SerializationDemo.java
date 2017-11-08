package com.traningTest;

import java.io.*;

/**
 * Created by pjai60 on 11/7/2017.
 */
public class SerializationDemo {
    public static void main(String[] args) {

        //Employee e1 = new Employee();
       // e1.setId(1);
/*
        e1.setName("Palash");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("f.txt"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("f.txt"))) {
            oos.writeObject(e1);
            oos.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/


        Employee e2 = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("f.txt"))) {
            e2 = (Employee) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //1. Serialization always creates new object
        //System.out.println("e1==e2 = " + (e1 == e2));
       // System.out.println("e1.getId() -->" + e1.getId());
        //System.out.println("e2.getId() -->" + e2.getId());

        //2. Comment a field in employee class and just read object
       // System.out.println(e2.getId());
        //System.out.println(e2.getJab());

    }
}
class A2{
    public A2(){
        System.out.println("A2");
    }
}

class Employee extends  A2 implements Serializable{
    static final long serialVersionUID = 42L;

    public Employee(){
        System.out.println("Employee");
    }

    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJab() {
        return jab;
    }

    public void setJab(String jab) {
        this.jab = jab;
    }

    String jab;

}
