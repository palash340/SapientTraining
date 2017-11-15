package com.traningTest;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by pjai60 on 11/8/2017.
 */
public class MapTest {
    public static void main(String[] args) {
        Map<TestObj ,Integer> map = new ConcurrentHashMap<>();
        map.put(new TestObj(2), 2);
        map.put(new TestObj(3), 3);
        map.put(new TestObj(4), 4);
        map.put(new TestObj(5), 5);
        map.put(new TestObj(6), 6);

        Iterator<Map.Entry<TestObj, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getValue());
            map.put(new TestObj(1), 1);
            map.put(new TestObj(8), 8);
        }

    }
}

class TestObj{
    int i;

    public TestObj(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestObj)) return false;

        TestObj testObj = (TestObj) o;

        return i == testObj.i;
    }

    @Override
    public int hashCode() {
        return 10;
    }
}




