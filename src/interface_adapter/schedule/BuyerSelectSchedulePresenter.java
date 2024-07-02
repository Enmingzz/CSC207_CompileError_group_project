package interface_adapter.schedule;

import use_case.schedule.BuyerSelectScheduleOutputBoundary;
import use_case.schedule.BuyerSelectScheduleOutputData;

public class BuyerSelectSchedulePresenter implements BuyerSelectScheduleOutputBoundary {
    private BuyerSelectScheduleViewModel viewModel;

    public BuyerSelectSchedulePresenter(BuyerSelectScheduleViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void presentScheduleSelection(BuyerSelectScheduleOutputData outputData) {
        viewModel.setSelectedTime(outputData.getSelectedTime());
        viewModel.setSuccess(outputData.isSuccess());
    }
}
