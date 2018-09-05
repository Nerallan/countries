package com.nerallan.countries;

import com.nerallan.countries.model.DataModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class JSONhelper{

     HttpURLConnection connection;
     List<DataModel> data;


    public List<DataModel> getdatafromurl(String url){

        try{
            URL url1 = new URL(url);

            connection = (HttpURLConnection) url1.openConnection();
            connection.connect();
            InputStream inputStream= connection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            StringBuffer buffer = new StringBuffer();
            while ((line=reader.readLine())!=null){

                buffer.append(line);
                String result = buffer.toString();
                JSONArray jsonArray = new JSONArray(result);
                data = new ArrayList<>();

                for (int i =0; i<buffer.length();i++){

                    DataModel dataModel = new DataModel();
                    JSONObject jsonObject =jsonArray.getJSONObject(i);
                    String name = jsonObject.getString("name");
                    String capital= jsonObject.getString("capital");
                    String area = jsonObject.getString("area");
                    String flagUrl = jsonObject.getString("flag");

                    dataModel.setCapital(capital);
                    dataModel.setName(name);
                    dataModel.setArea(area);
                    dataModel.setFlagUrl(flagUrl);

                    data.add(dataModel);
               }
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return data;
    }

}
