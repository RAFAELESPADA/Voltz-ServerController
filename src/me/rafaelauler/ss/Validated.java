package me.rafaelauler.ss;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;

public class Validated {

    private final static String BASE_URL = "https://api.ipify.org";
    private final static List<String> ALLOW_ADDRESS = Arrays.asList("190.115.197.174");

    public static boolean validate() {
        String address = getAddress();
        return address != null && ALLOW_ADDRESS.contains(address) && Bukkit.getServer().getPort() == 10637;
    }

    public static String getAddress() {
        String address = null;
        try {
            URL url = new URL(BASE_URL);
            URLConnection connection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            address = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return address;
    }
}
