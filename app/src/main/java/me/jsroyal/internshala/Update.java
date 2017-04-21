package me.jsroyal.internshala;

/**
 * Created by jsroyal on 16/4/17.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview =  inflater.inflate(R.layout.updatenote, container, false);
        final EditText Utitle = (EditText)rootview.findViewById(R.id.UpdateTitle);
        final EditText UMesssage =(EditText)rootview.findViewById(R.id.Updatemessage);
        final Button UButton = (Button)rootview.findViewById(R.id.UpdateButton);
        final  DatabaseHelper db = new DatabaseHelper(getContext());
        UButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( db.updateNote(Utitle.getText().toString(),UMesssage.getText().toString()))
                    Toast.makeText(getContext(),"Notes Updated",Toast.LENGTH_SHORT).show();
                Utitle.setText("");
                UMesssage.setText("");
            }
        });

        return rootview;
    }
}

