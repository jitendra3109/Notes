package me.jsroyal.internshala;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by jsroyal on 16/4/17.
 */

public class Delete extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rooview =  inflater.inflate(R.layout.delete,container,false);
        final EditText deletenote = (EditText)rooview.findViewById(R.id.titleDelete);
        final Button deleteBtn = (Button)rooview.findViewById(R.id.Deletenote);
        final DatabaseHelper db1= new DatabaseHelper(getContext());
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db1.deleteTitle(deletenote.getText().toString());
                Toast.makeText(getContext(),"Note added",Toast.LENGTH_SHORT).show();
                deletenote.setText("");
            }
        });
        return rooview;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
