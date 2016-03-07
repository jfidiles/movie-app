package com.example.jimmy.scroolableview;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jimmy.scroolableview.adapter.MovieAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jimmy on 3/5/2016.
 */
public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private MovieAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerview);


        String[] movieId1 = {"image1", "image2", "image3", "image4", "image5", "image6", "image7"};
        String[] movieId2 = {"img1", "image2", "img3", "image4", "image5", "image6", "image7"};

        //url
        String url1 = "http://ia.media-imdb.com/images/M/MV5BNjExODg3MDUzNl5BMl5BanBnXkFtZTgwNjExMjE3NzE@._V1_UX140_CR0,0,140,209_AL_.jpg";
        String url2 = "http://ia.media-imdb.com/images/M/MV5BMTUyNzgxNjg2M15BMl5BanBnXkFtZTgwMTY1NDI1NjE@._V1_UY209_CR0,0,140,209_AL_.jpg";
        String url3 = "http://ia.media-imdb.com/images/M/MV5BMTAzNjQ1Mzk2MjNeQTJeQWpwZ15BbWU4MDU0MDk1Mjcx._V1_UY209_CR0,0,140,209_AL_.jpg";
        String url4 = "http://ia.media-imdb.com/images/M/MV5BMTAzNjQ1Mzk2MjNeQTJeQWpwZ15BbWU4MDU0MDk1Mjcx._V1_UY209_CR0,0,140,209_AL_.jpg";
        String url5 = "http://ia.media-imdb.com/images/M/MV5BMTUxOTc5MTU1NF5BMl5BanBnXkFtZTgwODYyNTA1NzE@._V1_UY209_CR0,0,140,209_AL_.jpg";
        String url6 = "http://ia.media-imdb.com/images/M/MV5BNzI4MDMwMzUwNF5BMl5BanBnXkFtZTgwMDgyNzkyNzE@._V1_UY209_CR0,0,140,209_AL_.jpg";
        String url7 = "http://ia.media-imdb.com/images/M/MV5BMTY4MTU2NjMyNV5BMl5BanBnXkFtZTgwMzUwMDk4NzE@._V1_UY209_CR0,0,140,209_AL_.jpg";

        //url
        ArrayList<String> URLs = new ArrayList<>();
        URLs.add("http://ia.media-imdb.com/images/M/MV5BMjIxOTIzMTM5OF5BMl5BanBnXkFtZTgwNDIxNTA1NzE@._V1_SX148_CR0,0,148,219_AL_.jpg");
        URLs.add("http://ia.media-imdb.com/images/M/MV5BODVmMDQ4M2YtNDQ1ZS00N2E3LWEzMjQtNzYxYTlkM2U4MGFmXkEyXkFqcGdeQXVyNjEwNTM2Mzc@._V1_SY219_CR8,0,148,219_AL_.jpg");
        URLs.add("http://ia.media-imdb.com/images/M/MV5BMjEzMjczOTIxMV5BMl5BanBnXkFtZTgwOTUwMjI3NzE@._V1_SX148_CR0,0,148,219_AL_.jpg");
        URLs.add("http://ia.media-imdb.com/images/M/MV5BMjQyOTcwODIyNF5BMl5BanBnXkFtZTgwMDE4OTI4NzE@._V1_SX148_CR0,0,148,219_AL_.jpg");
        URLs.add("http://ia.media-imdb.com/images/M/MV5BOTMyMjEyNzIzMV5BMl5BanBnXkFtZTgwNzIyNjU0NzE@._V1_UY209_CR0,0,140,209_AL_.jpg");
        URLs.add("http://ia.media-imdb.com/images/M/MV5BMTY1ODY2MTgwM15BMl5BanBnXkFtZTgwOTY3Nzc3NzE@._V1_UY209_CR0,0,140,209_AL_.jpg");
        URLs.add("http://ia.media-imdb.com/images/M/MV5BMjQyODg5Njc4N15BMl5BanBnXkFtZTgwMzExMjE3NzE@._V1_UY209_CR1,0,140,209_AL_.jpg");

        String[] image = {url1, url2, url3, url4, url5, url6, url7};
        String[] image2 = {URLs.get(0), URLs.get(1), URLs.get(2), URLs.get(3), URLs.get(4), URLs.get(5), URLs.get(6)};
        List<MovieList> data = new ArrayList<>();
        data.add(new MovieList("Horror", movieId1, image));
        data.add(new MovieList("Comedy", movieId2,image2));
        data.add(new MovieList("Anime", movieId1, image));
        data.add(new MovieList("Action", movieId2, image));

        adapter = new MovieAdapter(getActivity(), data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }
}
