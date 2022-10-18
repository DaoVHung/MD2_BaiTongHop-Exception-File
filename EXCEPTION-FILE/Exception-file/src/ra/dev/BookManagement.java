package ra.dev;

import java.io.*;
import java.util.*;

public class BookManagement {

    static List<Author> authorList = new ArrayList<>();
    static List<Book> bookListlist = new ArrayList<>();

    public static void main(String[] args) {
//        getDataBook(bookListlist,"Books.txt");
//        getData(authorList, "Authors.txt");

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("   ");
            System.out.println("***** QUAN LY CUA HANG SACH *****");
            System.out.println("1. Quan ly tac gia .");
            System.out.println("2. Quan ly sach .");
            System.out.println("3. Thoat.");
            System.out.println(" ");
            System.out.println(" Nhap lua chon cua ban : ");
            try {
                int pick = Integer.parseInt(sc.nextLine());
                switch (pick) {
                    case 1:
                        BookManagement.authorManagement();
                        break;
                    case 2:
                        BookManagement.bookManagement();
                        break;
                    case 3:
                        break;
                    case 4:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Hay nhap 1 so : ");
            }

        } while (true);

    }//END VOI MAIN

    public static void authorManagement() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("   ");
            System.out.println("****** QUAN LY TAC GIA ******");
            System.out.println("1. Them tac gia .");
            System.out.println("2. Danh sach tac gia .");
            System.out.println("3. Cap nhat thong tin tac gia .");
            System.out.println("4. Cap nhat trang thai tac gia .");
            System.out.println("5. Thoat !");
            System.out.println(" \n Nhap lua chon cua ban : ");
            try {
                int pick2 = Integer.parseInt(sc.nextLine());
                switch (pick2) {
                    case 1:
                        System.out.print("Nhap so tac gia muon them : ");
                        List<Author>add= new ArrayList<>();
                        int numAuthor = Integer.parseInt(sc.nextLine());
                        for (int i = 0; i < numAuthor; i++) {
                            Author author = new Author();
                            author.inputData();
                            authorList.add(author);
                            add.add(author);

                        }
//                        insertData(authorList, "Authors.txt",false);
                        insertData(add,"Authors.txt",true);

                        break;
                    case 2:
                        System.out.println("Danh sach tac gia la : ");
                        authorList= getData( "D:\\MD-2\\EXCEPTION-FILE\\Authors.txt");

                        for (Author at:authorList)
                        {
                            at.displayData();

                        }
                        break;
                    case 3:
                        System.out.println("Nhập vào ID tác giả muốn cập nhật : ");
                        getData( "D:\\MD-2\\EXCEPTION-FILE\\Authors.txt");
                        int id = Integer.parseInt(sc.nextLine());
                        for (Author at : authorList) {
                            if (id == at.getAuthorID()) {
                                System.out.println("Nhập tên tác giả : \n 1.Cập nhât. \n 2.Bỏ qua. \n");
                                int pick3 = Integer.parseInt(sc.nextLine());
                                if (pick3 == 1) {
                                    at.inputName();
                                }
                            }
                        }
                        insertData(authorList,"Authors.txt",false);
                        break;
                    case 4:
                        System.out.println("Nhập vào ID tác giả muốn cập nhật : ");
                        getData("D:\\MD-2\\EXCEPTION-FILE\\Authors.txt");
                        int id2 = Integer.parseInt(sc.nextLine());
                        for (Author at2 : authorList) {
                            if (id2 == at2.getAuthorID()) {
                                System.out.println("Nhập trạng thái mới : \n 1.Cập nhât. \n 2.Bỏ qua. \n");
                                int pick4 = Integer.parseInt(sc.nextLine());
                                if (pick4 == 1) {
                                    at2.inputStatus();
                                }
                            }
                        }
                        insertData(authorList,"Authors.txt",false);
                        break;
                    case 5:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Vui long nhap 1 so !");
            }

        } while (true);
    }

    public static void bookManagement() {
        Scanner sc = new Scanner(System.in);
        getData("D:\\MD-2\\EXCEPTION-FILE\\Authors.txt");
        do {
            System.out.println(" ");
            System.out.println("1. Them cac sach. ");
            System.out.println("2. Danh sach cac sach. ");
            System.out.println("3. Cap nhat thong tin sach. ");
            System.out.println("4. Cap nhat trang thai sach. ");
            System.out.println("5. Tinh loi nhuan sach. ");
            System.out.println("6. Sap xep sach theo gia ban tang dan. ");
            System.out.println("7. Tim kiem sach theo ten sach, ten tac gia. ");
            System.out.println("8. Ban sach.");
            System.out.println("9. Thoat !");
            System.out.println(" ");
            try {
                int pick = Integer.parseInt(sc.nextLine());
                switch (pick) {
                    case 1:
                        System.out.println(" Nhap ID tac gia ban muon them ");
                       authorList= getData("D:\\MD-2\\EXCEPTION-FILE\\Authors.txt");
                        for (Author at2 : authorList) {
                            System.out.println("       ID : " + at2.getAuthorID() + " : " + at2.getAuthorName());
                        }
                        int idAthor = Integer.parseInt(sc.nextLine());
                        for (Author at2 : authorList) {
                            if (idAthor == at2.getAuthorID()) {

                                System.out.print(" Nhap so sach muon them : ");
                                try {
                                    int numBook = Integer.parseInt(sc.nextLine());
                                    for (int i = 0; i < numBook; i++) {
                                        Book book = new Book();
                                        book.inputDataBook();
                                        book.setAuthor(at2);
                                        bookListlist.add(book);
                                    }
                                } catch (Exception e) {
                                    System.out.println("Hay nhap vao 1 so ! Nhap lai : ");
                                }

                            } else {
                                System.out.println("Ko co tac gia trong danh sach!\n Vui long nhap lai .");
                            }
                        }
                        insertDataBook(bookListlist,"Books.txt");
                        break;
                    case 2:
                        System.out.println("Thong tin cac sach la : ");
                        bookListlist = getDataBook("Books.txt");
                        for (Book bo : bookListlist){
                            bo.displayDataBook();
                        }
                        insertDataBook(bookListlist,"Books.txt");



                        break;
                    case 3:
                        System.out.println("Nhap ID sach muon cap nhat : ");
                        for (Book book : bookListlist) {
                            System.out.println("ID : " + book.getBookID() + " Name : " + book.getBookName());
                        }
                        String idBook = sc.nextLine();
                        for (Book book : bookListlist) {
                            if (Objects.equals(idBook, book.getBookID())) {
                                System.out.println("Cap nhat ID : \n 1. Co. \n 2.Khong. ");
                                int P1 = Integer.parseInt(sc.nextLine());
                                if (P1 == 1) {
                                    System.out.print("Nhap ID sach : \n (5 kí tự & bat dau = B) : ");
                                    boolean check = true;
                                    while (check) {
                                        String bookID = sc.nextLine();
                                        char checkB = bookID.charAt(0);

                                        if (bookID.trim().length() == 5) {
                                            if (checkB == 'B') {
                                                for (Book bookCheck : bookListlist) {
                                                    while (bookID == bookCheck.getBookID()) {
                                                        System.out.println("ID da ton tai, nhap ID khac :");
                                                        bookID = sc.nextLine();
                                                    }
                                                    book.setBookID(bookID);
                                                    check = false;
                                                }
                                                break;
                                            } else {
                                                System.out.println("Vui long bat dau = B : ");
                                            }
                                        } else {
                                            System.out.println("Vui long nhap chi 5 ki tu ! Nhap lai : ");
                                        }
                                    }
                                }
                                System.out.println("Cap nhat ten sach : \n 1. Co. \n 2.Khong. ");
                                int P2 = Integer.parseInt(sc.nextLine());
                                if (P2 == 1) {
                                    book.inputNameBook();
                                }
                                System.out.println("Cap nhat gia nhap : \n 1. Co. \n 2.Khong. ");
                                int P3 = Integer.parseInt(sc.nextLine());
                                if (P3 == 1) {
                                    book.inputIPrice();
                                }
                                System.out.println("Cap nhat gia ban : \n 1. Co. \n 2.Khong. ");
                                int P4 = Integer.parseInt(sc.nextLine());
                                if (P4 == 1) {
                                    book.exportPrice();
                                }
                                System.out.println("Cap nhat so luon sach : \n 1. Co. \n 2.Khong. ");
                                int P5 = Integer.parseInt(sc.nextLine());
                                if (P5 == 1) {
                                    book.quantity();
                                }
                                System.out.println("Cap nhat tieu de : \n 1. Co. \n 2.Khong. ");
                                int P6 = Integer.parseInt(sc.nextLine());
                                if (P6 == 1) {
                                    book.titleBook();
                                }
                                System.out.println("Cap nhat nha phat hanh : \n 1. Co. \n 2.Khong. ");
                                int P7 = Integer.parseInt(sc.nextLine());
                                if (P7 == 1) {
                                    book.publishbook();
                                }
                            }
                        }
                        insertDataBook(bookListlist,"Books.txt");

                        break;
                    case 4:
                        System.out.println("Nhap ID sach muon cap nhat trang thai : ");
                        for (Book book : bookListlist) {
                            System.out.println("ID : " + book.getBookID() + " Name : " + book.getBookName());
                        }
                        String idBookStatus = sc.nextLine();
                        for (Book book : bookListlist) {
                            if (Objects.equals(idBookStatus, book.getBookID())) {
                                if (book.getBookStatus()) {
                                    book.setBookStatus(false);
                                } else {
                                    book.setBookStatus(true);
                                }
                            }
                        }
                        insertDataBook(bookListlist,"Books.txt");

                        System.out.println("Da cap nhat lai trang thai !");
                        break;
                    case 5:
                        System.out.println("Tong loi nhuan khi ban sac sach la: ");

                        for (Book book : bookListlist) {
                            float sumProfit = 0;
                            sumProfit += book.profit();
                            System.out.println(book.getBookName() + "         : " + sumProfit);
                        }
                        insertDataBook(bookListlist,"Books.txt");

                        break;
                    case 6:
                        System.out.println("Danh sach theo gia tang dan : ");
                        Collections.sort(bookListlist);
                        for (Book book : bookListlist) {
                            System.out.println(" ID    : " + book.getBookID() +
                                    " Name  : " + book.getBookName() +
                                    " Price : " + book.getExportPrice());
                        }
                        insertDataBook(bookListlist,"Books.txt");

                        break;
                    case 7:
                        System.out.println("Nhap ten sach hoac tac gia muon tim kiem : ");
                        String bookOrAuthor = sc.nextLine();
                        for (Book bookSearch : bookListlist) {
                            if (Objects.equals(bookOrAuthor, bookSearch.getBookName())) {
                                bookSearch.displayDataBook();
                            } else {
                                for (Author authorSearch : authorList) {
                                    if (Objects.equals(bookOrAuthor, authorSearch.getAuthorName())) {
                                        bookSearch.displayDataBook();
                                    } else {
                                        System.out.println("Khong co thong tin !");
                                    }
                                }
                            }
                        }
                        insertDataBook(bookListlist,"Books.txt");

                        break;
                    case 8:
                        System.out.println("   Nhap ID sach muon ban : ");
                        for (Book bk : bookListlist) {
                            System.out.println("       ID : " + bk.getBookID() + " : " + bk.getBookName());
                        }

                        String book = sc.nextLine();
                        for (Book bk : bookListlist) {
                            if (Objects.equals(book, bk.getBookID())) {
                                System.out.println("Nhap so sach muon ban : ");
                                do {
                                    try {
                                        int sell = Integer.parseInt(sc.nextLine());
                                        while (sell > bk.getQuantity()) {
                                            System.out.println("San pham ton ko du ban ! nhap lai :");
                                            sell = Integer.parseInt(sc.nextLine());
                                        }
                                        bk.setQuantity(bk.getQuantity() - sell);
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Nhap 1 so ! ");
                                    }

                                } while (true);
                            }
                        }
                        insertDataBook(bookListlist,"Books.txt");

                        System.out.println("Ban thanh cong !");
                        break;

                    case 9:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Vui long nhap 1 so !.");
            }
        } while (true);
    }

    // READ & WRITE AUTHOR
    public static void insertData(List<Author> authorList, String path, boolean append) {
        File file = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            file = new File(path);
            fos = new FileOutputStream(file, append);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(authorList);
            System.out.println(" ---- XONG! ----");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
    public static void insertDataBook(List<Book> bookListList, String path) {
        File file = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            file = new File(path);
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(bookListList);
            System.out.println("---- XONG! ----");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(fos !=null){
                    fos.close();
                }
                if(oos != null){
                    oos.close();
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }




    public static List<Author> getData(String path) {
        List<Author> authorList = new ArrayList<>();
        File file = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            file = new File(path);
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            authorList = (List<Author>) ois.readObject();


        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
        return authorList;
    }


    // READ AND WRITE BOOK
    public static List<Book> getDataBook(String path) {
        List<Book>bookList=new ArrayList<>();
        File file = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            file = new File(path);
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            bookList = (List<Book>) ois.readObject();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
        return bookList;
    }

}//END MAIN
