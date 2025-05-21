import java.util.*;
class Product{
    String name;
    double price;
    Product(String name,double price){
        this.price=price;
        this.name=name;
    }

}
 class ShoppingCart{                                   /*This ShoppingCart class is handling multiple responsibilities
                                                            i.e. violating Single Responsibility Principle 
                                                                incase of further scaling it causes problems*/
    private List<Product>products= new ArrayList<>();
   public void addProduct(Product p){
    products.add(p);
   }
   public List<Product> getProduct(){
    return products;
   }
    public void calTotal(){
        double total=0;
        for(Product p:products){
            total+=p.price;
        }
        System.out.println("Total:"+total);

    }
    public void Invoice(){
        for(Product p:products){
            System.out.println(p.name+" : "+p.price);
        }
        

    }
    void saveToDb(){
        System.out.println("Saved to DB");
    }
}
public class Voilated{
    public static void main(String[] args){
        ShoppingCart cart=new ShoppingCart();
        cart.addProduct(new Product("Laptop",50000));
        cart.addProduct(new Product("Mouse",500));
        cart.Invoice();
        cart.calTotal();
        cart.saveToDb();
    }
}
