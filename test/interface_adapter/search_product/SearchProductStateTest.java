package interface_adapter.search_product;

import entity.product.Product;
import interface_adapter.search_product.search.SearchProductState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SearchProductStateTest {

    private SearchProductState searchProductState;

    @BeforeEach
    void setUp() {
        searchProductState = new SearchProductState();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUser() {
        assertNull(searchProductState.getUser());
    }

    @Test
    void setUser() {
        searchProductState.setUser(null);
    }

    @Test
    void getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        assertEquals(products, searchProductState.getProducts());
    }

    @Test
    void setProducts() {
        searchProductState.setProducts(null);
    }
}