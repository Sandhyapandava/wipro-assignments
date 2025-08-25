package java8;

interface Add2Number {

	int add(int i, int j);
}
 
public class pro_add {
    public static void main(String[] args) {
        Add2Number add = (a, b) -> a + b;
 
        int res = add.add(3, 5);
        System.out.println(res);
    }
}
 