package com.example.turgay.mvvmdaggerjavexample.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.turgay.mvvmdaggerjavexample.R;
import com.example.turgay.mvvmdaggerjavexample.databinding.ItemPostBinding;
import com.example.turgay.mvvmdaggerjavexample.model.Post;
import com.example.turgay.mvvmdaggerjavexample.view.PostViewModel;

import java.util.List;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.ViewHolder> {
    private List<Post> posts;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        ItemPostBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_post,viewGroup,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int index) {
        viewHolder.bind(posts.get(index));
    }

    @Override
    public int getItemCount() {
        return posts == null ? 0: posts.size();
    }

    public void updatePosts(List<Post> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ItemPostBinding binding;

        private PostViewModel postViewModel = new PostViewModel();

        public ViewHolder(ItemPostBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


        public void bind(Post post){
            postViewModel.bind(post);
            binding.setViewModel(postViewModel);
        }
    }
}
