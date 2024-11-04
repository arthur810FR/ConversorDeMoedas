import java.util.Map;

public class TaxasDeCambio {
    private String base;
    private Map<String, Double> taxas;

    public String obterBase() {
        return base;
    }

    public Map<String, Double> obterTaxas() {
        return taxas;
    }
}
