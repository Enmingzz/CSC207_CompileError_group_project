package interface_adapter.modify_product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ViewModifyProductStateTest {
    private String description;
    private String price;
    private String address;
    private String title;
    private String email;
    private String message;

    private String path;
    private Image image;

    private ViewModifyProductState viewModifyProductState;

    @BeforeEach
    void setUp() {
        viewModifyProductState = new ViewModifyProductState();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getDescription() {
        description = "It was worn once";
        viewModifyProductState.setDescription(description);
        assertEquals(description, viewModifyProductState.getDescription());
    }

    @Test
    void getPrice() {
        price = "9";
        viewModifyProductState.setPrice(price);
        assertEquals(price, viewModifyProductState.getPrice());
    }

    @Test
    void getAddress() {
        address = "123College";
        viewModifyProductState.setAddress(address);
        assertEquals(address, viewModifyProductState.getAddress());
    }

    @Test
    void getTitle() {
        title = "Red Dress";
        viewModifyProductState.setTitle(title);
        assertEquals(title, viewModifyProductState.getTitle());
    }

    @Test
    void getEmail() {
        email = "calico.cat@mail.utoronto.ca";
        viewModifyProductState.setEmail(email);
        assertEquals(email, viewModifyProductState.getEmail());
    }

    @Test
    void getPath() {
        path = "src/pic/testpic1.png";
        viewModifyProductState.setPath(path);
        assertEquals(path, viewModifyProductState.getPath());
    }

    @Test
    void getImage() throws IOException {
        image = ImageIO.read(new File("src/pic/testpic1.png"));
        viewModifyProductState.setImage(image);
        assertEquals(image, viewModifyProductState.getImage());
    }

    @Test
    void getMessage() {
        message = "a";
        viewModifyProductState.setMessage(message);
        assertEquals(message, viewModifyProductState.getMessage());
    }
}