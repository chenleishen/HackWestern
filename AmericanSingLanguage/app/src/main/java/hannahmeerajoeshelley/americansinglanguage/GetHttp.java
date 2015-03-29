package hannahmeerajoeshelley.americansinglanguage;

import android.util.Log;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by joseph on 15-03-28.
 */
public class GetHttp {
    public GetHttp(){
    }

    private HttpResponse<JsonNode> getHttp(String fetchURL){
        HttpResponse<JsonNode> request = null;
        try {
            request = Unirest.get(fetchURL)
                    .header("X-Mashape-Authorization", "EEZTLb3jOTmshwWGf9EA4GGXgEFop1wZsP4jsnDKSP26wlBPLg")
                    .header("Accept", "application/json")
                    .asJson();
        } catch (UnirestException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return request;
    }

    public String getResponse(String fetchURL, String objType){
        HttpResponse<JsonNode> responseJS = getHttp(fetchURL);
        Log.d("DEBUG STREAM", responseJS.getStatusText());
        JSONObject obj = responseJS.getBody().getObject();
        String id ="";
        try {
            id = obj.getString(objType);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return id;
    }
}
