public class Swap {
    public static void main(String[] args) {
        // Swap the values of the variables
        int a = 123;
        int b = 526;

        int originalA = a;
        a = b;
        b = originalA;

        System.out.println(a);
        System.out.println(b);
    }
}
