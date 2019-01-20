package edu.rosehulman.jonesjg1.hs_ulmnewstudentinfoapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
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
 * {@link JobsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link JobsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JobsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public JobsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JobsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JobsFragment newInstance(String param1, String param2) {
        JobsFragment fragment = new JobsFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_jobs, container, false);
        String queryString = "http://pastebin.com/raw/3NF26n1z";
        try {
            URL url = new URL(queryString);
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
            parser.setInput(is, urlConnection.getContentEncoding());
            int eventType = parser.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){
                if (eventType == XmlPullParser.START_TAG && "job_header".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView jobHeader = rootView.findViewById(R.id.jobHeader);
                    Log.d("Text", s);
                    jobHeader.setText(s.replace("\\n", "\n"));
                }
                else if (eventType == XmlPullParser.START_TAG && "job_intro".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView jobIntro = rootView.findViewById(R.id.jobIntro);
                    jobIntro.setText(s.replace("\\n", "\n"));
                }
                else if (eventType == XmlPullParser.START_TAG && "how_much_work".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView howMuchWork = rootView.findViewById(R.id.how_much_work);
                    howMuchWork.setText(s.replace("\\n", "\n"));
                }
                else if (eventType == XmlPullParser.START_TAG && "rules".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView rules = rootView.findViewById(R.id.rules);
                    rules.setText(s.replace("\\n", "\n"));
                }
                else if (eventType == XmlPullParser.START_TAG && "eu".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView eu = rootView.findViewById(R.id.eu);
                    eu.setText(s.replace("\\n", "\n"));
                }
                else if (eventType == XmlPullParser.START_TAG && "eu_description".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView euDescription = rootView.findViewById(R.id.eu_description);
                    euDescription.setText(s.replace("\\n", "\n"));
                }
                else if (eventType == XmlPullParser.START_TAG && "searching_job".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView searchingJob = rootView.findViewById(R.id.searchingJob);
                    searchingJob.setText(s.replace("\\n", "\n"));
                }
                else if (eventType == XmlPullParser.START_TAG && "job_description".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView jobDescription = rootView.findViewById(R.id.jobDescription);
                    jobDescription.setText(s.replace("\\n", "\n"));
                }
                else if (eventType == XmlPullParser.START_TAG && "academic_assistants".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView academicAssistant = rootView.findViewById(R.id.academicAssistant);
                    academicAssistant.setText(s.replace("\\n", "\n"));
                }
                else if (eventType == XmlPullParser.START_TAG && "academic_description".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView academicDescription = rootView.findViewById(R.id.academicDescription);
                    academicDescription.setText(s.replace("\\n", "\n"));
                }
                else if (eventType == XmlPullParser.START_TAG && "outside_institution".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView outsideInstitution = rootView.findViewById(R.id.outsideInstitution);
                    outsideInstitution.setText(s.replace("\\n", "\n"));
                }
                else if (eventType == XmlPullParser.START_TAG && "outside_institution_description".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView outsideInstitutionDescription = rootView.findViewById(R.id.outsideInstitutionDescription);
                    outsideInstitutionDescription.setText(s.replace("\\n", "\n"));
                }
                else if (eventType == XmlPullParser.START_TAG && "important".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView important = rootView.findViewById(R.id.important);
                    important.setText(s.replace("\\n", "\n"));
                }
                else if (eventType == XmlPullParser.START_TAG && "important_info".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView importantInfo = rootView.findViewById(R.id.importantInfo);
                    importantInfo.setText(s.replace("\\n", "\n"));
                }
                else if (eventType == XmlPullParser.START_TAG && "tips".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView tips = rootView.findViewById(R.id.tips);
                    tips.setText(s.replace("\\n", "\n"));
                }
                else if (eventType == XmlPullParser.START_TAG && "tips_description".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView tipsDescription = rootView.findViewById(R.id.tipsDescription);
                    tipsDescription.setText(s.replace("\\n", "\n"));
                }
                else if (eventType == XmlPullParser.START_TAG && "job_links".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView jobLinks = rootView.findViewById(R.id.jobLinks);
                    jobLinks.setText(s.replace("\\n", "\n"));
                }
                else if (eventType == XmlPullParser.START_TAG && "link_notes".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView linkNotes = rootView.findViewById(R.id.linkNotes);
                    linkNotes.setText(s.replace("\\n", "\n"));
                }
                else if (eventType == XmlPullParser.START_TAG && "linkl".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView link1 = rootView.findViewById(R.id.link1);
                    link1.setText(s.replace("\\n", "\n"));
                }
                else if (eventType == XmlPullParser.START_TAG && "link2".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView link2 = rootView.findViewById(R.id.link2);
                    link2.setText(s.replace("\\n", "\n"));
                }else if (eventType == XmlPullParser.START_TAG && "link3".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView link3 = rootView.findViewById(R.id.link3);
                    link3.setText(s.replace("\\n", "\n"));
                }else if (eventType == XmlPullParser.START_TAG && "link4".equals(parser.getName())){
                    String s = parser.getAttributeValue(null, "text");
                    TextView link4 = rootView.findViewById(R.id.link4);
                    link4.setText(s.replace("\\n", "\n"));
                }
                eventType = parser.next();
            }

        } catch (Exception ex){
            Log.e("Jobs", "Can't query Pastebin");
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
