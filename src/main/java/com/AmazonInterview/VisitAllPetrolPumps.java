package com.AmazonInterview;

/**
 * Created by Palash on 11/29/2017.
 */
/*
* Suppose there is a circle. There are n petrol pumps on that circle. You are given two sets of data.

    1. The amount of petrol that every petrol pump has.
    2. Distance from that petrol pump to the next petrol pump.

    Calculate the first point from where a truck will be able to complete the circle
    (The truck will stop at each petrol pump and it has infinite capacity).
    Expected time complexity is O(n). Assume for 1 litre petrol, the truck can go 1 unit of distance.

    For example, let there be 4 petrol pumps with amount of petrol
    and distance to next petrol pump value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}.
    The first point from where truck can make a circular tour is 2nd petrol pump.
    Output should be “start = 1” (index of 2nd petrol pump).
*/
public class VisitAllPetrolPumps {
    static class PetrolPump{
        int distance;
        int fuel;

        public PetrolPump(int fuel, int distance) {
            this.distance = distance;
            this.fuel = fuel;
        }
    }

    public int pathPrint(PetrolPump[] pp, int size){
        int start = 0;
        int end = 1;
        int curr_petrol = pp[start].fuel - pp[start].distance;

        while(start != end || curr_petrol < 0){

            while(curr_petrol < 0  && start != end){
                curr_petrol -= pp[start].fuel - pp[start].distance;
                start = (start + 1) % size;
            }

            curr_petrol += pp[end].fuel - pp[end].distance;
            end = (end + 1) % size;
        }

        return start;
    }

    //Driver Program
    public static void main(String[] args) {
        PetrolPump[] pp = new PetrolPump[]{
                new PetrolPump(4,6),
                new PetrolPump(6,5),
                new PetrolPump(7,3),
                new PetrolPump(4,5)
        };

        PetrolPump[] arr = {new PetrolPump(6, 4),
                new PetrolPump(3, 6),
                new PetrolPump(7, 3)
        };

        VisitAllPetrolPumps vpp = new VisitAllPetrolPumps();
        System.out.println(vpp.pathPrint(pp, pp.length));
        System.out.println(vpp.pathPrint(arr, arr.length));

    }


}

