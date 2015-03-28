package hannahmeerajoeshelley.americansinglanguage;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by joseph on 15-03-28.
 */
public class HttpHandler {
    public HttpHandler(){

    }

    public static String getRequest(String webURL) {
        try {
            String webURL1 = webURL.replace(" ", "%20");
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(webURL1);

            /* headers */
            httpget.setHeader("Accept", "application/xml");
            httpget.setHeader("Content-Type", "application/xml");

            /* authentication */

            /* execute */
            BasicHttpResponse httpResponse = null;
            httpResponse = (BasicHttpResponse) httpclient.execute(httpget);
            /* return response */
            return TextHelper.GetText(httpResponse);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}

class TextHelper {
    public static String GetText(InputStream in) {
        String text = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            text = sb.toString();
        } catch (Exception ex) {

        } finally {
            try {

                in.close();
            } catch (Exception ex) {
            }
        }
        return text;
    }

    public static String GetText(HttpResponse response) {
        String text = "";
        try {
            text = GetText(response.getEntity().getContent());
        } catch (Exception ex) {
        }
        return text;
    }
}
