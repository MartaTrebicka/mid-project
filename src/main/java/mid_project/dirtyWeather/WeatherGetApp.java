package mid_project.dirtyWeather;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class WeatherGetApp {

    private static final String GET_URL = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/1-269508_1_AL" +
            "?apikey=dZesNuxt0sgTiWB9WZmpWOVEbsN28xRm";

    public static void main(String[] args) {

        /**
         * Doróbcie pętlę, w której będzie można "sterować programem":
         *  - wciśnięcie 0 kończy program
         *  - wciśnięcie 1 zaciąga nowe dane o pogodzie
         *  - wciśnięcie 2 wyświetla informacje pogodowe na ekranie
         *  Wszystkie powyższe reakcje mają być przekazane do klasy konrolera (z wyjątkiem 0)
         *
         * Doróbcie "kontrolera" ktory będzie reagował na "menu - akcje użytkownika"
         * - jak macie pobrać nowe dane to wysylacie żądanie URL (to co robiliśmy) i zapisujecie do obiektu pogody
         * - jak macie wyświetlić to wyciągacie dane z obiektu pogody
         *
         */




        try {
            URL obj = new URL(GET_URL);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestMethod("GET");

            /**
             * HTTP:
             * GET - pobieranie danych (po bazowemu - SELECT)
             *
             * POST - wstawienie (pierwsze) danych - (INSERT)
             * PUT - korekta (wszystkich danych) - (UPDATE / MERGE)
             * PATCH - korekta pojedynczych pól - (UPDATE / MERGE)
             *
             * DELETE - kasowanie danych (DELETE)
             *
             * INFO - pobranie informacji - np na temat dostępnych tzw. endpointów czyli
             * adresów pod którymi można wysłać GET, POST itd...
             */

            int responseCode = conn.getResponseCode();
            /**
             * Kody odpowiedzi HTTP:
             * 100 - info
             * 200 - OK
             * 300 - przekierowanie
             * 400 - błąd użytkownika
             * 500 - błąd serwera
             */

            System.out.println("Kod odpowiedzi" + responseCode);
if(responseCode == HttpURLConnection.HTTP_OK){
    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();

while ((inputLine = reader.readLine()) != null) {
    response.append(inputLine);

}
reader.close();
    System.out.println(response);

    //ObjectMapper mapper = new ObjectMapper();
var mapper = new ObjectMapper();
    Map<String, Object> weatherResultMap = mapper.readValue(response.toString(),
            new TypeReference<Map<String, Object>>(){});

    System.out.println(weatherResultMap); //weatherResultMap: size = 2

}

        }catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
