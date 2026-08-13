package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Activity {


    public void getActivity(String name){
        final String url_chamada = "https://api.github.com/users/" + name + "/events";
        try {
            URL url = new URL(url_chamada);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if(connection.getResponseCode() != 200){ //codigo de erro
                throw new RuntimeException("HTTP error code : " + connection.getResponseCode());
            }

            BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
            String teste = jsonObject.getAsJsonObject("actor").get("login").getAsString();
            System.out.println(teste);

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private String convertJsonToString(BufferedReader buffereReader) throws IOException {
        String response, jsonToString = "";
        while ((response = buffereReader.readLine()) != null) {
            jsonToString += response;
        }
        return jsonToString;
    }
}

