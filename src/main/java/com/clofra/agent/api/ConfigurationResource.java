package com.clofra.agent.api;
import com.clofra.agent.AgentConfiguration;

import static spark.Spark.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

public class ConfigurationResource {
    private static Gson gson = new Gson();
    static Type configMapType = new TypeToken<Map<String, String>>() {}.getType();
    public static void main(String[] args) {
        port(9003);
        get("/configuration/:configkey", (req, res) -> {
            String key = req.params(":configkey");
            return AgentConfiguration.getConfig(key);
        });

        post("/configuration", (req, res) -> {
            String jsonString= req.body();
            Map<String, String> configMap = gson.fromJson(jsonString, configMapType);
            for(Map.Entry<String, String> entry : configMap.entrySet()) {
            AgentConfiguration.changeConfig(entry.getKey(), entry.getValue());
            }
            JsonObject responseJson = new JsonObject();
            responseJson.addProperty("isSuccesfull", Boolean.TRUE);
            return responseJson;
        });
    }
}

