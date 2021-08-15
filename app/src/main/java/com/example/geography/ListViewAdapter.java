package com.example.geography;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    public List<Test> list = new ArrayList<>();
    public final LayoutInflater mInflater;

    public ListViewAdapter(Context context) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() { return list.size(); }
    @Override
    public Object getItem(int position) { return list.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = view != null ? view : mInflater.inflate(R.layout.nav_list_group, parent, false);

        ImageView indicator = v.findViewById( R.id.explist_indicator);
        boolean childCount = getChildrenCount(g) != 0;
        indicator.setVisibility( childCount?View.VISIBLE:View.INVISIBLE);
        if (childCount) indicator.getDrawable().setState(GROUP_STATE_SETS[isExpanded ? 1 : 0]);

        return getView(v, GROUP_NAMES[g],GROUP_ICONS[g]);
    }
    private View getView(View v, String name, int icon) {
        if (name == null || name.isEmpty()) return v;
        ((TextView) v.findViewById(R.id.name)).setText(name);
        ((ImageView) v.findViewById(R.id.icon)).setImageResource(icon);
        return v;
    }
}
