package edu.rosehulman.jonesjg1.hs_ulmnewstudentinfoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HealthActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health);
        Intent intent = getIntent();
        expandableListView = findViewById(R.id.exp_listview);
        List <String> Headings = new ArrayList <String>();
        List<String> L1 = new ArrayList <String>();
        List<String> L2 = new ArrayList <String>();

        HashMap <String, List<String>> ChildList = new HashMap <String, List<String>>();

        String heading_items[] = getResources().getStringArray(R.array.healthTitles);
        String l1[] = getResources().getStringArray(R.array.pubList);
        String l2[] = getResources().getStringArray(R.array.privList);

        String queryString = "http://pastebin.com/raw/3NF26n1z";
        try{
            URL url = new URL(queryString);
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
            parser.setInput(is, urlConnection.getContentEncoding());
            int eventType = parser.getEventType();
            List <String> tempHeaders = new ArrayList<>();
            List <String> tempL1 = new ArrayList<>();
            List <String> tempL2 = new ArrayList<>();
            while(eventType != XmlPullParser.END_DOCUMENT){
                if (eventType == XmlPullParser.START_TAG && "health_basic".equals(parser.getName())){
                    Log.e("Test", parser.toString());
                    String s = parser.getAttributeValue(null, "text");
                    TextView BasicInfo = findViewById(R.id.BasicInfo);
                    BasicInfo.setText(s);
                }
                else if(eventType == XmlPullParser.START_TAG && "healthTitle1".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    tempHeaders.add(s);
                }
                else if(eventType == XmlPullParser.START_TAG && "healthTitle2".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    tempHeaders.add(s);
                }
                else if(eventType == XmlPullParser.START_TAG && "pub1".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    tempL1.add(s);
                }
                else if(eventType == XmlPullParser.START_TAG && "pub2".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    tempL1.add(s);
                }else if(eventType == XmlPullParser.START_TAG && "pub3".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    tempL1.add(s);
                }else if(eventType == XmlPullParser.START_TAG && "pub4".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    tempL1.add(s);
                }
                else if(eventType == XmlPullParser.START_TAG && "priv1".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    tempL2.add(s);
                }
                else if(eventType == XmlPullParser.START_TAG && "priv2".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    tempL2.add(s);
                }else if(eventType == XmlPullParser.START_TAG && "priv3".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    tempL2.add(s);
                }else if(eventType == XmlPullParser.START_TAG && "priv4".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    tempL2.add(s);
                }
                eventType = parser.next();
            }
            heading_items = tempHeaders.toArray(heading_items);
            l1 = tempL1.toArray(l1);
            l2 = tempL2.toArray(l2);

        } catch(Exception ex) {
            Log.e("Health", "Can't query PasteBin");
            ex.printStackTrace();
        }
        for (String title : heading_items){
            Headings.add(title);
        }
        for(String title : l1){
            L1.add(title);

        }

        for(String title : l2){
            L2.add(title);

        }

        ChildList.put(Headings.get(0), L1);
        ChildList.put(Headings.get(1), L2);

        EventAdapter eventAdapter = new EventAdapter(Headings, ChildList, this);
        expandableListView.setAdapter(eventAdapter);


    }
}
