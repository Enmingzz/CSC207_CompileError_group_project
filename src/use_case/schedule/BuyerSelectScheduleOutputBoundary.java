package use_case.schedule;

public interface BuyerSelectScheduleOutputBoundary {
    void prepareSuccessfulView(BuyerSelectScheduleOutputData outputData);
    void prepareFailedView(String error);
}
