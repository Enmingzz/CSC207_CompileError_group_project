package use_case.search_product;

import entity.user.User;

public class SearchProductByNameInputData {

    final private User user;

    final private String productName;

    public SearchProductByNameInputData(User user, String productName) {
        this.user = user;
        this.productName = productName;
    }

    public User getUser() {
        return user;
    }

    public String getProductName() {
        return productName;
    }

}
