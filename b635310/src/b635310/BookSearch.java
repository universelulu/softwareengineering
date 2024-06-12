package b635310;

import java.util.Arrays;


//binary search를 활용해서 책을 검색한다.

public class BookSearch {
	
	//새로운 책 함수인 search_bs를 구현한다.
	 public static Book search_bs(Book[] books, int bookId) {
	     //arrays를 import 해서 sort함수를 통해 책을 찾는다.   
		 Arrays.sort(books, (b1, b2) -> Integer.compare(b1.getId(), b2.getId()));
	        int left = 0;
	        int right = books.length - 1;

	        //이진 탐색을 수행해서 책을 찾는다.
	        while (left <= right) {
	            int midIndex = left + (right - left) / 2; //중간 인덱스를 계산한다.
	            if (books[midIndex].getId() == bookId) {
	                return books[midIndex]; //책을 찾으면 그 정보를 return 한다.
	            } else if (books[midIndex].getId() < bookId) //아이디의 크기에 따라서 인덱스를 어떻게 탐색하는지 정한다.{
	                left = midIndex + 1; //
	             else {
	                right = midIndex - 1;
	            }
	        }

	        return null; // 책을 찾지 못했을 경우, null을 return 한다.
	    }

}
