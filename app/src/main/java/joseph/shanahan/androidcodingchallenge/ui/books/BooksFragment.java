package joseph.shanahan.androidcodingchallenge.ui.books;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import joseph.shanahan.androidcodingchallenge.ChallengeApplication;
import joseph.shanahan.androidcodingchallenge.R;
import joseph.shanahan.androidcodingchallenge.data.model.Book;

/**
 * Created by josephshanahan on 2/17/18.
 */

public class BooksFragment extends Fragment implements BooksContract.View {

    private static final String TAG = BooksFragment.class.getSimpleName();
    private RecyclerView recyclerView;
    private BookListAdapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    private FloatingActionButton fabRefresh;
    private BooksContract.Presenter presenter;
    private List<Book> mostRecentBooks;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.loadBooks();
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (mostRecentBooks != null) {
            showBooks(mostRecentBooks);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.books_fragment, container, false);
        recyclerView = root.findViewById(R.id.recyclerview_books_fragment);
        recyclerViewLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerViewAdapter = new BookListAdapter(getActivity());
        recyclerView.setAdapter(recyclerViewAdapter);
        fabRefresh = root.findViewById(R.id.fab_books_refresh);
        fabRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick()");
                Snackbar.make(getView(), "Fetching Books", Snackbar.LENGTH_SHORT).show();
                presenter.loadBooks();
            }
        });
        //inject the DataManager from the Application
        presenter = new BooksPresenter(this, ((ChallengeApplication) getActivity().getApplication()).getDataManager());
        return root;
    }

    @Override
    public void showBooks(List<Book> books) {
        Log.d(TAG, "showBooks(), size: " + books.size());
        recyclerViewAdapter.updateBookList(books);
        this.mostRecentBooks = books;
    }

    @Override
    public void showError() {
        Snackbar.make(getView(), "Error fetching books - Check Network Connection", Snackbar.LENGTH_LONG).show();
    }

}
