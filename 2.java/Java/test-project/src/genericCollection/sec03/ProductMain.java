package genericCollection.sec03;

public class ProductMain {
    public static void main(String[] ignoredArgs) {
        Product<TV, String> product1 = new Product<>();
        Product<Car, String> product2 = new Product<>();

        product1.setKind(new TV("Samsung TV"));
        product2.setKind(new Car("Hyundai Car"));
    }
}
