package entity.shopping_cart;

import entity.product.Product;

import java.util.ArrayList;

public class CommonShoppingCart implements ShoppingCart{
    private float totalPrice;
    private String studentNumber;
    private ArrayList<Product> listProducts;

    /**
     * Constructs a {@code CommonShoppingCart} object with the specified total price, student number, and list of products.
     *
     * @param totalPrice   the total price of the products in the shopping cart
     * @param studentNumber the student number associated with the shopping cart
     * @param listProducts the list of products in the shopping cart
     */

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
