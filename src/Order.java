import enums.OrderStatus;
import org.jetbrains.annotations.NotNull;


public class Order implements Comparable<Order> {

    private static int orderCounter = 0;
    private int orderId;
    private Customer customer;
    private OrderStatus orderStatus;

    public Order(Customer customer) {
        this.orderId = ++orderCounter;
        this.customer = customer;
        this.orderStatus = OrderStatus.PLACED;
    }

    public static int getOrderCounter() {
        return orderCounter;
    }

    public static void setOrderCounter(int orderCounter) {
        Order.orderCounter = orderCounter;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public int compareTo(@NotNull Order o) {
        return Integer.compare(this.orderId, o.orderId);
    }

    @Override
    public String toString() {
        return "Order with " +
                "id:" + orderId +
                ", for customer:'" + customer +
                ", Status:" + orderStatus;
    }
}
