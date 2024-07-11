package use_case.schedule;

public interface SellerSelectScheduleOutputBoundary {
    void prepareSuccessfulView(SellerSelectScheduleOutputData outputData);
    void prepareFailedView(String error);
}
