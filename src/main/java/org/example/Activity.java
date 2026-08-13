package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Activity {

    ActivityData data;

    Activity(){
        data = new ActivityData();
    }

    public void getActivity(String name){
        final String url_chamada = "https://api.github.com/users/" + name + "/events";
        try {
            URL url = new URL(url_chamada);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if(connection.getResponseCode() != 200){ //codigo de erro
                throw new RuntimeException("HTTP error code : " + connection.getResponseCode());
            }

            BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            JsonArray jsonArray = JsonParser.parseReader(response).getAsJsonArray();


            if (jsonArray.size() > 0) {

                JsonObject firstEvent = jsonArray.get(0).getAsJsonObject();
                JsonObject actor = firstEvent.getAsJsonObject("actor");
                String login = actor.get("login").getAsString();
                JsonObject secondEvent = jsonArray.get(0).getAsJsonObject();
                JsonObject repo = secondEvent.getAsJsonObject("repo");
                String repo_url = repo.get("name").getAsString();
                data.setLogin(login);
                data.setURL(repo_url);

            } else {
                System.out.println("No events found for user: " + name);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void showActivity(){
        data.showData();
    }

    private String convertJsonToString(BufferedReader buffereReader) throws IOException {
        String response, jsonToString = "";
        while ((response = buffereReader.readLine()) != null) {
            jsonToString += response;
        }
        return jsonToString;
    }
}

