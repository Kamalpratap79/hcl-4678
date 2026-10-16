package HCL_Assessment_2_CORE_JAVA_2300321530097_KamalPratap.AdminController;

public interface Admin {

    void addBook(int bookId,String bookName,int bookCount);
    void addMagazine(int bookId,String bookName,int bookCount);
    void register(int bookId,String StudentName);
    void deleteBook(int bookId);
    void assignBook(int bookid,int StudentId);

    void showBooks();
}
