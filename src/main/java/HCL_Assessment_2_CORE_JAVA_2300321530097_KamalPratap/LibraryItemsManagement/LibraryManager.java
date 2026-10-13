package HCL_Assessment_2_CORE_JAVA_2300321530097_KamalPratap.LibraryItemsManagement;

import HCL_Assessment_2_CORE_JAVA_2300321530097_KamalPratap.AdminController.Admin;
import HCL_Assessment_2_CORE_JAVA_2300321530097_KamalPratap.Libraryitems.Books;
import HCL_Assessment_2_CORE_JAVA_2300321530097_KamalPratap.Libraryitems.DVD;
import HCL_Assessment_2_CORE_JAVA_2300321530097_KamalPratap.Libraryitems.Magazine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LibraryManager implements Admin {
    HashMap<Integer, Books> booksList = new HashMap<>();
    List<DVD> dvdList = new ArrayList<>();
    List<Magazine> magazineList = new ArrayList<>();

    @Override
    public void addBook(int id,String bookName,int bookCount){
        Books book = new Books(){
            @Override
            public void setBookName(String bookName){
                super.setBookName(bookName){
                }
            }

            @Override
            public void setBookId(int bookId){
                super.setBookId(bookId);
            }

            @Override
            public void setCountOfBooks(int countOfBooks) {
                super.setCountOfBooks(countOfBooks);
            }
        };
        booksList.add(book);
    }

    @Override
    public void addMagazine(int bookId, String magazineName, int magazineCount) {

    }

    @Override
    public void register(int bookId, String StudentName) {

    }

    @Override
    public void deleteBook(int bookId) {
        if(booksList.containsKey(bookId)){
            Books b = booksList.get(bookId);
            b.setCountOfBooks(b.getCountOfBooks() - 1);
            booksList.put(bookId,b);
            if(b.getCountOfBooks() == 0){
                booksList.remove(bookId);
            }
        }else{

        }
    }

}
