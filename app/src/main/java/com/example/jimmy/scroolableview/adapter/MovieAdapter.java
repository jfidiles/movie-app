package com.example.jimmy.scroolableview.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jimmy.scroolableview.MovieList;
import com.example.jimmy.scroolableview.R;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Jimmy on 3/6/2016.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.GetViewHolder> {
    Context context;
    List<MovieList> data;
    LayoutInflater inflater;

    public MovieAdapter (Context context, List<MovieList> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public GetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row_movie, parent, false);
        return new GetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GetViewHolder holder, final int position) {
        String title = data.get(position).title;
        holder.txtCategory.setText(title);

        //set image background
        new DownloadImageTask(holder.ivIcon1).execute(data.get(position).imageUrl[0]);
        new DownloadImageTask(holder.ivIcon2).execute(data.get(position).imageUrl[1]);
        new DownloadImageTask(holder.ivIcon3).execute(data.get(position).imageUrl[2]);
        new DownloadImageTask(holder.ivIcon4).execute(data.get(position).imageUrl[3]);
        new DownloadImageTask(holder.ivIcon5).execute(data.get(position).imageUrl[4]);
        new DownloadImageTask(holder.ivIcon6).execute(data.get(position).imageUrl[5]);
        new DownloadImageTask(holder.ivIcon7).execute(data.get(position).imageUrl[6]);

        holder.ivIcon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, data.get(position).movieId[0], Toast.LENGTH_SHORT).show();
            }
        });

        holder.ivIcon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, data.get(position).movieId[2], Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    protected class GetViewHolder extends RecyclerView.ViewHolder {
        TextView txtCategory;
        ImageView ivIcon1, ivIcon2, ivIcon3, ivIcon4, ivIcon5, ivIcon6, ivIcon7;
        public GetViewHolder(View itemView) {
            super(itemView);
            txtCategory = (TextView)itemView.findViewById(R.id.txtCategory);
            ivIcon1 = (ImageView)itemView.findViewById(R.id.ivIcon1);
            ivIcon2 = (ImageView)itemView.findViewById(R.id.ivIcon2);
            ivIcon3 = (ImageView)itemView.findViewById(R.id.ivIcon3);
            ivIcon4 = (ImageView)itemView.findViewById(R.id.ivIcon4);
            ivIcon5 = (ImageView)itemView.findViewById(R.id.ivIcon5);
            ivIcon6 = (ImageView)itemView.findViewById(R.id.ivIcon6);
            ivIcon7 = (ImageView)itemView.findViewById(R.id.ivIcon7);
        }
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon;
        }

        protected void onPostExecute(Bitmap result) {
            BitmapDrawable drawable = new BitmapDrawable(Resources.getSystem(), result);
            bmImage.setBackground(drawable);
        }
    }
}
