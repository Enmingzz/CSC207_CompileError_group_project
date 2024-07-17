package use_case.schedule;

/**
 * The GetSellerSchedulePageOutputBoundary interface provides a method for preparing the
 * output view based on the result of gathering the necessary data to display the schedule page for a seller.
 */
public interface GetSellerSchedulePageOutputBoundary {

    /**
     * Prepares the successful view with the given output data.
     *
     * @param getSellerSchedulePageOutputData the output data containing the seller and product information
     */
    void prepareSuccessfulView(GetSellerSchedulePageOutputData getSellerSchedulePageOutputData);
}
