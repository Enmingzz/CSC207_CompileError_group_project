package interface_adapter.modify_product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CreateProductStateTest {
    private Image image;
    private String description;
    private String price;
    private String title;
    private String eTransferEmail;
    private String address;
    private ArrayList<String> listTags;
    private String createProductError;
    private String path;

    private CreateProductState createProductState;

    @BeforeEach
    void setUp() {
        CreateProductState copy = new CreateProductState();
        createProductState = new CreateProductState(copy);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getImage() throws IOException {
        image = ImageIO.read(new File("src/pic/testpic1.png"));
        createProductState.setImage(image);
        assertEquals(image, createProductState.getImage());
    }

    @Test
    void getDescription() {
        description = "It was worn once";
        createProductState.setDescription(description);
        assertEquals(description, createProductState.getDescription());
    }

    @Test
    void getPrice() {
        price = "9";
        createProductState.setPrice(price);
        assertEquals(price, createProductState.getPrice());
    }

    @Test
    void getTitle() {
        title = "Red Dress";
        createProductState.setTitle(title);
        assertEquals(title, createProductState.getTitle());
    }

    @Test
    void geteTransferEmail() {
        eTransferEmail = "calico.cat@mail.utoronto.ca";
        createProductState.seteTransferEmail(eTransferEmail);
        assertEquals(eTransferEmail, createProductState.geteTransferEmail());
    }

    @Test
    void getAddress() {
        address = "123College";
        createProductState.setAddress(address);
        assertEquals(address, createProductState.getAddress());
    }

    @Test
    void getListTags() {
        listTags = new ArrayList<>();
        listTags.add("clothes");
        createProductState.setListTags(listTags);
        assertEquals(listTags, createProductState.getListTags());
    }

    @Test
    void getCreateProductError() {
        createProductError = "error";
        createProductState.setCreateProductError(createProductError);
        assertEquals(createProductError, createProductState.getCreateProductError());
    }

    @Test
    void getPath() {
        path = "src/pic/testpic1.png";
        createProductState.setPath(path);
        assertEquals(path, createProductState.getPath());
    }
}