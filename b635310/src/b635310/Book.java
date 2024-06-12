package b635310;

//고유 id와 제목을 가진 책을 나타낸다.

//함수에서 쓰이는 클래스이다.
public class Book {

	private int id; //책 아이디(고유 식별자)
    private String title; //책의 제목

    //새로운 book 객체를 생성한다.
    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    //아이디(고유 식별자)를 반환한다.
    public int getId() {
        return id;
    }

    //책의 제목을 반환한다.
    public String getTitle() {
        return title;
    }

    //책의 아이디, 제목을 return 한다.
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
