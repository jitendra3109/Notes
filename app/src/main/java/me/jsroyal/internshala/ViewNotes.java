package me.jsroyal.internshala;

/**
 * Created by jsroyal on 16/4/17.
 */

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ViewNotes extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.viewnotes,container,false);
        TextView viewnotes =(TextView)rootview.findViewById(R.id.v_message);
        DatabaseHelper db =new DatabaseHelper(getContext());
        Cursor res = db.getAllData();
        if(res.getCount() == 0) {
            // show message
            Toast.makeText(getContext(),"Error"+"Nothing found",Toast.LENGTH_LONG).show();
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("Id :"+ res.getString(0)+"\n");
            buffer.append("Title :"+ res.getString(1)+"\n");
            buffer.append("Message :"+ res.getString(2)+"\n");
        }
        viewnotes.setText(buffer);
        return rootview;
    }
}

