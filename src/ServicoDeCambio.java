import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicoDeCambio {
    private static final String URL_API = "https://v6.exchangerate-api.com/v6/8ae3c6478cd8b461bbe53b25/latest/USD";
    private static final Gson gson = new Gson();

    public static TaxasDeCambio obterTaxasCambio() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_API))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Verifica se o código de resposta HTTP é 200 (sucesso)
        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro ao obter dados da API. Código de resposta: " + response.statusCode());
        }

        // Exibe a resposta JSON para verificar a estrutura
        System.out.println("Resposta JSON: " + response.body());

        // Analisa o JSON usando Gson
        return gson.fromJson(response.body(), RespostaTaxasCambio.class);
    }

    public static double obterTaxa(String codigoMoeda) throws Exception {
        RespostaTaxasCambio taxasCambio = obterTaxasCambio();

        if (taxasCambio.getTaxas() == null) {
            throw new RuntimeException("As taxas de câmbio estão nulas. Verifique a resposta da API.");
        }

        return taxasCambio.obterTaxas().getOrDefault(codigoMoeda, 0.0);
    }
}
