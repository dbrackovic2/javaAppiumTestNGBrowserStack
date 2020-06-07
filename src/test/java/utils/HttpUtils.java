package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/*** Elemental example for executing multiple POST requests sequentially.*/
public class HttpUtils {
    public static String createPostRequest(String user) throws IOException {
//      String command = "curl -X POST \"http://opentemp-qa.ak-tech.org/api/Account/QaVerifyRequest\" -H \"accept: application/json\" -H \"Content-Type: application/json-patch+json\" -d \"{ \\\"email\\\": \\\"dejan@qaengineers.net\\\"}\"";
        URL url = new URL ("http://opentemp-qa.ak-tech.org/api/Account/QaVerifyRequest");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        String jsonInputString = "{\"email\": \""+user+"\"}";
        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
            return getStringEmailCode(response.toString());
        }
    }

    public static void createDeleteRequest(String user, String token) throws IOException {
//      String command = "curl -X DELETE \"http://opentemp-qa.ak-tech.org/api/Account/delete/dejan%40qaengineers.net\" -H \"accept: application/json\"";
        user = user.replace("@", "%40");
        URL url = new URL ("http://opentemp-qa.ak-tech.org/api/Account/delete/" + user);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("Authorization", "Bearer "+ token);
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
    }
    public static String getAccessToken() throws IOException {
        URL url = new URL ("http://opentemp-qa.ak-tech.org/api/Account/login");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);
        String jsonInputString = "{\"email\": \"push@push.com\" , \"password\": \"123\", \"deviceId\": \"\"}";
        try(OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
            return getStringToken(response.toString());
        }
    }

    public static String getStringToken(String json){
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        return jsonObject.getAsJsonObject("data").get("accessToken").getAsString();
    }
    public static String getStringEmailCode(String json){
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        return jsonObject.get("data").getAsString();
    }
}
