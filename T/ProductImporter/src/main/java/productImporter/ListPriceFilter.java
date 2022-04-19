package productImporter;

import java.math.BigDecimal;

public class ListPriceFilter implements ProductValidator{

    private final BigDecimal lowerBound;

    public ListPriceFilter(BigDecimal lowerBound) {
        this.lowerBound = lowerBound;
    }

    @Override
    public boolean isValid(Product product) {
        return product.getPricing().getListPrice().compareTo(lowerBound) >= 0;
    }
}
