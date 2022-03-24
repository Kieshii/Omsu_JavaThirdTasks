package not.standart;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ProductServiceTest {
    private ProductBatch batch;

    @BeforeMethod
    public void setUp() {
        ProductPackaging productPackaging = new ProductPackaging("коробка", 10.0);
        WeightProduct weightProduct = new WeightProduct("машинки", "гоночные");
        PackagedWeightProduct racecarBox = new PackagedWeightProduct(productPackaging, 100.0, weightProduct);
        batch = new ProductBatch("Партия машинок", racecarBox);
    }


    @Test
    public void testCounter() {
        assertEquals(ProductService.countByFilter(batch, new BeginStringFilter("машинки")), 1);
        assertEquals(ProductService.countByFilter(batch, new ContainsStringFilter("гоночные")), 0);
        assertEquals(ProductService.countByFilter(batch, new EndStringFilter("машинки")), 1);
    }

}