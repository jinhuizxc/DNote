package com.example.jh.dnote.dnote.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jh.dnote.R;
import com.example.jh.dnote.dnote.data.ConstantData;
import com.example.jh.dnote.dnote.model.NoteModel;
import com.example.jh.dnote.listview_lib.DragSortListView;

import java.util.List;

/**
 * Created by jinhui  on 2017/4/8
 * 邮箱: 1004260403@qq.com
 *
 * 1. 实现了listview_lib.DragSortListView的DropListener接口
 */

public class NoteAdapter extends ArrayAdapter<NoteModel> implements DragSortListView.DropListener {


    private int resourceId;

    private List<NoteModel> objects;

    public NoteAdapter(Context context, int resource, List<NoteModel> objects) {
        super(context, resource, objects);
        this.objects = objects;
        resourceId = resource;
    }

    public void setUp() {
        for (NoteModel object : objects) {
            object.setIsUp(true);
        }
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        NoteModel noteModel = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.ago_text = (TextView) view.findViewById(R.id.ago_text);
            viewHolder.time_text = (TextView) view.findViewById(R.id.time_text);
            viewHolder.summary_text = (TextView) view.findViewById(R.id.summary_text);
            viewHolder.fav_image = (ImageView) view.findViewById(R.id.fav_image);
//			viewHolder.clip_image = (ImageView) view.findViewById(R.id.clip_image);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.ago_text.setText("一天前");
        viewHolder.time_text.setText(noteModel.getNoteTime());
        if (noteModel.getNoteContent().length() > ConstantData.TITLE_LENGTH) {
            viewHolder.summary_text.setText(noteModel.getNoteContent().substring(0, ConstantData.TITLE_LENGTH));
        } else {
            viewHolder.summary_text.setText(noteModel.getNoteContent());
        }
        if (noteModel.isFav()) {
            viewHolder.fav_image.setVisibility(View.VISIBLE);
        } else {
            viewHolder.fav_image.setVisibility(View.INVISIBLE);
        }

//		if(noteModel.isUp())
//		{
//			viewHolder.clip_image.setImageResource(R.mipmap.clip_up);
//		}
//		else
//		{
//			viewHolder.clip_image.setImageResource(R.mipmap.clip_normal);
//		}
        return view;
    }

    @Override
    public void drop(int from, int to) {
        if (from != to) {
            NoteModel item = this.getItem(from);
            this.remove(item);
            this.insert(item, to);
        }
    }

    class ViewHolder {
        TextView ago_text;
        TextView time_text;
        ImageView fav_image;
        TextView summary_text;
//		ImageView clip_image;
    }


}
