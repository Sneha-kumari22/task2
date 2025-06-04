
import java.io.*;
import java.net.*;
import org.json.*;

public class Task2 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONArray jsonArray = new JSONArray(response.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject user = jsonArray.getJSONObject(i);
                System.out.println("Name: " + user.getString("name"));
                System.out.println("Email: " + user.getString("email"));
                System.out.println("City: " + user.getJSONObject("address").getString("city"));
                System.out.println("------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
