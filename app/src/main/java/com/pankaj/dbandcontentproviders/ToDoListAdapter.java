package com.pankaj.dbandcontentproviders;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pankaj.dbandcontentproviders.data.ToDoContract.ToDoEntry;

/**
 * Created by pankaj on 22/03/17.
 */

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ViewHolder> {

    private Cursor mCursor;
    private Context mContext;

    public ToDoListAdapter(Context mContext, Cursor mCursor) {
        this.mCursor = mCursor;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_to_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(!mCursor.moveToPosition(position))
            return;
        String name = mCursor.getString(mCursor.getColumnIndex(ToDoEntry.COLUMN_NAME));
        String status = mCursor.getString(mCursor.getColumnIndex(ToDoEntry.COLUMN_STATUS));

        holder.mName.setText(name);
        holder.mStatus.setText(status);

    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView mName;
        TextView mStatus;

        public ViewHolder(View itemView) {
            super(itemView);
            mName = (TextView)itemView.findViewById(R.id.name);
            mStatus = (TextView)itemView.findViewById(R.id.status);
        }
    }
}
