import java.util.Map;

public class TaxasDeCambio {
    private String base_code;
    private Map<String, Double> conversion_rates;

    public String obterBase() {
        return base_code;
    }

    public Map<String, Double> obterTaxas() {
        return conversion_rates;
    }
}
