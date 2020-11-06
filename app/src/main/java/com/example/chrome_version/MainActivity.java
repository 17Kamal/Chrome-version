/*author: Kamal Kumar */
package com.example.chrome_version;

import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView helloTextView = (TextView) findViewById(R.id.text_view_id);
        String str=checkVersion("com.android.chrome");
        helloTextView.setText(str);
    }
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
