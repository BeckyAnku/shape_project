public class LibraryDemo {

    public static void main(String[] args) {
        Library cityLibrary = new Library();

        cityLibrary.addBook(new Book("B11", "Learning Java", "Grace Kim"));
        cityLibrary.addBook(new Book("B12", "Web Design"));
        cityLibrary.addBook(new Book("B13", "Data Structures", "Peter Long"));

        cityLibrary.registerMember(new Member("S01", "Daniel"));
        cityLibrary.registerMember(new Member("S02", "Sarah"));

        System.out.println("STARTING LIBRARY INFORMATION");
        System.out.println(cityLibrary);

        cityLibrary.lendBook("B11", "S01", "17-06-2026", "01-07-2026");
        cityLibrary.lendBook("B13", "S02", "18-06-2026", "02-07-2026");
        cityLibrary.lendBook("B11", "S02", "19-06-2026", "03-07-2026");

        System.out.println();
        System.out.println("AFTER BORROWING");
        System.out.println(cityLibrary);

        cityLibrary.returnBook("B11");

        System.out.println();
        System.out.println("AFTER RETURNING BOOK B11");
        System.out.println(cityLibrary);

        Book result = cityLibrary.searchBookByTitle("Web Design");
        System.out.println("Searching for Web Design:");
        System.out.println(result);
    }
}
