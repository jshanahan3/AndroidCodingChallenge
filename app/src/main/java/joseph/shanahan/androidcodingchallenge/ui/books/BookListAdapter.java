package joseph.shanahan.androidcodingchallenge.ui.books;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import joseph.shanahan.androidcodingchallenge.R;
import joseph.shanahan.androidcodingchallenge.data.model.Book;


/**
 * Created by josephshanahan on 2/17/18.
 */

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {

    private static final String TAG = BookListAdapter.class.getSimpleName();
    private List<Book> bookList;
    private Context context;

    public BookListAdapter(Context context) {
        this.context = context;
        bookList = new ArrayList<Book>();
    }

    public void updateBookList(List<Book> bookList) {
        this.bookList = bookList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.books_row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = bookList.get(position);
        if (book.getTitle() != null) {
            holder.textViewTitle.setText(book.getTitle());
        } else {
            holder.textViewTitle.setText("");
        }
        if (book.getAuthor() != null) {
            holder.textViewAuthor.setText(book.getAuthor());
            holder.textViewAuthorLabel.setVisibility(View.VISIBLE);
            holder.textViewAuthor.setVisibility(View.VISIBLE);
        } else {
            holder.textViewAuthor.setText("");
            holder.textViewAuthor.setVisibility(View.GONE);
            holder.textViewAuthorLabel.setVisibility(View.GONE);
        }
        if (book.getImageURL() != null && !book.getImageURL().isEmpty()) {
            Picasso.with(context)
                    .load(book.getImageURL())
                    .into(holder.imageViewThumbnail);
        }
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public List<Book> getBookList(){
        return bookList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewThumbnail;
        public TextView textViewTitle;
        public TextView textViewAuthor;
        public TextView textViewAuthorLabel;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textview_books_title);
            textViewAuthor = itemView.findViewById(R.id.textview_books_author_value);
            textViewAuthorLabel = itemView.findViewById(R.id.textview_books_author_label);
            imageViewThumbnail = itemView.findViewById(R.id.imageview_books_thumbnail);
        }
    }
}
