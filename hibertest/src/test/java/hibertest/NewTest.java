package hibertest;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class NewTest {
	
	@Test
	public void testAdd() {
		
		int result = MyStupidClass.add(3,5);
        assertEquals(8, result);
      
    }	
}
