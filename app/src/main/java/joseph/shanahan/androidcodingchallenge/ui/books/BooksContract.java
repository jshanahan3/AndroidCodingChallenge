package joseph.shanahan.androidcodingchallenge.ui.books;

import java.util.List;

import joseph.shanahan.androidcodingchallenge.data.model.Book;

/**
 * Created by josephshanahan on 2/17/18.
 */

public interface BooksContract {

    public interface View {
        void showBooks(List<Book> books);
        void showError();
    }

    public interface Presenter {
        void loadBooks();
    }

}
