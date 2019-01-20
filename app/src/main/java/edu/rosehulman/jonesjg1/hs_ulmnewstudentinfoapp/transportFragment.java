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
 * {@link transportFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link transportFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class transportFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public transportFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment transportFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static transportFragment newInstance(String param1, String param2) {
        transportFragment fragment = new transportFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_transport, container, false);
        String queryString = "http://pastebin.com/raw/3NF26n1z";
        try {
            URL url = new URL(queryString);
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
            parser.setInput(is, urlConnection.getContentEncoding());
            int eventType = parser.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){
                if (eventType == XmlPullParser.START_TAG && "transport_connections".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView transportConnections = rootView.findViewById(R.id.transportConnections);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    transportConnections.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "transport_connections_descriptions".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView transportConnectionsDescriptions = rootView.findViewById(R.id.transportConnectionsDescriptions);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    transportConnectionsDescriptions.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "semester_ticket".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView semesterTicket = rootView.findViewById(R.id.semesterTicket);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    semesterTicket.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "semester_ticket_link".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView semesterTicketLink = rootView.findViewById(R.id.semesterTicketLink);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    semesterTicketLink.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "ding1".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView ding_1 = rootView.findViewById(R.id.ding_1);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    ding_1.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "ding_link1".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView dingLink1 = rootView.findViewById(R.id.dingLink1);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    dingLink1.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "ding2".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView ding2 = rootView.findViewById(R.id.ding2);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    ding2.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "ding_link2".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView dingLink2 = rootView.findViewById(R.id.dingLink2);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    dingLink2.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "ding_link3".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView dingLink3 = rootView.findViewById(R.id.dingLink3);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    dingLink3.setText(Html.fromHtml(s));
                }
                else if (eventType == XmlPullParser.START_TAG && "ding_link4".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView dingLink4 = rootView.findViewById(R.id.dingLink4);
                    s = s.replace("\\bre", "</br>");
                    s = s.replace("\\br", "<br>");
                    s = s.replace("\\n", "<br />");
                    dingLink4.setText(Html.fromHtml(s));
                }

                eventType = parser.next();
            }

        } catch (Exception ex){
            Log.e("Transport", "Can't query Pastebin");
            ex.printStackTrace();
        }


        // Inflate the layout for this fragment
        return rootView;    }

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
