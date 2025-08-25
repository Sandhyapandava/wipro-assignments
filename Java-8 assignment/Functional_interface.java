package java8;


		interface Greeting
		{
			void greet();
			
		}
		 
		public class Functional_interface {
		 
			public static void main(String[] args) {
		     
				
				Greeting g= ()->System.out.println("good Mrng");
				g.greet();
			}
		 
		}
		 
	
