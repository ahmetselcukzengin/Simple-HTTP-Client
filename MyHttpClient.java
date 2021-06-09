import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyHttpClient{
public static void main(String[] args) {
try{
URL url = new URL(args[0]);
String htmldoc = HTML(url);
System.out.println(htmldoc);
}catch(Exception ex){
}
}
public static String HTML(URL url) {
    HttpURLConnection connection; 
    BufferedReader reader; 
    String line;
    String result = "";
    try {
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while ((line = reader.readLine()) != null) {
            result += line +"\n";
        }
        reader.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return result;
}
}
