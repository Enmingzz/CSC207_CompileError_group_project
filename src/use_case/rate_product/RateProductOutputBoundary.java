package use_case.rate_product;

import use_case.modify_product.ChangeProductOutputData;

public interface RateProductOutputBoundary {
    public void prepareSuccessfulView(RateProductOutputData rateProductOutputData);
    public void prepareFailedView(String error);
}
