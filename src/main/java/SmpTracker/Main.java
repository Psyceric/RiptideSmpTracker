package SmpTracker;

import com.google.api.services.sheets.v4.Sheets;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Spreadsheet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static UserList holdResponse = null;
    public static void main(String[] args) {
        ArrayList<String> twitchN = new ArrayList();
        ArrayList<String> minecraftN = new ArrayList();
        List<String> ranges = new ArrayList<>();
        boolean includeGridData = false;
        try {
            Scanner scanner = new Scanner(new File("./src/Master.txt"));
            while (scanner.hasNextLine()) {
                String hold = (scanner.nextLine());
                String twitch = hold.substring(0, hold.indexOf('-'));
                String minecraft = hold.substring(hold.indexOf('-') + 1, hold.length());
                twitchN.add(twitch);
                minecraftN.add(minecraft);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Retrofit initialConnector = new Retrofit.Builder()
                .baseUrl("https://api.twitch.tv/kraken/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API apiConnector = initialConnector.create(API.class);
        Call<UserList> callReq = apiConnector.getUserList(String.join(",",twitchN));
        UserList userList = new UserList();
        try{
            userList.setUsers(callReq.execute().body().getUsers());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        List<String> userIDs = new ArrayList<>();
        ArrayList<String> twitchDisplayName = new ArrayList();
        for(User eachUser : userList.getUsers()){
            userIDs.add(eachUser.getId());
            twitchDisplayName.add(eachUser.getDisplayName());
                        //System.out.println(eachUser.getId());
        }
       // System.out.println(String.join(",",userIDs));
        Call<StreamList> streamerRequest = apiConnector.getStreamers(String.join(",",userIDs));
        StreamList streamersOnline = new StreamList();
        try{
            streamersOnline.setStreams(streamerRequest.execute().body().getStreamers());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        for(Streamers eachStreamers : streamersOnline.getStreamers()){
            eachStreamers.getChannel().setMinecraftN(minecraftN.get(twitchDisplayName.indexOf(eachStreamers.getChannel().getDisplayName())));

            System.out.println(eachStreamers.getChannel().getDisplayName() + " - " + eachStreamers.getChannel().getMinecraftN()+ " - "+ eachStreamers.getChannel().getGame());


        }

        }

    }


