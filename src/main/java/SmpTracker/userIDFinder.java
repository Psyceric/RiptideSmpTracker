package SmpTracker;

import okhttp3.ResponseBody;
import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class userIDFinder {
    public static String findID(String input){
        String ClientID = "23cbgvoi9ztq8joayq4c6refzbfcvv";
        try {
            Retrofit userID = new Retrofit.Builder()
                    .baseUrl("https://api.twitch.tv/kraken/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            API apiConnector = userID.create(API.class);
            String url = (("https://api.twitch.tv/kraken/users" + input));
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/vnd.twitchtv.v5+json");
            connection.setRequestProperty("Client-ID", ClientID);  // a stored value of my clientID
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            int responseCode = connection.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);


            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }
}