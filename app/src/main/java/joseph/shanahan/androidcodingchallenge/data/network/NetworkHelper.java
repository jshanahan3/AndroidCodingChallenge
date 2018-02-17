package joseph.shanahan.androidcodingchallenge.data.network;

import java.util.List;

import joseph.shanahan.androidcodingchallenge.data.model.Book;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by josephshanahan on 2/17/18.
 */

public class NetworkHelper {

    private static final String BASE_URL_BOOKS = "http://de-coding-test.s3.amazonaws.com/";
    private Retrofit retrofit;
    private BookService bookService;

    public NetworkHelper() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_BOOKS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        bookService = retrofit.create(BookService.class);
    }

    public Call<List<Book>> fetchBooks(){
        return bookService.listRepos();
    }

}
