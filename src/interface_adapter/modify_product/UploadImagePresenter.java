package interface_adapter.modify_product;

import use_case.modify_product.UploadImageOutputBoundary;
import use_case.modify_product.UploadImageOutputData;

public class UploadImagePresenter implements UploadImageOutputBoundary {

    private final ViewCreateProductViewModel viewCreateProductViewModel;

    public UploadImagePresenter(ViewCreateProductViewModel viewCreateProductViewModel) {
        this.viewCreateProductViewModel = viewCreateProductViewModel;
    }

    @Override
    public void prepareSuccessfulView(UploadImageOutputData uploadImageOutputData) {
        CreateProductState state = viewCreateProductViewModel.getState();
        String path = uploadImageOutputData.getPath();
        state.setPath(path);
        viewCreateProductViewModel.setState(state);
        viewCreateProductViewModel.firePropertyChanged();
    }
}
