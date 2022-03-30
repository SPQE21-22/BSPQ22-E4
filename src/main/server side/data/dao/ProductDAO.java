public class ProductDAO {
    
    public static List<Product> getProducts() {

        List<Product> productList = new ArrayList<Product>();
        
        productList.add(new Product("Breakfast", "Cereales Lion", "Nestle", 200, new LocalDate(2022, 10, 23),
                0, 2.40));
        productList.add(new Product("Breakfast", "Cereales rellenos del mercadona", "Hacendado", 350, new LocalDate(2022, 9, 13),
                0, 2.10));
        productList.add(new Product("Breakfast", "Frosties", "Nestle", 250, new LocalDate(2022, 10, 23),
                0, 2.40));
        productList.add(new Product("Breakfast", "Chocokrispies", "Nestle", 200, new LocalDate(2022, 8, 28),
                0, 2.40));
        productList.add(new Product("Breakfast", "Chocapic", "Nestle", 200, new LocalDate(2022, 10, 23),
                0, 2.40));
    
    }
}
