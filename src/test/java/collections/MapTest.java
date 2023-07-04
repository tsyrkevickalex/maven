package collections;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class MapTest {

    @Test
    public void initialTest(){
        Map<String, List<String>> map = new HashMap<>();
        String key = "J2022"; // 69877832
        int h ;
        h = (h = key.hashCode()) ^ (h >>> 16);
        System.out.println("after XOR : " + h);


        System.out.println(key.hashCode());
        map.put(key, Arrays.asList("John" , "Bob"));
        map.put("J2023", Arrays.asList("Mike K." , "Bob"));
        map.put("J2019", Arrays.asList("Jack" , "Alex"));
        assertEquals(map.size(), 3);

        map.put("J2022", Arrays.asList("Mike" , "Misha"));
        List<String> value = map.get("J2022");
        assertTrue(value.get(0).equals("Mike"));

        Map<String, List<String>> map2 = new HashMap<>();
        map2.put("A2023", Arrays.asList("Mike K." , "Bob"));
        map2.put("B2023", Arrays.asList("Mike K." , "Bob"));
        map2.put("J2019", Arrays.asList("Mike K." , "Bob"));

        map.putAll(map2);
        assertEquals(map.size(), 5);
    }

    @Test
    public void collisionTest(){
        Map<Person, Double> map = new HashMap<>();
        map.put(new Person(123, "John"), 6.8);
        map.put(new Person(321, "Bob"), 7.8);
    }

    @Test
    public void getValueTest(){
        Map<Person, Double> map = new HashMap<>();
        map.put(new Person(123, "John"), 6.8);
        map.put(new Person(321, "Bob"), 7.8);


        double avg = map.get(new Person(123, "John"));
        assertTrue(avg == 6.8);
    }

    @Test
    public void replaceTest(){
        Map<Cat, String> catsMap = new HashMap<>();
        catsMap.put(new Cat(123, "Murzik"), "Alex");
        catsMap.put(new Cat(321, "Tom"), "John");

        assertEquals(catsMap.size() , 2);
    }

    @Test
    public void getValuesTest(){
        Map<String, List<Person>> map = new HashMap<>();
        map.put("J2022", Arrays.asList(new Person(123, "John"), new Person(321, "Bob")));
        map.put("J3022", Arrays.asList(new Person(77, "Mike"), new Person(55, "Andy")));
        map.put("J2023", Arrays.asList(new Person(788, "Jack"), new Person(566, "Alex")));

        for(Map.Entry<String, List<Person>> entry: map.entrySet()){
            String key = entry.getKey();
            List<Person> value = entry.getValue();

            System.out.println("KEY: " + key);
            for (Person person: value){
                System.out.println(person.getName());
            }
        }

        System.out.println("*****************************");
        for(String key : map.keySet()){
            System.out.println("KEY: " + key);
            for(Person p : map.get(key)){
                System.out.println(p.getId());
            }
        }
        System.out.println("*****************************");
        map.forEach( (k, v) -> {
            System.out.println(k);
            v.forEach( p -> {
                System.out.println(p.getId() + " : " + p.getName());
            });
        });

    }

    @Test
    public void sortTest(){
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(2, "Two");
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(-5, "One");

        map.put(-3, "One");

        assertTrue(map.keySet().toString().equals("[-5, 0, 1, 2]"));
    }




}

class Person {

    private int id;
    private String name;

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

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println(this.id + " -> equals " + ((Person)o).id);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        int code = Objects.hash(id, name);
        System.out.println(this.id + " -> hashCode = " + code);
        return code;
    }
}


class Cat {
    int id;
    String name;

    public Cat(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}

class T {
    public static void main(String[] args) {
        Map<Person, Double> map = new HashMap<>();
        map.put(new Person(123, "John"), 6.8);
        map.put(new Person(321, "Bob"), 7.8);
        map.put(new Person(4556, "Lisa"), 9.8);
        map.put(new Person(125454, "Alex"), 1.8);
        map.put(new Person(12312, "John"), 6.8);
        map.put(new Person(3211, "Bob"), 7.8);
        map.put(new Person(455612, "Lisa"), 9.8);
        map.put(new Person(1254514, "Alex"), 1.8);
        map.put(new Person(123122, "John"), 6.8);
        map.put(new Person(32121, "Bob"), 7.8);
        map.put(new Person(455634, "Lisa"), 9.8);
        map.put(new Person(1254543, "Alex"), 1.8);
        map.put(new Person(12353, "John"), 6.8);
        map.put(new Person(32163, "Bob"), 7.8);
        map.put(new Person(4556823, "Lisa"), 9.8);
        map.put(new Person(12545134, "Alex"), 1.8);

    }
}
