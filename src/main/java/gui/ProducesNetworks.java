package gui;

import com.google.gson.*;
import config.ConfigurationClient;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ProducesNetworks {

    private final ConfigurationClient configuration;

    @Inject
    public ProducesNetworks(ConfigurationClient configuration) {
        this.configuration = configuration;
    }

    @Produces
    @Singleton
    public static OkHttpClient getOkkHttp() {
        return new OkHttpClient.Builder()
                .protocols(List.of(Protocol.HTTP_1_1))
                .readTimeout(Duration.of(1, ChronoUnit.MINUTES))
                .callTimeout(Duration.of(1, ChronoUnit.MINUTES))
                .connectTimeout(Duration.of(1, ChronoUnit.MINUTES))
                .build();

    }

    @Produces
    public static Gson getGson() {
        return new GsonBuilder().registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (jsonElement, type, jsonDeserializationContext) ->
                        LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString()))
                .registerTypeAdapter(LocalDate.class, (JsonSerializer<LocalDate>)
                        (localDate, type, jsonSerializationContext) -> new JsonPrimitive(localDate.toString())).create();
    }

    @Produces
    public synchronized Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(configuration.getPathbase())
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkkHttp())
                .build();
    }


}
