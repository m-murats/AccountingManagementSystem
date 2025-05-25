/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ExchangeRateUtil {

    public static double getExchangeRate(String fromCurrency, String toCurrency) {
        try {
            String urlStr = "https://api.frankfurter.app/latest?from=" + fromCurrency + "&to=" + toCurrency;
            URL url = new URL(urlStr);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            con.disconnect();

            JSONObject json = new JSONObject(content.toString());

            if (json.has("rates") && json.getJSONObject("rates").has(toCurrency)) {
                return json.getJSONObject("rates").getDouble(toCurrency);
            } else {
                System.out.println("Kur bulunamadı: " + content);
                return 0.0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}

