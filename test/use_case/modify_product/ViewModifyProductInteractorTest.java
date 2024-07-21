package use_case.modify_product;

import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.text.View;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ViewModifyProductInteractorTest {
    /** the process for testing is:
     * intoduce input data specifications
     * consider if need to store anything in data base, then use those InMemory to create Data Access Interfaces
     * Create OutputBoundary (overriding methods): insert assertions here
     * Create The Interactor
     * test Interactor.exectue with initated input data
     */
    private User user;
    private Product product;

    @BeforeEach
    void setUp() throws IOException, IOException {
        String name = "Calico";
        String password = "Cat123";
        String email = "calico.cat@mail.utoronto.ca";
        float userRating = 4;
        String studentNumber = "1010101010";

        UserFactory userFactory = new CommonUserFactory();
        user = userFactory.createUser(name, password, email, userRating, studentNumber);

        Image image = ImageIO.read(new File("src/pic/testpic1.png"));
        String description = "It was worn once";
        float price = 2;
        String title = "Red Dress";
        int state = 1;
        Integer rating = 3;
        String eTransferEmail = "calico.cat@mail.utoronto.ca";
        String sellerStudentNumber = "1010101010";
        String address = "123College";
        LocalDateTime time = null;
        ArrayList<LocalDateTime> arrayList = new ArrayList<>();
        CommonScheduleFactory scheduleFactory = new CommonScheduleFactory();
        Schedule schedule = scheduleFactory.createSchedule(time, arrayList);
        ArrayList<String> listTags = new ArrayList<>();
        listTags.add("clothes");
        String productID = "ASDASD";

        ProductFactory productFactory = new CommonProductFactory();

        product = productFactory.createProduct(image, description, title, price, state, rating, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule);

    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void prepareSuccessfulViewTest() throws SQLException, IOException {
        ViewModifyProductOutputBoundary viewModifyProductPresenter = new ViewModifyProductOutputBoundary() {
            @Override
            public void prepareSuccessfulView(ViewModifyProductOutputData viewModifyProductOutputData) {
                assertEquals(viewModifyProductOutputData.getProduct(), product);
                assertEquals(viewModifyProductOutputData.getUser(), user);
            }
        };
        ViewModifyProductInteractor viewModifyProductInteractor = new ViewModifyProductInteractor(viewModifyProductPresenter);

        ViewModifyProductInputData inputData = new ViewModifyProductInputData(user, product);
        viewModifyProductInteractor.execute(inputData);
    }
}