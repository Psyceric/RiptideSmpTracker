package SmpTracker;

import com.google.api.services.sheets.v4.model.Spreadsheet;
import retrofit2.Call;
import retrofit2.http.*;

public interface API {

    @Headers({
            "Accept: application/vnd.twitchtv.v5+json",
            "Client-ID: 23cbgvoi9ztq8joayq4c6refzbfcvv"
    })
    @GET("users")
    Call<UserList> getUserList(@Query("login") String group);
        //https://api.twitch.tv/kraken/users?login=Psyceric,kingfishow

    @Headers({
            "Accept: application/vnd.twitchtv.v5+json",
            "Client-ID: 23cbgvoi9ztq8joayq4c6refzbfcvv"
    })
    @GET("streams/")
    Call<StreamList> getStreamers(@Query("channel") String ids);
    //https://api.twitch.tv/kraken/users?login=Psyceric&login=kingfishow

       /* @GET("/v4/spreadsheets/{input}")
    Call<> getSpreadsheet(@Path("input") String input,@Query("key") String apiKey);
*/
    }
