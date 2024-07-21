package interface_adapter.modify_product;

import use_case.modify_product.UploadImageOutputBoundary;
import use_case.modify_product.UploadImageOutputData;

public class UploadImagePresenter implements UploadImageOutputBoundary {

    private ViewCreateProductViewModel viewCreateProductViewModel = null;
    private ViewModifyProductViewModel viewModifyProductViewModel = null;

    public UploadImagePresenter(ViewCreateProductViewModel viewCreateProductViewModel) {
        this.viewCreateProductViewModel = viewCreateProductViewModel;
    }

    public UploadImagePresenter(ViewModifyProductViewModel viewModifyProductViewModel) {
        this.viewModifyProductViewModel = viewModifyProductViewModel;
    }

    @Override
    public void prepareSuccessfulView(UploadImageOutputData uploadImageOutputData) {
        if (viewCreateProductViewModel != null){
            CreateProductState state = viewCreateProductViewModel.getState();
            String path = uploadImageOutputData.getPath();
            state.setPath(path);
            viewCreateProductViewModel.setState(state);
            viewCreateProductViewModel.firePropertyChanged();

        } else {
            ViewModifyProductState state = viewModifyProductViewModel.getState();
            String path = uploadImageOutputData.getPath();
            state.setPath(path);
            viewModifyProductViewModel.setState(state);
            viewModifyProductViewModel.firePropertyChanged();
        }
    }
}
