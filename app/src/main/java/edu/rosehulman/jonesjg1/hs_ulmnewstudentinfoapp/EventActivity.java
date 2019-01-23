package edu.rosehulman.jonesjg1.hs_ulmnewstudentinfoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
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

public class EventActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Intent intent = getIntent();
        expandableListView = findViewById(R.id.exp_listview);
        List <String> Headings = new ArrayList <String>();
        List<String> L1 = new ArrayList <String>();
        List<String> L2 = new ArrayList <String>();
        List<String> L3 = new ArrayList <String>();

        HashMap <String, List<String>> ChildList = new HashMap <String, List<String>>();

        String heading_items[] = getResources().getStringArray(R.array.header_titles);
        String l1[] = getResources().getStringArray(R.array.h1_items);
        String l2[] = getResources().getStringArray(R.array.h2_items);
        String l3[] = getResources().getStringArray(R.array.h3_items);

        String queryString = "http://pastebin.com/raw/3NF26n1z";
        try {
            URL url = new URL(queryString);
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
            parser.setInput(is, urlConnection.getContentEncoding());
            int eventType = parser.getEventType();
            List <String> tempHeaders = new ArrayList<>();
            List <String> tempL1 = new ArrayList<>();
            List <String> tempL2 = new ArrayList<>();
            List <String> tempL3 = new ArrayList<>();
            while(eventType != XmlPullParser.END_DOCUMENT){
                if (eventType == XmlPullParser.START_TAG && "eventHeader".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView eventHeader = findViewById(R.id.eventHeader);
                    eventHeader.setText(s);
                }
                else if (eventType == XmlPullParser.START_TAG && "eventIntro".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView eventIntro = findViewById(R.id.eventIntro);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    eventIntro.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "recreational".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    tempHeaders.add(s);
                }
                else if (eventType == XmlPullParser.START_TAG && "Clubs1".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL1.add(s);
                }
                else if (eventType == XmlPullParser.START_TAG && "Clubs2".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL1.add(s);
                }else if (eventType == XmlPullParser.START_TAG && "Clubs3".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL1.add(s);
                }else if (eventType == XmlPullParser.START_TAG && "Clubs4".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL1.add(s);
                }else if (eventType == XmlPullParser.START_TAG && "Clubs5".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL1.add(s);
                }else if (eventType == XmlPullParser.START_TAG && "Clubs6".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL1.add(s);
                }else if (eventType == XmlPullParser.START_TAG && "Clubs7".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL1.add(s);
                }else if (eventType == XmlPullParser.START_TAG && "Clubs8".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL1.add(s);
                }
                else if (eventType == XmlPullParser.START_TAG && "Physical".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    tempHeaders.add(s);
                }
                else if (eventType == XmlPullParser.START_TAG && "Gym1".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL2.add(s);
                }
                else if (eventType == XmlPullParser.START_TAG && "Gym2".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL2.add(s);
                }else if (eventType == XmlPullParser.START_TAG && "Gym3".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL2.add(s);
                }else if (eventType == XmlPullParser.START_TAG && "Gym4".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL2.add(s);
                }else if (eventType == XmlPullParser.START_TAG && "Gym5".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL2.add(s);
                }

                else if (eventType == XmlPullParser.START_TAG && "Spiritual".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    tempHeaders.add(s);
                }
                else if (eventType == XmlPullParser.START_TAG && "Church1".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL3.add(s);
                }
                else if (eventType == XmlPullParser.START_TAG && "Church2".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL3.add(s);
                }else if (eventType == XmlPullParser.START_TAG && "Church3".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL3.add(s);
                }else if (eventType == XmlPullParser.START_TAG && "Church4".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL3.add(s);
                }else if (eventType == XmlPullParser.START_TAG && "Church5".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL3.add(s);
                }
                else if (eventType == XmlPullParser.START_TAG && "Mosque1".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL3.add(s);
                }
                else if (eventType == XmlPullParser.START_TAG && "Mosque2".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL3.add(s);
                }else if (eventType == XmlPullParser.START_TAG && "Mosque3".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL3.add(s);
                }
                else if (eventType == XmlPullParser.START_TAG && "Temple1".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    s = s.replace("\\n", "<br />");
                    s = Html.fromHtml(s).toString();
                    tempL3.add(s);
                }
                eventType = parser.next();
            }
            heading_items = tempHeaders.toArray(heading_items);
            l1 = tempL1.toArray(l1);
            l2= tempL2.toArray(l2);
            l3 = tempL3.toArray(l3);

        } catch (Exception ex){
            Log.e("Event", "Can't query Pastebin");
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
        for(String title : l3){
            L3.add(title);

        }

        ChildList.put(Headings.get(0), L1);
        ChildList.put(Headings.get(1), L2);
        ChildList.put(Headings.get(2), L3);

        EventAdapter eventAdapter = new EventAdapter(Headings, ChildList, this);
        expandableListView.setAdapter(eventAdapter);


    }
}
