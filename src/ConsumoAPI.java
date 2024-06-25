import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    public static double ConverorJson (String moneda1, String moneda2) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/3d60d948e149df356861c91b/pair/"+moneda1+"/"+moneda2))
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
        double conversionRate = jsonObject.get("conversion_rate").getAsDouble();
        return conversionRate;
    }
}
