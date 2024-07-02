package interface_adapter.schedule;


import use_case.schedule.SellerSelectScheduleOutputBoundary;
import use_case.schedule.SellerSelectScheduleOutputData;

public class SellerSelectSchedulePresenter implements SellerSelectScheduleOutputBoundary {
    private SellerSelectScheduleViewModel viewModel;

    public SellerSelectSchedulePresenter(SellerSelectScheduleViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void presentScheduleSelection(SellerSelectScheduleOutputData outputData) {
        viewModel.setAvailableTimes(outputData.getAvailableTimes());
        viewModel.setSuccess(outputData.isSuccess());
    }
}
