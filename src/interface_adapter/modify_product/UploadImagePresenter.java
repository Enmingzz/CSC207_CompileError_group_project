package interface_adapter.modify_product;

import use_case.modify_product.UploadImageOutputBoundary;
import use_case.modify_product.UploadImageOutputData;

/**
 * Presenter for handling the results of an image upload operation.
 *
 * This class updates the view model with the image upload results, including setting the image path
 * for either the create product or modify product views.
 */
public class UploadImagePresenter implements UploadImageOutputBoundary {

    private ViewCreateProductViewModel viewCreateProductViewModel = null;
    private ViewModifyProductViewModel viewModifyProductViewModel = null;

    /**
     * Constructs an UploadImagePresenter for the create product view.
     *
     * @param viewCreateProductViewModel The view model for the create product view.
     */
    public UploadImagePresenter(ViewCreateProductViewModel viewCreateProductViewModel) {
        this.viewCreateProductViewModel = viewCreateProductViewModel;
    }

    /**
     * Constructs an UploadImagePresenter for the modify product view.
     *
     * @param viewModifyProductViewModel The view model for the modify product view.
     */
    public UploadImagePresenter(ViewModifyProductViewModel viewModifyProductViewModel) {
        this.viewModifyProductViewModel = viewModifyProductViewModel;
    }

    /**
     * Prepares the view with the results of a successful image upload.
     *
     * Updates the relevant view model's state with the image path obtained from the {@link UploadImageOutputData}.
     *
     * @param uploadImageOutputData Contains the path of the uploaded image.
     */
    @Override
    public void prepareSuccessfulView(UploadImageOutputData uploadImageOutputData) {
        String path = uploadImageOutputData.getPath();
        if (viewCreateProductViewModel != null) {
            CreateProductState state = viewCreateProductViewModel.getState();
            state.setPath(path);
            viewCreateProductViewModel.setState(state);
            viewCreateProductViewModel.firePropertyChanged();
        } else {
            ViewModifyProductState state = viewModifyProductViewModel.getState();
            state.setPath(path);
            viewModifyProductViewModel.setState(state);
            viewModifyProductViewModel.firePropertyChanged();
        }
    }
}
