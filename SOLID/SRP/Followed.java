import java.util.*;
class Product{
    String name;
    double price;
    public Product(String name,double price){
     this.name=name;
     this.price=price;
    }
}
class ShoppingCart{ /*here each class is associated with one responsibility only further scaling can 
    also be done by just using instance of ShoppingCart i.e. this code following SRP
    */
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
          System.out.println("Total:"+ total);
    }
}
class ShoppingCartPrinter{
    private ShoppingCart cart;
    ShoppingCartPrinter(ShoppingCart cart){
    this.cart=cart;
    }

  public void invoice(){
        for(Product p:cart.getProduct()){
            System.out.println(p.name+" :"+p.price);
        }
    }
}
class ShoppingCartStorage{
    ShoppingCart cart;
    ShoppingCartStorage(ShoppingCart cart){
        this.cart=cart;
    }
    public void saveToDB(){
        System.out.println("Saved to Database");
    }
}

public class Followed {
    public static void main(String[] args){
    ShoppingCart cart=new ShoppingCart();
    cart.addProduct(new Product("Laptop",55000));
    cart.addProduct(new Product("Printer",60000));
    ShoppingCartPrinter printer=new ShoppingCartPrinter(cart);
    printer.invoice();
    cart.calTotal();
    ShoppingCartStorage st=new ShoppingCartStorage(cart);
    st.saveToDB();
    }

}
