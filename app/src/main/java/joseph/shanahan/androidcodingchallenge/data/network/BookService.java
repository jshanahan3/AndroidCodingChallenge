package joseph.shanahan.androidcodingchallenge.data.network;

import java.util.List;

import joseph.shanahan.androidcodingchallenge.data.model.Book;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by josephshanahan on 2/17/18.
 */

public interface BookService {
    @GET("books.json")
    Call<List<Book>> listRepos();
}
