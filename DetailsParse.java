package com.example.pallabi.pharmiz;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailsParse {
    public String[] id = null;
    public String[] name = null;
    public String[] price = null;
    public String[] quantity=null;
    public String[] supplier=null;

    String json;
    JSONArray array;
    JSONObject object;

    public DetailsParse(String json) {
        this.json = json;
    }

    public void getMedData() {
        try {
            object = new JSONObject(json);
            array = object.getJSONArray("result");
            id = new String[array.length()];
            name = new String[array.length()];
            price = new String[array.length()];
            quantity=new String[array.length()];
            supplier=new String[array.length()];


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                id[i] = jsonObject.getString("ID");
                name[i] = jsonObject.getString("Name");
                price[i] = jsonObject.getString("Price");
                quantity[i]= jsonObject.getString("Quantity");
                supplier[i]= jsonObject.getString("Supplier");

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
