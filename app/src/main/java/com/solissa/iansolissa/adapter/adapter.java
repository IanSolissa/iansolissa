package com.solissa.iansolissa.adapter;

import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.solissa.iansolissa.R;
import com.solissa.iansolissa.model.data;

import java.util.List;

public class adapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<data> lists;

    public adapter(Activity activity, List<data> lists) {
        this.activity = activity;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(inflater ==null)
    {
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
        if(view==null && inflater !=null){
            view=inflater.inflate(R.layout.list_user,null);
        }

        if(view!=null) {

            TextView name_profile = view.findViewById(R.id.textname);
            TextView email_profile = view.findViewById(R.id.textemail);


//            TextView name_profile = view.findViewById(R.id.text_name_profile);
//            TextView email_profile = view.findViewById(R.id.text_email_profile);
//            TextView alamat_profile = view.findViewById(R.id.text_alamat_profile);
//            TextView project_profile = view.findViewById(R.id.text_project_profile);

            data data = lists.get(i);

            name_profile.setText(data.getName());
            email_profile.setText(data.getEmail());

//            alamat_profile.setText(data.getName()); // boleh hapus
//            project_profile.setText(data.getName()); // boleh hapus
        }
return view;
}
}
