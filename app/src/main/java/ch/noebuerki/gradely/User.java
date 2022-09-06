package ch.noebuerki.gradely;

import android.content.Context;
import android.content.SharedPreferences;

public class User {

    public static boolean isLoginValid(Context context) {
        return context.getSharedPreferences("gradely", Context.MODE_PRIVATE).getBoolean("isValid", false);
    }

    public static void isLoginValid(Context context, boolean isValid) {
        context.getSharedPreferences("gradely", Context.MODE_PRIVATE).edit().putBoolean("isValid", isValid).apply();
    }

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
