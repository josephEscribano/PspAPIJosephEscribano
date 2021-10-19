package dao.utils;

import com.google.gson.*;
import config.ConfigurationSingletonClient;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.lang.reflect.Type;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ConfigurationSingletonOkhttpClient {
    private static OkHttpClient pokeApiClient;

    private static Retrofit retrofit;

    private ConfigurationSingletonOkhttpClient(){
    }

    public static synchronized Retrofit getInstance(){
        if (pokeApiClient == null){

            pokeApiClient = new OkHttpClient.Builder()
                    .protocols(List.of(Protocol.HTTP_1_1))
                    .readTimeout(Duration.of(1, ChronoUnit.MINUTES))
                    .callTimeout(Duration.of(1,ChronoUnit.MINUTES))
                    .connectTimeout(Duration.of(1,ChronoUnit.MINUTES))
                    .build();

            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (jsonElement, type, jsonDeserializationContext) ->
                    LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString()))
                    .registerTypeAdapter(LocalDate.class, (JsonSerializer<LocalDate>)
                    (localDate, type, jsonSerializationContext) -> new JsonPrimitive(localDate.toString())).create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(ConfigurationSingletonClient.getInstance().getPathbase())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(pokeApiClient)
                    .build();

        }
        return retrofit;
    }


}
