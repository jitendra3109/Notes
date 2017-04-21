package me.jsroyal.internshala;

import android.os.Bundle;
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

public class AddNote extends Fragment {
    EditText editTitle,editMessage;
    Button addnote;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.addnote,container,false);
        editTitle = (EditText)rootview.findViewById(R.id.titleNew);
        editMessage = (EditText)rootview.findViewById(R.id.messageNew);
        addnote = (Button)rootview.findViewById(R.id.Addnote);
        final DatabaseHelper helper = new DatabaseHelper(getContext());
        addnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.insertRecord(editTitle.getText().toString(),editMessage.getText().toString());
                Toast.makeText(getContext(),"Note added",Toast.LENGTH_SHORT).show();
                editTitle.setText("");
                editMessage.setText("");
            }
        });
        return rootview;
    }
}
