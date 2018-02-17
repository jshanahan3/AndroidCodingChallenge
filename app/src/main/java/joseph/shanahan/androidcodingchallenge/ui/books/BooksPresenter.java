package joseph.shanahan.androidcodingchallenge.ui.books;

import android.support.design.widget.Snackbar;
import android.util.Log;

import java.util.List;

import joseph.shanahan.androidcodingchallenge.data.DataManager;
import joseph.shanahan.androidcodingchallenge.data.model.Book;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by josephshanahan on 2/17/18.
 */

public class BooksPresenter implements BooksContract.Presenter {

    private static final String TAG = BooksPresenter.class.getSimpleName();
    private DataManager dataManager;
    private BooksContract.View view;

    public BooksPresenter(BooksContract.View view, DataManager dataManager) {
        this.view = view;
        this.dataManager = dataManager;
    }

    @Override
    public void loadBooks() {
        dataManager.fetchBooksFromNetwork().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                Log.d(TAG, "onResponse(), bookCount: " + response.body().size());
                view.showBooks(response.body());
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Log.e(TAG, "onFailure() during fetchBooksFromNetwork()", t);
                view.showError();
            }
        });
    }
}
