import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ServicoDeCambio {
    private static final String URL_API = "https://v6.exchangerate-api.com/v6/8ae3c6478cd8b461bbe53b25/latest/USD";
    private static final Gson gson = new Gson();

    public static TaxasDeCambio obterTaxasCambio() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_API))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro ao obter dados da API. Código de resposta: " + response.statusCode());
        }

        return gson.fromJson(response.body(), TaxasDeCambio.class);
    }

    public static double obterTaxa(String codigoMoeda) throws Exception {
        TaxasDeCambio taxasCambio = obterTaxasCambio();

        if (taxasCambio.obterTaxas() == null) {
            throw new RuntimeException("As taxas de câmbio estão nulas. Verifique a resposta da API.");
        }

        Double taxa = taxasCambio.obterTaxas().get(codigoMoeda);
        if (taxa == null) {
            throw new RuntimeException("Taxa de câmbio para " + codigoMoeda + " não encontrada.");
        }
        return taxa;
    }

    public static void exibirMoedasFiltradas() throws Exception {
        TaxasDeCambio taxasCambio = obterTaxasCambio();

        if (taxasCambio.obterTaxas() == null) {
            throw new RuntimeException("As taxas de câmbio estão nulas. Verifique a resposta da API.");
        }

        String[] moedasFiltradas = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};

        System.out.println("Taxas de câmbio filtradas:");
        for (String codigo : moedasFiltradas) {
            Double taxa = taxasCambio.obterTaxas().get(codigo);
            if (taxa != null) {
                System.out.printf("%s: %.2f%n", codigo, taxa);
            } else {
                System.out.printf("%s: Taxa não encontrada%n", codigo);
            }
        }
    }
}
