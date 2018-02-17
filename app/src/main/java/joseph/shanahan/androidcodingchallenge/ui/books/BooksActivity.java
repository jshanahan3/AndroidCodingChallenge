package joseph.shanahan.androidcodingchallenge.ui.books;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import joseph.shanahan.androidcodingchallenge.R;

public class BooksActivity extends AppCompatActivity {

    private static final String TAG_RETAINED_FRAGMENT = "RETAINED_FRAGMENT";
    private BooksFragment booksFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.books_activity);
        booksFragment = (BooksFragment) getSupportFragmentManager().findFragmentByTag(TAG_RETAINED_FRAGMENT);
        if (booksFragment == null) {
            booksFragment = new BooksFragment();
            getSupportFragmentManager()
                    .beginTransaction().add(R.id.constraintlayout_books, booksFragment, TAG_RETAINED_FRAGMENT)
                    .commit();
        }
    }
}
