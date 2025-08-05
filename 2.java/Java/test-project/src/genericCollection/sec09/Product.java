package genericCollection.sec09;

public class Product {
    int pNo;
    String pName;
    double price;

    public Product(int pNo, String pName, double price) {
        this.pNo = pNo;
        this.pName = pName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{ " +
                "pNo=" + pNo +
                ", pName='" + pName +
                ", price=" + price +
                " }";
    }
}
