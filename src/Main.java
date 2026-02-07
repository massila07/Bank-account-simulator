public class Main {
    public static void main(String[] args) {
        Account a = new Account(1, "Alice", 1000);
        Account b = new Account(2, "Bob", 500);

        a.transfer(b, 200);

        System.out.println(a);
        System.out.println(b);
    }
}
