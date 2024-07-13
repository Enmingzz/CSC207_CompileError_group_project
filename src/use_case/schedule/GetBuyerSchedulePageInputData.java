package use_case.schedule;

import entity.product.Product;
import entity.user.User;

public class GetBuyerSchedulePageInputData {
    private User buyer;
    private final Product product;


    public GetBuyerSchedulePageInputData(User buyer, Product product){
        this.product = product;
        this.buyer = buyer;
    }

    public Product getProduct(){
        return product;
    }
    public User getBuyer(){
        return buyer;
    }
}

