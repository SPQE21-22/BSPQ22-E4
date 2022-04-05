public class OrderDAO {

    public static List<Order> getOrders() {
        List<Order> orderList = new ArrayList<Order>();

        orderList.add(new Order(new Customer(), new ArrayList<Order>(new Order())));
    }
    
}
