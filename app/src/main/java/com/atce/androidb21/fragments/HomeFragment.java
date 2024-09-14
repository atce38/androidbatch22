package com.atce.androidb21.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.atce.androidb21.FormActivity;
import com.atce.androidb21.R;


public class HomeFragment extends Fragment {

    Spinner citySpinner;
    String [] cities={"Select City","Gujranwala","Lahore","Kamoke","Gujrat"};
    RadioGroup genderGrp;
    Button btnSave;
    String selected_city;
    CheckBox bio,eng,urdu;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment

        citySpinner=view.findViewById(R.id.citySpinner);
        genderGrp=view.findViewById(R.id.genderGrp);
        btnSave=view.findViewById(R.id.btnSave);
        bio=view.findViewById(R.id.bio);
        eng=view.findViewById(R.id.eng);
        urdu=view.findViewById(R.id.urdu);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item,cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(adapter);

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_city=cities[position];


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rdButton=view.findViewById(genderGrp.getCheckedRadioButtonId());
                String subjects="";

                Toast.makeText(getActivity(), "City: "+selected_city, Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), "Gender: "+rdButton.getText().toString(), Toast.LENGTH_SHORT).show();

                if(urdu.isChecked()){
                    subjects+=","+urdu.getText().toString();
                }
                if(eng.isChecked()){
                    subjects+=","+eng.getText().toString();
                }
                if(bio.isChecked()){
                    subjects+=","+bio.getText().toString();
                }
                Toast.makeText(getActivity(), "Select Subjects: "+subjects, Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }
}