package com.example.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

/**
 * Created by Нигина on 31.01.2017.
 */

public class GrantsListAdapter extends BaseAdapter {
    private ArrayList<Grant> grantsListData;  //содержит все данные об объектах
    private LayoutInflater layoutInflater;   //берет наш дизайн и применяет внутри listView

    public GrantsListAdapter(Context aContext) {
        this.grantsListData = new ArrayList<>();   //новый пустой список
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return grantsListData.size();
    }

    @Override   //даём позицию итема и он нам его возвращает
    public Object getItem(int position) {
        return grantsListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.one_grant_in_list_layout, null);
            holder = new ViewHolder();
            holder.grantNameView = (TextView) convertView.findViewById(R.id.grantTitle);
            holder.grantDescriptionView = (TextView) convertView.findViewById(R.id.grantDescription);
            holder.grantTagsView = (TextView) convertView.findViewById(R.id.grantTags);
            holder.grantDeadlineView = (TextView) convertView.findViewById(R.id.grantDeadline);
            holder.grantPlace = (TextView) convertView.findViewById(R.id.grantPlace);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.grantNameView.setText(grantsListData.get(position).getGrantName());
        holder.grantTagsView.setText(grantsListData.get(position).getTag());
        holder.grantDeadlineView.setText(grantsListData.get(position).getDeadline());
        holder.grantPlace.setText(grantsListData.get(position).getPlace());
        return convertView;   //convertView используется в ListView
    }
    //метод add (из grantsTable.java)
    public void add(Grant grant) {
        grantsListData.add(grant);
    }

    //помогает нам всё организовать  (можно и не писать)
    static class ViewHolder {
        TextView grantNameView;
        TextView grantDescriptionView;
        TextView grantTagsView;
        TextView grantDeadlineView;
        TextView grantPlace;
    }
}

