package use_case.schedule;

import entity.product.Product;
import entity.user.User;

public class GetSellerSchedulePageInputData {
    private User seller;
    private final Product product;


    public GetSellerSchedulePageInputData(User seller, Product product){
        this.product = product;
        this.seller = seller;
    }

    public Product getProduct(){
        return product;
    }
    public User getSeller(){
        return seller;
    }
}
