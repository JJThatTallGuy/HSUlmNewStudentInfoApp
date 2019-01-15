package edu.rosehulman.jonesjg1.hs_ulmnewstudentinfoapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FAQFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FAQFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FAQFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FAQFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FAQFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FAQFragment newInstance(String param1, String param2) {
        FAQFragment fragment = new FAQFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    /** Includes the XMLParser that is used to get the up-to-date strings.xml file from the Internet.*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_faq, container, false);
        String queryString = "http://pastebin.com/raw/3NF26n1z";
        try {
            URL url = new URL(queryString);
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
            parser.setInput(is, urlConnection.getContentEncoding());
            int eventType = parser.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){
                if (eventType == XmlPullParser.START_TAG && "faq".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView faqHeader = rootView.findViewById(R.id.faqHeader);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    faqHeader.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "Q1".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Q1 = rootView.findViewById(R.id.Q1);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    Q1.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "A1".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView A1 = rootView.findViewById(R.id.A1);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    A1.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "Q2".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Q2 = rootView.findViewById(R.id.Q2);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    Q2.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "A2".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView A2 = rootView.findViewById(R.id.A2);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    A2.setText(Html.fromHtml(s));
                }else if (eventType == XmlPullParser.START_TAG && "Q3".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Q3 = rootView.findViewById(R.id.Q3);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    Q3.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "A3".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView A3 = rootView.findViewById(R.id.A3);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    A3.setText(Html.fromHtml(s));
                }else if (eventType == XmlPullParser.START_TAG && "Q4".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Q4 = rootView.findViewById(R.id.Q4);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    Q4.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "A4".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView A4 = rootView.findViewById(R.id.A4);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    A4.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "Q5".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Q5 = rootView.findViewById(R.id.Q5);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    Q5.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "A5".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView A5 = rootView.findViewById(R.id.A5);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    A5.setText(Html.fromHtml(s));
                }else if (eventType == XmlPullParser.START_TAG && "Q6".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Q6 = rootView.findViewById(R.id.Q6);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    Q6.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "A6".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView A6 = rootView.findViewById(R.id.A6);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    A6.setText(Html.fromHtml(s));
                }else if (eventType == XmlPullParser.START_TAG && "Q8".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Q8 = rootView.findViewById(R.id.Q8);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    Q8.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "A8".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView A8 = rootView.findViewById(R.id.A8);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    A8.setText(Html.fromHtml(s));
                }else if (eventType == XmlPullParser.START_TAG && "Q9".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Q9 = rootView.findViewById(R.id.Q9);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    Q9.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "A9".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView A9 = rootView.findViewById(R.id.A1);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    A9.setText(Html.fromHtml(s));
                }else if (eventType == XmlPullParser.START_TAG && "Q10".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Q10 = rootView.findViewById(R.id.Q10);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    Q10.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "A10".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView A10 = rootView.findViewById(R.id.A10);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    A10.setText(Html.fromHtml(s));
                }else if (eventType == XmlPullParser.START_TAG && "Q11".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Q11 = rootView.findViewById(R.id.Q11);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    Q11.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "A11".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView A11 = rootView.findViewById(R.id.A1);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    A11.setText(Html.fromHtml(s));
                }else if (eventType == XmlPullParser.START_TAG && "Q12".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Q12 = rootView.findViewById(R.id.Q12);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    Q12.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "A12".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView A12 = rootView.findViewById(R.id.A12);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    A12.setText(Html.fromHtml(s));
                }else if (eventType == XmlPullParser.START_TAG && "Q13".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Q13 = rootView.findViewById(R.id.Q13);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    Q13.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "A13".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView A13 = rootView.findViewById(R.id.A13);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    A13.setText(Html.fromHtml(s));
                }else if (eventType == XmlPullParser.START_TAG && "Q14".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Q14 = rootView.findViewById(R.id.Q14);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    Q14.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "A14".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView A14 = rootView.findViewById(R.id.A14);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    A14.setText(Html.fromHtml(s));
                }else if (eventType == XmlPullParser.START_TAG && "Q15".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Q15 = rootView.findViewById(R.id.Q15);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    Q15.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "A15".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView A15 = rootView.findViewById(R.id.A15);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    A15.setText(Html.fromHtml(s));
                }else if (eventType == XmlPullParser.START_TAG && "Q16".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Q16 = rootView.findViewById(R.id.Q16);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    Q16.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "A16".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView A16 = rootView.findViewById(R.id.A16);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    A16.setText(Html.fromHtml(s));
                }else if (eventType == XmlPullParser.START_TAG && "Q17".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Q17 = rootView.findViewById(R.id.Q17);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    Q17.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "A17".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView A17 = rootView.findViewById(R.id.A17);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    A17.setText(Html.fromHtml(s));
                }
                eventType = parser.next();
            }

        } catch (Exception ex){
            Log.e("FAQ", "Can't query Pastebin");
            ex.printStackTrace();
        }




        // Inflate the layout for this fragment
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
