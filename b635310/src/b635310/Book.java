package b635310;


public class Book {

	private int id; 
    private String title; 

    
    public Book(int id, String title) // Book 클래스 생성자
    {
        this.id = id;
        this.title = title;
    }

    public int getId() 
    {
        return id;
    }

    public String getTitle() 
    {
        return title;
    }

    @Override
    public String toString() 
    {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
