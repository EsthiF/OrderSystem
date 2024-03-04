import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Customer {
    private String name;
    private String email;
    private String address;
    private static List<Order> orders = new ArrayList<>();
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public Customer(String name, String email, String address) {
        if (!validateEmail(email)) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.name = name;
        this.email = email;
        this.address = address;
        validateCustomer();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!validateEmail(email)) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void deleteOrder(int orderId) {
        orders.remove(orderId);
    }

    public void validateCustomer() {
        if (name == null || name.trim().isEmpty() || address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Name and address are required");
        }
    }

    private boolean validateEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }


    public static List<Order> getOrders() {
        return orders;
    }

    public static void setOrders(List<Order> orders) {
        Customer.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer " +
                "name:" + name +
                ", email:'" + email +
                ", lives in:" + address;
    }

}

