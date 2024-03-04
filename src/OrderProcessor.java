import enums.OrderStatus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrderProcessor {

    private final ExecutorService executorService;

    public OrderProcessor(int poolSize) {
        executorService = Executors.newFixedThreadPool(poolSize);
    }

    public void processOrder(Order order) {
        executorService.submit(() -> {
            try {

                System.out.println("Preparing order " + order.getOrderId());
                order.setOrderStatus(OrderStatus.PREPARING);
                TimeUnit.SECONDS.sleep(2);


                System.out.println("Order " + order.getOrderId() + " is ready.");
                order.setOrderStatus(OrderStatus.READY);
                TimeUnit.SECONDS.sleep(2);

                System.out.println("Delivering order " + order.getOrderId());
                order.setOrderStatus(OrderStatus.DELIVERED);
                System.out.println("Order " + order.getOrderId() + " has been delivered.");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Failed to process order " + order.getOrderId());
            }
        });
    }

    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(2400, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
