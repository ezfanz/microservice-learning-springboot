package junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MyAssertTest {

    List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");

    @Test
    void test() {
        boolean test = todos.contains("AWS"); //Result
        boolean test2 = todos.contains("GCP"); //Result

//        assertEquals(true, test);
        assertTrue("Result is False", test);
        assertFalse("Result is False", test2);
        assertEquals(3, todos.size());
        assertArrayEquals(new int[] {1,2}, new int[] {2});


    }

}
