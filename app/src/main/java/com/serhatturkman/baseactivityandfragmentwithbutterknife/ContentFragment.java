package com.serhatturkman.baseactivityandfragmentwithbutterknife;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String POSITION = "POSITION";
    private static final String NAME_SURNAME = "NAME_SURNAME";
    private static final String EMAIL = "EMAIL";

    private OnFragmentInteractionListener mListener;

    Unbinder unbinder;

    @BindView(R.id.position) TextView position;
    @BindView(R.id.name_surname) TextView nameSurname;
    @BindView(R.id.email) TextView email;



    public ContentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContentFragment newInstance(String param1, String param2, String param3) {
        ContentFragment fragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putString(POSITION, param1);
        args.putString(NAME_SURNAME, param2);
        args.putString(EMAIL, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("New Instance", "Created");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ////////////////////////////////////////////////////////////////////////////////////////
        // THIS FORMAT IS VERY IMPORTANT! IT WILL FAIL IF YOU USE 'attachToRoot' as 'true'
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_content, container, false);
        container.addView(root);
        ////////////////////////////////////////////////////////////////////////////////////////
        unbinder = ButterKnife.bind(this, root);
        if (getArguments() != null) {
            position.setText(getArguments().getString(POSITION));
            nameSurname.setText(getArguments().getString(NAME_SURNAME));
            email.setText(getArguments().getString(EMAIL));
        }
        return root;
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

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        unbinder.unbind();
    }
}
