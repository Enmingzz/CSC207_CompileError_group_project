package entity;

import java.util.ArrayList;

public class CommonShoppingCart implements ShoppingCart{
    private float totalPrice;
    private String studentNumber;
    private ArrayList<Product> listProducts;

    public CommonShoppingCart(float totalPrice, String studentNumber, ArrayList<Product> listProducts) {
        this.studentNumber = studentNumber;
        this.listProducts = listProducts;
        this.totalPrice = totalPrice;
    }

    @Override
    public float getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String getStudentNumber() {
        return studentNumber;
    }

    @Override
    public ArrayList<Product> getListProducts() {
        return listProducts;
    }
}
