package joseph.shanahan.androidcodingchallenge.data.model;

/**
 * Created by josephshanahan on 2/17/18.
 */

public class Book {

    private String title;
    private String author;
    private String imageURL;

    public Book(String title, String author, String imageURL) {
        this.title = title;
        this.author = author;
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
