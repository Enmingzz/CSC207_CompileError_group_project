package interface_adapter.modify_product;

import use_case.modify_product.ViewModifyProductInputBoundary;
import use_case.modify_product.ViewModifyProductInputData;

public class ViewModifyProductController {

    private final ViewModifyProductInputBoundary modifyProductInteractor;


    public ViewModifyProductController(ViewModifyProductInputBoundary modifyProductInteractor) {
        this.modifyProductInteractor = modifyProductInteractor;
    }

    public void execute(ViewModifyProductInputData modifyProductInputData){
        //TODO need to implement this
    }
}
