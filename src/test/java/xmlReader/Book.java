package xmlReader;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/12 9:54
 * @Description version 1.0
 */
public class Book {

    private String id;
    private String name;
    private String author;
    private String year;
    private String price;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", price='" + price + '\'' +
                '}';
    }


}
