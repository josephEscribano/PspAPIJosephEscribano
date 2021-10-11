package dao.utils;

import com.google.gson.*;
import config.ConfigurationSingleton_Client;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.lang.reflect.Type;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ConfigurationSingleton_OkhttpClient {
    private static OkHttpClient pokeApiClient;

    private static Retrofit retrofit;

    private ConfigurationSingleton_OkhttpClient(){
    }

    public static synchronized Retrofit getInstance(){
        if (pokeApiClient == null){

            pokeApiClient = new OkHttpClient.Builder()
                    .readTimeout(Duration.of(1, ChronoUnit.MINUTES))
                    .callTimeout(Duration.of(1,ChronoUnit.MINUTES))
                    .connectTimeout(Duration.of(1,ChronoUnit.MINUTES))
                    .build();

            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
                @Override
                public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                    return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
                }
            }).registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {

                @Override
                public JsonElement serialize(LocalDate localDate, Type type, JsonSerializationContext jsonSerializationContext) {
                    return new JsonPrimitive(localDate.toString());
                }
            }).create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(ConfigurationSingleton_Client.getInstance().getPath_base())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(pokeApiClient)
                    .build();

        }
        return retrofit;
    }


}
