package b635310;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


//BookSearch 클래스에 대한 단위 테스트를 제공하는 BookSearchTest 클래스이다.
//이 클래스를 통해 mission에서 지정했던 bs_search 함수를 테스트한다.
class BookSearchTest {

	//유효한 책 id와 유효하지 않은 책 id를 사용해서 search_bs를 테스트한다.
	 @Test
	    public void testSearchBs() {
	     //book 베열 생성.   
		 Book[] books = {
	            new Book(1, "소프트웨어공학"),
	            new Book(2, "삼국지"),
	            new Book(3, "토익 900이상 마스터"),
	            new Book(4,"스타크래프트2 공략집")
	        };

		 //id가 2인 책이 존재하므로, 그에 대한 코드를 작성한다.
		 	System.out.println("id가 2인 책을 검색합니다.");
	        Book result = BookSearch.search_bs(books, 2);
	        assertNotNull(result); //결과가 null이 아님을 확인한다.
	        assertEquals(2, result.getId()); //책 id가 일치하는지 확인한다.
	        assertEquals("삼국지", result.getTitle()); //책 체목이 일치하는지 확인한다.
	        System.out.println("ID가 2인 책을 성공적으로 찾았습니다: " + result);

	        
	        //위의 배열에서는 id가 5인 책이 존재하지 않는다. 이에 따라 결과를 츨력한다.
	        System.out.println("ID가 5인 책을 검색합니다.");
	        Book notFound = BookSearch.search_bs(books, 5);
	        assertNull(notFound); //결과가 null임을 확인한다.
	        System.out.println("ID가 5인 책을 찾지 못했습니다.");
	    }
}
