// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        OrderProcessor orderProcessor = new OrderProcessor(3);

        Customer customer1 = new Customer("John", "John@gmail.com", "123 Main St");
        Customer customer2 = new Customer("Esthi", "Esthi@gmail.com", "14 Weste St");
        Customer customer3 = new Customer("Racheli", "Racheli@gmail.com", "123 Road St");
        Customer customer4 = new Customer("Jonas", "Jonas@gmail.com", "123 Free St");
        Customer customer5 = new Customer("Freidi", "Freidi@gmail.com", "546 Main St");

        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3);
        System.out.println(customer4);
        System.out.println(customer5);

        customer1.addOrder(new Order(customer1));
        customer2.addOrder(new Order(customer2));

        orderProcessor.processOrder(customer1.getOrders().get(0));
        orderProcessor.processOrder(customer2.getOrders().get(0));

        orderProcessor.shutdown();

    }
}
