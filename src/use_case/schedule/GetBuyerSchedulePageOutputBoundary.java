package use_case.schedule;

/**
 * The GetBuyerSchedulePageOutputBoundary interface provides a method for preparing the
 * output view based on the result of retrieving the schedule page for a buyer.
 */
public interface GetBuyerSchedulePageOutputBoundary {

    /**
     * Prepares the successful view with the given output data.
     *
     * @param getBuyerSchedulePageOutputData the output data containing the buyer and product information
     */
    void prepareSuccessfulView(GetBuyerSchedulePageOutputData getBuyerSchedulePageOutputData);
}
