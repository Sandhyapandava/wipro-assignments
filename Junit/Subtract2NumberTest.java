package junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
 
class Subtract2Number {
    int subtract2Num(int a, int b) {
        return a - b;
    }
}
 
public class Subtract2NumberTest {
 
    @Test
    @DisplayName("Subtracting 2 numbers")
    void test2NumbersSubtracting() {
        Subtract2Number subtract = new Subtract2Number();
        int actualSubtraction = subtract.subtract2Num(2, 3);
        int expectedValue = -1;
        assertEquals(expectedValue, actualSubtraction);
    }

@Test
void testObjectCreation()
{
	String str=new String("hello");
	assertNotNull(str);
	String str2="rk";
	assertNotNull(str2);
	System.out.println("supaaaaaar");
	
}
}
