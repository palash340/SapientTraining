package com.traningTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by pjai60 on 11/8/2017.
 */
public class SearchCriteria {

    public static void main(String[] args) {
        List<MyEntity> list = new ArrayList<>();
        list.add(new MyEntity(1, "Palash1", "SDE-I"));
        list.add(new MyEntity(2, "Palash2", "SDE-II"));
        list.add(new MyEntity(3, "Palash3", "SDE-III"));


        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if((o1 instanceof MyEntity && o2 instanceof  MyEntity))
                    System.out.println("I am getting called");
                return 0;
            }
        };

        Predicate<MyEntity> cd = new Predicate<MyEntity>() {
            @Override
            public boolean test(MyEntity myEntity) {
                return myEntity.getName().startsWith("Pa");
            }
        };

        SearchCriteria sc = new SearchCriteria();
        sc.search(list,comparator);

    }

    public void search(List list, Comparator comparator){
        Collections.sort(list,comparator);
    }
    public static List<MyEntity> filterMyEntity (List<MyEntity> myEntities, Predicate<MyEntity> predicate) {
        return myEntities.stream().filter( predicate ).collect(Collectors.<MyEntity>toList());
    }


}

class MyEntity{
    int id;
    String name;
    String designation;

    public MyEntity(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
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

    public String getDesignation() {
        return designation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyEntity)) return false;

        MyEntity myEntity = (MyEntity) o;

        if (getId() != myEntity.getId()) return false;
        if (!getName().equals(myEntity.getName())) return false;
        return getDesignation().equals(myEntity.getDesignation());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDesignation().hashCode();
        return result;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
