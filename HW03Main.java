/*
 * File header comment block goes below here:
 * ==========================================
 * CS211, Spring 2020, 4/24
 * Vinh T. Nguyen
 * Homework 03 - 5,11,15 on pg 759
 * sortAndRemoveDuplicates takes in an integer list as the parameter, then return the new list sorted and any duplicates removed 
 * symmetricSetDifference finds the difference between the two sets and add them all together
 * maxOccurrences returns the most repeated ("the mode") number from the list with its occurences
 */


import java.util.*;

public class HW03Main{
   public static void main(String[] args){
      //initializing the list and sets
      List<Integer> original = Arrays.asList(7,4,-9,4,15,8,27,7,11,-5,32,-9,-9);
      Set<Integer> first = new HashSet<>();
      Set<Integer> second = new HashSet<>();
      first.add(1); first.add(4); first.add(7); first.add(9);
      second.add(2);second.add(4);second.add(5);second.add(6);second.add(7);
      
      //Number 5 
      System.out.println(original);  //original list
      sortAndRemoveDuplicates(original);  //sorted and removed duplicates
      System.out.println("");
      
      //Number 11
      System.out.println("First Set: "+ first);
      System.out.println("Second Set: "+ second);
      symmetricSetDifference(first,second);   //finding the difference and add them all together
      System.out.println("");
      
      //Number 15
      maxOccurrences(original);  //return the modes and its occurences
       System.out.println("");

   }
   
   public static void sortAndRemoveDuplicates(List<Integer> original){
      Set<Integer> improved = new TreeSet<Integer>();
      if (original.size() == 0){
         System.out.println(0);
      } else {
            for(int i=0; i<original.size(); i++){ //for loop 
            int num = original.get(i);
            improved.add(num);
            } 
      }
         System.out.println(improved);
   }
   
   public static void symmetricSetDifference(Set<Integer> first, Set<Integer> second){
      Set<Integer> fake1 = new HashSet<>();
      Set<Integer> fake2 = new HashSet<>();
      Set<Integer> improved = new TreeSet<>();
   
      fake1.addAll(first);  //transfering the date to a new set
      fake2.addAll(second);
      
      fake1.removeAll(second); //finding the difference
      fake2.removeAll(first);
      
      improved.addAll(fake1); //adding them all up to the "official" output
      improved.addAll(fake2);
      
      System.out.println(improved); //output
   }
   
   public static void maxOccurrences(List<Integer> original){
      Map<Integer,Integer> improved = new TreeMap<>();  
      Map<Integer,Integer> legit = new TreeMap<>();
      Iterator<Integer> itr = original.iterator();

      if (original.size() == 0){
         System.out.println(0);
      } else {
           while(itr.hasNext()){
           int num = itr.next();
               if (improved.containsKey(num)) {
                  // seen this word before; increase count by 1
                  int count = improved.get(num);
                  improved.put(num, count + 1);
               } else {
                  // never seen this word before
                  improved.put(num, 1);
               }
            }
          int max = Collections.max(improved.values());
          
            ArrayList<Integer> list = new ArrayList<>(improved.keySet());  //swap the values and keys
            Iterator<Integer> itr2 = list.iterator();

            while (itr2.hasNext()){   
            int num = itr2.next();
            int count = improved.get(num);
            legit.put(count, num);
         }   

            System.out.println("Mode: "+legit.get(max)+" , Occurences: "+ max); //print the output
         }
   }
}