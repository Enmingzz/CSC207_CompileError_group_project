package interface_adapter.main_page;

import java.util.ArrayList;
import entity.product.Product;
import entity.user.User;

public class MainPageState {

    private String studentNumber = "";
    private ArrayList<Product> allProducts = new ArrayList<>()
;
    public MainPageState() {}

    public String getStudentNumber() {
        return studentNumber;
    }

    public ArrayList<Product> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(ArrayList<Product> allProducts) {
        this.allProducts = allProducts;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
}
