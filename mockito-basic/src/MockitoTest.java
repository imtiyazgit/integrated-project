import dao.ProductDao;
import dao.ProductDaoImpl;
import model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import service.ProductService;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    private static final int DUMMY_CLIENT_ID = 1;

/*
    @Mock
    private ProductDao productDao;
*/

    @InjectMocks
    private ProductService productService = new ProductService();

    @Test
    public void with_arguments(){
        Comparable c=mock(Comparable.class);
        when(c.compareTo("Test")).thenReturn(1);
        assertEquals(1,c.compareTo("Test"));
    }

    @Test
    public void testClientProductSum() {
        List<Product> products = Arrays.asList(
                createProductWithAmount(5), createProductWithAmount(6));

        ProductDao d = mock(ProductDaoImpl.class);
        when(d.getAllProducts(anyInt())).thenReturn(products);

        // use mock in test....
        assertEquals(products, d.getAllProducts(1));

        assertEquals(11, productService.getClientProductsSum(DUMMY_CLIENT_ID));
    }

    private Product createProductWithAmount(int amount) {
        return new Product(100, "Product 15", amount);
    }


}






