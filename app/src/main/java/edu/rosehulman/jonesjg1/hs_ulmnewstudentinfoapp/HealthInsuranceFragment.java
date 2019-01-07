package edu.rosehulman.jonesjg1.hs_ulmnewstudentinfoapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HealthInsuranceFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HealthInsuranceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HealthInsuranceFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HealthInsuranceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HealthInsuranceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HealthInsuranceFragment newInstance(String param1, String param2) {
        HealthInsuranceFragment fragment = new HealthInsuranceFragment();
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
        View rootView = inflater.inflate(R.layout.health,container,false);
        String queryString = "http://pastebin.com/raw/3NF26n1z";
        try{
            URL url = new URL(queryString);
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
            parser.setInput(is, urlConnection.getContentEncoding());
            int eventType = parser.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){
                if (eventType == XmlPullParser.START_TAG && "health_basic".equals(parser.getName())){
                    Log.e("Test", parser.toString());
                    String s = parser.getAttributeValue(null, "text");
                    TextView BasicInfo = rootView.findViewById(R.id.BasicInfo);
                    BasicInfo.setText(s);
                }
                else if(eventType == XmlPullParser.START_TAG && "pub1".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Pub1 = rootView.findViewById(R.id.Pub1);
                    Pub1.setText(s);
                }
                else if(eventType == XmlPullParser.START_TAG && "pub2".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Pub2 = rootView.findViewById(R.id.Pub2);
                    Pub2.setText(s);
                }else if(eventType == XmlPullParser.START_TAG && "pub3".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Pub3 = rootView.findViewById(R.id.Pub3);
                    Pub3.setText(s);
                }else if(eventType == XmlPullParser.START_TAG && "pub4".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Pub4 = rootView.findViewById(R.id.Pub4);
                    Pub4.setText(s);
                }
                else if(eventType == XmlPullParser.START_TAG && "priv1".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Priv1 = rootView.findViewById(R.id.Priv1);
                    Priv1.setText(s);
                }
                else if(eventType == XmlPullParser.START_TAG && "priv2".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Priv2 = rootView.findViewById(R.id.Priv2);
                    Priv2.setText(s);
                }else if(eventType == XmlPullParser.START_TAG && "priv3".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Priv3 = rootView.findViewById(R.id.Priv3);
                    Priv3.setText(s);
                }else if(eventType == XmlPullParser.START_TAG && "priv4".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView Priv4 = rootView.findViewById(R.id.Priv4);
                    Priv4.setText(s);
                }

                eventType = parser.next();
            }

        } catch(Exception ex) {
            Log.e("Health", "Can't query PasteBin");
            ex.printStackTrace();
        }


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
