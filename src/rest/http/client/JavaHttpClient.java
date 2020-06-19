package rest.http.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JavaHttpClient
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        try {
            URL url = new URL("https://www.google.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            String input = "{\"qty\":100,\"name\":\"iPad 4\"}";
            OutputStream o = conn.getOutputStream();
            o.write(input.getBytes());
            o.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Received Response code: " + conn.getResponseCode());
            }

            BufferedReader bfr = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;
            while ((output = bfr.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
