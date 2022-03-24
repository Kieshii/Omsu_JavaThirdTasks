package not.standart;

import java.util.Arrays;

public class ProductService {
    public static int countByFilter(ProductBatch batch, IFilter strFilter) {
        int count = 0;
        for (PackagedProduct product: batch.getProducts()) {
            if (strFilter.apply(product.getName())) count++;
        }
        return  count;
    }
}
