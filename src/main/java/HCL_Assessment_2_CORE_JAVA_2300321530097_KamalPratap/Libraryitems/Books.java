package HCL_Assessment_2_CORE_JAVA_2300321530097_KamalPratap.Libraryitems;

public abstract class Books {
    public String bookName;
    public int bookId;
    public int CountOfBooks;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCountOfBooks() {
        return CountOfBooks;
    }

    public void setCountOfBooks(int countOfBooks) {
        CountOfBooks = countOfBooks;
    }
}
