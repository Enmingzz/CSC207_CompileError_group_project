package interface_adapter.rating;

import entity.product.Product;
import entity.user.User;
import use_case.rate_product.GetRatePageInputBoundary;
import use_case.rate_product.GetRatePageInputData;

public class GetRatePageController {
    private final GetRatePageInputBoundary getRatePageInteractor;

    public GetRatePageController(GetRatePageInputBoundary getRatePageInteractor) {
        this.getRatePageInteractor = getRatePageInteractor;
    }

    public void execute(User user, Product product) {
        GetRatePageInputData getRatePageInputData = new GetRatePageInputData(user, product);
        getRatePageInteractor.execute(getRatePageInputData);
    }

}
