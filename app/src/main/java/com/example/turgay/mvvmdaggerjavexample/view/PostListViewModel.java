package com.example.turgay.mvvmdaggerjavexample.view;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

import com.example.turgay.mvvmdaggerjavexample.R;
import com.example.turgay.mvvmdaggerjavexample.base.BaseViewModel;
import com.example.turgay.mvvmdaggerjavexample.model.Post;
import com.example.turgay.mvvmdaggerjavexample.network.PostApi;
import com.example.turgay.mvvmdaggerjavexample.view.adapter.PostListAdapter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

public class PostListViewModel extends BaseViewModel {
    private Disposable disposable;
    private ObservableField<Integer> loadingVisibility = new ObservableField<>();

    private MutableLiveData<Integer> errorMessage = new MutableLiveData<>();
    private View.OnClickListener onClickListener = view -> {
        loadPosts();
    };

    private PostListAdapter postListAdapter = new PostListAdapter();

    @Inject
    PostApi postApi;

    public PostListViewModel() {
        loadPosts();
    }

    private void loadPosts(){
        disposable = postApi.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> onRetrievePostListStart())
                .doOnTerminate(this::onRetrievePostListFinish)
                .subscribe(this::onRetrievePostListSuccess, this::onRetrievePostListError);

    }


    private void onRetrievePostListStart(){
        loadingVisibility.set(View.VISIBLE);
        errorMessage.setValue(null);
    }

    private void onRetrievePostListFinish() {
        loadingVisibility.set(View.GONE);
    }

    private void onRetrievePostListSuccess(List<Post> posts) {
        postListAdapter.updatePosts(posts);
    }

    private void onRetrievePostListError(Throwable throwable) {
        errorMessage.setValue(R.string.post_error);
        Log.e(TAG, "onRetrievePostListError: " + throwable.getMessage() );
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }

    public ObservableField<Integer> getLoadingVisibility() {
        return loadingVisibility;
    }

    public void setLoadingVisibility(int loadingVisibility) {
        this.loadingVisibility.set(loadingVisibility);
    }

    public MutableLiveData<Integer> getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(int errorMessage) {
        this.errorMessage.setValue(errorMessage);
    }

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public PostListAdapter getPostListAdapter() {
        return postListAdapter;
    }

    public void setPostListAdapter(PostListAdapter postListAdapter) {
        this.postListAdapter = postListAdapter;
    }
}
