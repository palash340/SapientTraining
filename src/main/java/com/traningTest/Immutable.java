package com.traningTest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pjai60 on 11/7/2017.
 */
public class Immutable {

    public static void main(String[] args) {
        Map<Employee1, String> map = new HashMap<Employee1, String>();
        Employee1 e1 = new Employee1(1, "Palash1", 100);
        Employee1 e2 = new Employee1(2, "Palash2", 100);
        Employee1 e3 = new Employee1(3, "Palash3", 100);
        map.put(e1, "1");
        map.put(e2, "2");
        map.put(e3, "3");
        e2.setName("PalashJ");
        String s = map.get(e2);
        System.out.println("s = " + s);
    }
}

class Employee1{
    int id;
    String name;
    long salary;

    public Employee1(int id, String name, long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee1 employee1 = (Employee1) o;

        if (id != employee1.id) return false;
        if (salary != employee1.salary) return false;
        return name != null ? name.equals(employee1.name) : employee1.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (salary ^ (salary >>> 32));
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
