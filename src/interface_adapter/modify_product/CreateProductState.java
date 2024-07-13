package interface_adapter.modify_product;

public class CreateProductState {
    private String creationError = null;
    private String description = "";
    private String price = "";
    private String title = "";
    private String eTransferEmail = "";
    private String sellerStudentNumber = "";
    private String address = "";
    // TODO think about the ListTags

    public CreateProductState(CreateProductState copy) {
        creationError = copy.creationError;
        description = copy.description;
        price = copy.price;
        title = copy.title;
        eTransferEmail = copy.eTransferEmail;
        sellerStudentNumber = copy.sellerStudentNumber;
        address = copy.address;
    }

    public CreateProductState() {}

    public String getDescription() {return description;}
    public String getPrice() {return price;}
    public String getTitle() {return title;}
    public String geteTransferEmail() {return eTransferEmail;}
    public String getSellerStudentNumber() {return sellerStudentNumber;}
    public String getAddress() {return address;}

}
