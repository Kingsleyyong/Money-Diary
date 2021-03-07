package com.madassignment.moneydiary;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditableUserData#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditableUserData extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static String userID;
    int uid;

    public EditableUserData() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditableUserData.
     */
    // TODO: Rename and change types and number of parameters
    public static EditableUserData newInstance(String param1, String param2) {
        EditableUserData fragment = new EditableUserData();
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

        View view = inflater.inflate(R.layout.fragment_editable_user_data, container, false);

        userID = getArguments().getString("userID");
        uid = Integer.parseInt(userID);

        UserRoomDatabase db = UserRoomDatabase.getDatabase(getContext());
        final UserDao userDao = db.userDao();
        User user = userDao.UserById(uid);

        String disName = user.username;
        String disEmail = user.email;
        String disPass = user.password;
        String disConfirmPass = user.confirmPassword;

        EditText name = view.findViewById(R.id.editProfileName);
        EditText email = view.findViewById(R.id.editProfileEmail);
        EditText pass = view.findViewById(R.id.editProfilePass);
        EditText conPass = view.findViewById(R.id.editProfileReconfirm);

        name.setText(disName);
        email.setText(disEmail);
        pass.setText(disPass);
        conPass.setText(disConfirmPass);

        // Inflate the layout for this fragment
        return view;
    }
}