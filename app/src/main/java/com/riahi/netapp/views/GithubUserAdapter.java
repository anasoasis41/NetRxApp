package com.riahi.netapp.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.RequestManager;
import com.riahi.netapp.R;
import com.riahi.netapp.models.GithubUser;

import java.util.List;

/**
 * Created by iSDT-Anas on 24/04/2018.
 */

public class GithubUserAdapter extends RecyclerView.Adapter<GithubUserViewHolder> {

    // FOR DATA
    private List<GithubUser> githubUsers;

    // Declaring a Glide object
    private RequestManager glide;

    // 1 - Create interface for callback
    public interface Listener {
        void onClickDeleteButton(int position);
    }

    // 2 - Declaring callback
    private final Listener callback;

    // CONSTRUCTOR
    public GithubUserAdapter(List<GithubUser> githubUsers, RequestManager glide, Listener callback) {
        this.githubUsers = githubUsers;
        this.glide = glide;
        this.callback = callback;
    }

    @Override
    public GithubUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // CREATE VIEW HOLDER AND INFLATING ITS XML LAYOUT
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_main_item, parent, false);

        return new GithubUserViewHolder(view);
    }

    // UPDATE VIEW HOLDER WITH A GITHUBUSER
    @Override
    public void onBindViewHolder(GithubUserViewHolder viewHolder, int position) {
        viewHolder.updateWithGithubUser(this.githubUsers.get(position), this.glide, this.callback);
    }

    // RETURN THE TOTAL COUNT OF ITEMS IN THE LIST
    @Override
    public int getItemCount() {
        return this.githubUsers.size();
    }

    public GithubUser getUser(int position){
        return this.githubUsers.get(position);
    }
}
