package ch.noebuerki.gradely.storage;

import android.content.Context;

public class User {

    public static String getUsername(Context context) {
        return context.getSharedPreferences("gradely", Context.MODE_PRIVATE).getString("username", "");
    }

    public static void setUsername(Context context, String username) {
        context.getSharedPreferences("gradely", Context.MODE_PRIVATE).edit().putString("username", username).apply();
    }

    public static String getPassword(Context context) {
        return context.getSharedPreferences("gradely", Context.MODE_PRIVATE).getString("password", "");
    }

    public static void setPassword(Context context, String password) {
        context.getSharedPreferences("gradely", Context.MODE_PRIVATE).edit().putString("password", password).apply();
    }
}
