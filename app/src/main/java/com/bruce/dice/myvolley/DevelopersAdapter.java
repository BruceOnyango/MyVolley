package com.bruce.dice.myvolley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DevelopersAdapter extends RecyclerView.Adapter<DevelopersAdapter.ViewHolder> {
    //declare DeveloperList private member variable


    private List<DeveloperList> developerList;
    //context variable
    private Context mContext;
    public DevelopersAdapter(List<DeveloperList>developerList,
                             Context context){
        this.developerList=developerList;
        this.mContext=context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView login;
        public ImageView avatar_url;
        public TextView html_url;
        public LinearLayout linearLayout;
        //the constructor
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //initialize view objects
            login=itemView.findViewById(R.id.username);
            avatar_url=itemView.findViewById(R.id.imageView);
            html_url=itemView.findViewById(R.id.html_url);
            linearLayout=itemView.findViewById(R.id.linearLayout);
        }

    }

    @NonNull
    @Override
    public DevelopersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new
                ViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.developers_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DevelopersAdapter.ViewHolder holder, int position) {
        //create a variable that get the current instance of the developer in the list
        final DeveloperList currentDeveloper=developerList.get(position);
        // populate the text views and image view with data
        holder.login.setText(currentDeveloper.getLogin());
        holder.html_url.setText(currentDeveloper.getHtml_url());
        //Use the library Picasso to load images to prevent crashing..laoding images iresource intensive
        Picasso.with(mContext)
                .load(currentDeveloper.getAvatar_url())
                .into(holder.avatar_url);

    }

    @Override
    public int getItemCount() {

            //return the size of developer list
            return developerList.size();

    }
}
