package joseph.shanahan.androidcodingchallenge.data;

import java.util.List;

import joseph.shanahan.androidcodingchallenge.data.model.Book;
import joseph.shanahan.androidcodingchallenge.data.network.NetworkHelper;
import retrofit2.Call;

/**
 * Created by josephshanahan on 2/17/18.
 */

public class DataManager {

    private NetworkHelper networkHelper;

    public DataManager(){
        networkHelper = new NetworkHelper();
    }

    public Call<List<Book>> fetchBooksFromNetwork(){
        return networkHelper.fetchBooks();
    }

}
