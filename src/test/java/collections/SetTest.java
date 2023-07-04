package collections;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

public class SetTest {

    @Test
    public void initialTest(){

        HashSet<String> set = new HashSet<>();
        set.add("One");
        set.add("One");
        set.add("ONE");
        set.add("AAA");

        assertEquals(3, set.size());

        for(String str : set){
            System.out.println(str);
        }

        set.add("aaa");


        assertEquals("[aaa, AAA, One, ONE]", set.toString());

        set.forEach( s -> {
            System.out.println(s.toUpperCase());
        });
    }


    @Test
    public void initialTest2(){
        Set<Map<String, List<Double>>> set = new HashSet<>();
        set.forEach( element -> {
            element.forEach((k, v) -> {
                v.forEach(d -> {

                });
            });
        });


    }
}
