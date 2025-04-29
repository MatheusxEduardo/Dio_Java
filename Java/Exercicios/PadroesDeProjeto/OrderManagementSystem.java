// Interface para a estratégia de desconto (Strategy Pattern)
interface DiscountStrategy {
    double applyDiscount(double total);
}

// Estratégia de desconto para novos clientes
class NewCustomerDiscount implements DiscountStrategy {
    private static final NewCustomerDiscount INSTANCE = new NewCustomerDiscount();

    private NewCustomerDiscount() {}

    public static NewCustomerDiscount getInstance() {
        return INSTANCE;
    }

    @Override
    public double applyDiscount(double total) {
        return total * 0.9; // 10% de desconto
    }
}

// Estratégia de desconto para compras acima de 500
class HighValueDiscount implements DiscountStrategy {
    private static final HighValueDiscount INSTANCE = new HighValueDiscount();

    private HighValueDiscount() {}

    public static HighValueDiscount getInstance() {
        return INSTANCE;
    }

    @Override
    public double applyDiscount(double total) {
        return total > 500 ? total * 0.85 : total; // 15% de desconto se > 500
    }
}

// Classe abstrata para Pedidos
abstract class Order {
    protected final double total;
    protected final DiscountStrategy discountStrategy;

    public Order(double total, DiscountStrategy discountStrategy) {
        if (total < 0) {
            throw new IllegalArgumentException("Order total cannot be negative: " + total);
        }
        if (discountStrategy == null) {
            throw new IllegalArgumentException("Discount strategy cannot be null");
        }
        this.total = total;
        this.discountStrategy = discountStrategy;
    }

    public double calculateFinalTotal() {
        return discountStrategy.applyDiscount(total);
    }

    public abstract String getOrderType();
}

// Pedido Online
class OnlineOrder extends Order {
    public OnlineOrder(double total, DiscountStrategy discountStrategy) {
        super(total, discountStrategy);
    }

    @Override
    public String getOrderType() {
        return "Online Order";
    }
}

// Pedido em Loja Física
class PhysicalStoreOrder extends Order {
    public PhysicalStoreOrder(double total, DiscountStrategy discountStrategy) {
        super(total, discountStrategy);
    }

    @Override
    public String getOrderType() {
        return "Physical Store Order";
    }
}

// Factory Method para criar pedidos
abstract class OrderFactory {
    public abstract Order createOrder(double total, DiscountStrategy discountStrategy);
}

class OnlineOrderFactory extends OrderFactory {
    private static final OnlineOrderFactory INSTANCE = new OnlineOrderFactory();

    private OnlineOrderFactory() {}

    public static OnlineOrderFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public Order createOrder(double total, DiscountStrategy discountStrategy) {
        return new OnlineOrder(total, discountStrategy);
    }
}

class PhysicalStoreOrderFactory extends OrderFactory {
    private static final PhysicalStoreOrderFactory INSTANCE = new PhysicalStoreOrderFactory();

    private PhysicalStoreOrderFactory() {}

    public static PhysicalStoreOrderFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public Order createOrder(double total, DiscountStrategy discountStrategy) {
        return new PhysicalStoreOrder(total, discountStrategy);
    }
}

// Singleton para o Gerenciador de Pedidos
class OrderManager {
    private static final OrderManager INSTANCE = new OrderManager();

    private OrderManager() {}

    public static OrderManager getInstance() {
        return INSTANCE;
    }

    public void processOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        StringBuilder log = new StringBuilder()
                .append("Processing ").append(order.getOrderType()).append("\n")
                .append("Original Total: $").append(String.format("%.2f", order.total)).append("\n")
                .append("Final Total after discount: $").append(String.format("%.2f", order.calculateFinalTotal()));
        System.out.println(log);
    }
}

// Classe principal para demonstrar o uso
public class OrderManagementSystem {
    public static void main(String[] args) {
        try {
            // Obtendo a instância do Singleton
            OrderManager orderManager = OrderManager.getInstance();

            // Reutilizando fábricas e estratégias
            OrderFactory onlineFactory = OnlineOrderFactory.getInstance();
            OrderFactory physicalFactory = PhysicalStoreOrderFactory.getInstance();
            DiscountStrategy newCustomerDiscount = NewCustomerDiscount.getInstance();
            DiscountStrategy highValueDiscount = HighValueDiscount.getInstance();

            // Criando e processando pedidos
            Order onlineOrder = onlineFactory.createOrder(1000.0, newCustomerDiscount);
            orderManager.processOrder(onlineOrder);

            Order physicalOrder = physicalFactory.createOrder(600.0, highValueDiscount);
            orderManager.processOrder(physicalOrder);

            // Teste com valor inválido (descomente para testar)
            // Order invalidOrder = onlineFactory.createOrder(-100.0, newCustomerDiscount);
            // orderManager.processOrder(invalidOrder);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}