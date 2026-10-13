package HCL_Assessment_2_CORE_JAVA_2300321530097_KamalPratap;

import HCL_Assessment_2_CORE_JAVA_2300321530097_KamalPratap.LibraryItemsManagement.LibraryManager;

import java.util.Scanner;

public class Library extends LibraryManager {
    static void main(){
        Scanner sc = new Scanner(System.in);
        System.out.println("LIBRARY Mangement System");
        LibraryManager admin = new Library();
        admin.addBook(1,"Maths",10);
        System.out.println(admin.booksList);

        System.out.println("1 - for adding Books");
        System.out.println("2 - for deleting Books");
        System.out.println("1 - for Assigning books");
        System.out.println("1 - for Assigning magazine");

        boolean flag = true;
        while(flag){
            System.out.println("Enter options");
            int option = sc.nextInt();
            switch (option){
                case 1: {
                    LibraryManager admin = new Library();
                    System.out.println("Enter book id:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the book name:");
                    String bookName = sc.nextLine();
                    System.out.println("Enter the book count");
                    int countOfBooks = sc.nextInt();
                    admin.addBook(id,bookName,countOfBooks);
                    break;
                }
                    case 2 : {
                        LibraryManager admin = new Library();
                        System.out.print("Enter book id which you want to remove : ");
                        int id = sc.nextInt();
                        admin.deleteBook(id);
                        break;
                    }
                    case 3 :{
                        LibraryManager admin = new Library();
                        admin.showBooks();
                    }
                    default:
                        System.out.println("Exiting the System");
                        flag = false;

            }
        }


    }
}
