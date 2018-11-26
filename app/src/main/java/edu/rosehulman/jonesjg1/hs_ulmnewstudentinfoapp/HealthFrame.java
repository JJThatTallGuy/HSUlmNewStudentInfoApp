package edu.rosehulman.jonesjg1.hs_ulmnewstudentinfoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class HealthFrame extends AppCompatActivity {
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.health);
        TextView textView = (TextView) findViewById(R.id.BasicInfo);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='https://www.uni-ulm.de/en/io/degree-phd/welcome/authorities-and-insurances/health-insurance/'> " +
                "Basic information about health insurance in Germany </a>";
        textView.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT));

    }
}
