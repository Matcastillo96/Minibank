package minibank.bbva.model.service;

import org.springframework.stereotype.Service;

import minibank.bbva.model.entitys.enums.TypeMoney;

@Service
public class ChangeMoneyRestImpl implements ServicioCambio {

    @Override
    public ResultadoCambio cambiar(TypeMoney de, TypeMoney a, Double monto) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().
                                uri(URI.create("https://api.apilayer.com/exchangerates_data/convert?to= + de.toString() + "&from="+ a.toString() +"&amount="+ monto))
                                .header("apikey", "8Dd6z0XLgR5iurxOHPy4Xj2jirXl5eso")
                                .GET()
                                .build();

        try {
        	HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}