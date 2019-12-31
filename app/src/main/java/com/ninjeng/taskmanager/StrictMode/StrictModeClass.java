package com.ninjeng.taskmanager.StrictMode;

public class StrictModeClass {
    public static void StricMode(){
        android.os.StrictMode.ThreadPolicy policy=
                new android.os.StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        android.os.StrictMode.setThreadPolicy(policy);
    }
}

