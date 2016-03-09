package com.pp.dcasajus.forkpoint;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.pp.dcasajus.forkpoint.MainContent.MainActivity;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RelativeLayout rLayout = (RelativeLayout) findViewById (R.id.relative_layout);
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.home);
        rLayout.setBackground(drawable);

        Button button = (Button) findViewById(R.id.goToLocalitation);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
