package collections;

import static org.junit.Assert.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.*;

public class ListTest {

    @Test
    public void initialTest(){
        List list = new ArrayList();
        list.add("Val1");
        list.add(123);
        list.add(new ArrayList());
        list.add(new Object());

        assertTrue(list.size() == 4);
    }

    @Test
    public void genericTest(){
        List<String> list = new ArrayList<String>();
        list.add("Val1");
        list.add("Val2");
        list.add("Val3");
        assertTrue(list.size() == 3);
    }

    @Test
    public void test1(){
        List<String> list = new ArrayList<String>();
        list.add("Val1");
        list.add("Val2");
        list.add("Val3");

        List<String> newList = new ArrayList<>(list);
        newList.add("Val1");
        newList.add(null);
        newList.add(2, "INSERTED_VALUE");

        assertEquals(newList.size(),  6);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test2(){
        List<String> list =  new ArrayList<>(128);
        assertEquals(0, list.size());
        assertTrue( list.isEmpty());

        List<String> listFixedSize = Arrays.asList("One", "Two", "Three");
        assertEquals(3, listFixedSize.size());
        assertFalse( listFixedSize.isEmpty());


        listFixedSize.add("FIVE");
        assertEquals(4, listFixedSize.size());


    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test3(){
        List<String> list =  new ArrayList<>(128);
        list.add("zero");

        list.addAll(Arrays.asList("One", "Two", "Three"));
        list.add("five");

        assertEquals(5, list.size());

        assertTrue(list.contains(new String("One")));

        assertFalse(list.containsAll(Arrays.asList("One", "Two", "-1")));
        list.get(list.size());

    }


    @Test
    public void test4(){
        List<Integer> numbers =  new ArrayList<>(128);
        numbers.addAll(Arrays.asList(1,2 , 3, 4, 5));

        numbers.remove(Integer.valueOf(5));
        assertEquals(4, numbers.size());

        assertEquals(Integer.valueOf(3), numbers.remove(2));

        numbers.set(2, new Integer(66));
        Object [] arr = numbers.toArray();
        Object o = arr[2];
        Integer[] arr2 = new Integer[16];
        arr2[0] = 3;
        arr2[1] = 2;
        arr2[2] = 3;


        Integer[] result = numbers.toArray(arr2);
        assertTrue(result.length != 0);

        numbers.add(-2);
        numbers.add(-500);

        numbers.sort(new NumsComparator());
        assertTrue(numbers.get(0) < 0);
    }



    @Test
    public void sortTest(){
        List strs = new ArrayList(Arrays.asList("B", "C", "a"));
        strs.sort(String.CASE_INSENSITIVE_ORDER);

        assertTrue(strs.get(0).equals("a"));


      //   strs.sort(Comparator.naturalOrder());

        List<Integer> nums = new ArrayList<>(Arrays.asList(3, 1, 2));
        nums.sort(Comparator.naturalOrder());
        assertTrue(nums.get(0).equals(1));

        nums.sort(new NumsComparator2());
        assertTrue(nums.get(0).equals(3));
    }


    @Test
    public void sortCustomTest(){
        List<Car> cars = new ArrayList<>(Arrays.asList(
                new Car(123, "Opel Astra",3.0, Arrays.asList("Nick", "Bob", "An", "Bob")),
                new Car(332, "Audi S5",3.0, Arrays.asList("Alex" , "John")),
                new Car(445, "BMW M5",3.0, Arrays.asList("Bob"))

        ));
        cars.sort(Comparator.naturalOrder());
        assertTrue(cars.get(0).getModel().startsWith("Audi"));

        cars.sort(new ComparatorByOwnersNumber());
        assertEquals(2, cars.get(0).getOwners().size());
        assertEquals(3, cars.get(1).getOwners().size());
    }

    @Test
    public void sortCustomTestByOwnerName(){
        List<Car> cars = new ArrayList<>(Arrays.asList(
                new Car(1, "Opel Astra",3.0, Arrays.asList("Nick", "Bob", "An", "Bob")),
                new Car(2, "Audi S5",3.0, Arrays.asList("Alex")),
                new Car(3, "Audi S5",3.0, Arrays.asList("Alex" , "Alex", "Bob")),
                new Car(4, "BMW M5",3.0, Arrays.asList("Bob"))

        ));


        cars.sort(new ComparatorByOwnersName());
        assertEquals(2, cars.get(0).getId());

    }
}

class NumsComparator2 implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return (-1) * o1.compareTo(o2);
    }
}



class NumsComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}

@AllArgsConstructor
@Data
class Car implements Comparable<Car>{
    private long id;
    private String model;
    private double vEngine;
    private List<String> owners;


    @Override
    public int compareTo(Car o) {
        return this.model.compareTo(o.model);
    }
}

class ComparatorByOwnersNumber implements Comparator<Car>{

    @Override
    public int compare(Car o1, Car o2) {
        return Integer.valueOf(o1.getOwners().size()).compareTo(o2.getOwners().size());
    }
}

class ComparatorByOwnersName implements Comparator<Car>{

    @Override
    public int compare(Car o1, Car o2) {
       // o1.getOwners().sort(Comparator.naturalOrder());
       // o2.getOwners().sort(Comparator.naturalOrder());
        int size = Math.min(o1.getOwners().size(), o2.getOwners().size());

        for(int index = 0; index < size; index++){
            int result = o1.getOwners().get(index).compareTo(o2.getOwners().get(index));
            if(result != 0){
                return result;
            }
        }
        return o1.getOwners().size() - o2.getOwners().size();
    }
}

