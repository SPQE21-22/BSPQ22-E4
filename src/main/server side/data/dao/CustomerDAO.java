public class CustomerDAO {
    
    public static List<Customer> getCustomers() {
        
        List<Customer> customerList = new ArrayList<Customer>();
        
        customerList.add(new Customer( "customer1@gmail.com",  "customer1",  "bhjkhkjg",  "Avenida Reina Sofia 31",  "732523947529345",
                "456745764"));
        customerList.add(new Customer( "customer2@gmail.com",  "customer2",  "rwesterwtd",  "Avenida de los Huetos 25",  "56745675468458",
                "897235925"));
        customerList.add(new Customer( "customer3@gmail.com",  "customer3",  "mkkoopnpik",  "Avenida del Customer 28",  "2352345462364",
                "323456723"));

    }
}
