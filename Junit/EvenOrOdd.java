package junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EvenOrOdd
{
	public boolean isEven(int x)
	{
		return x%2==0;
	}

 
 
	@Test
	@DisplayName("asserTrue for Even or odd")
	void checkEvenOrOdd()
	{
		EvenOrOdd e=new EvenOrOdd();
		
		assertTrue(e.isEven(4));
		
	
	}



	private void assertTrue(boolean even) {
		
	}
	}
