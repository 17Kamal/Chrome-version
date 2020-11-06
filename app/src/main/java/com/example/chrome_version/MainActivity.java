package com.example.chrome_version;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView helloTextView = (TextView) findViewById(R.id.text_view_id);
        String str=checkVersion("com.android.chrome");
        helloTextView.setText(str);
    }
    /*private String isChromeInstalledAndVersionGreaterThan65() {
        PackageInfo pInfo;
        try {
            pInfo = getPackageManager().getPackageInfo("com.android.chrome", 0);
        } catch (PackageManager.NameNotFoundException e) {
            //chrome is not installed on the device
            return "chrome is not installed on the device";
        }
        if (pInfo != null) {
            //Chrome has versions like 68.0.3440.91, we need to find the major version
            //using the first dot we find in the string
            int firstDotIndex = pInfo.versionName.indexOf(".");
            //take only the number before the first dot excluding the dot itself
            String majorVersion = pInfo.versionName.substring(0, firstDotIndex);
            return majorVersion;
        }
        return "0";
    }
    String str= isChromeInstalledAndVersionGreaterThan65();*/
    private String checkVersion(String uri) {
        String versionName;
        int version = 0;
        PackageManager pm = getPackageManager();
        try {
            versionName = pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES).versionName;

            return versionName ;
        } catch (PackageManager.NameNotFoundException e) {
            //Catch the Exception
        }
        return "0";
    }

}
