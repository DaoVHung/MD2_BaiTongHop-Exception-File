package ra.dev;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Book implements Serializable, Comparable<Book>, IBook {
    private String bookID;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private Author author;
    private String title;
    private String content;
    private String publishing;
    private Boolean bookStatus;

    public Book() {
    }

    public Book(String bookID,
                String bookName,
                float importPrice,
                float exportPrice,
                float profit,
                int quantity,
                Author author,
                String title,
                String content,
                String publishing,
                Boolean bookStatus) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.author = author;
        this.title = title;
        this.content = content;
        this.publishing = publishing;
        this.bookStatus = bookStatus;
    }

    // ID
    public void inputIDBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Nhap ID sach : \n (5 kí tự & bat dau = B) : ");
        boolean check = true;

        while (check){
            this.bookID = sc.nextLine();
            char checkB = this.bookID.charAt(0);

            if (this.bookID.trim().length() == 5) {
                if (checkB == 'B') {
                    for (Book book : BookManagement.bookListlist) {
                        while (Objects.equals(this.bookID, book.getBookID())) {
                            System.out.println(" ID da ton tai, nhap ID khac :");
                            this.bookID= sc.nextLine();
                        }
                        check =false;
                    }
                    break;
                } else {
                    System.out.println(" Vui long bat dau = B : ");
                }
            } else {
                System.out.println(" Vui long nhap chi 5 ki tu ! Nhap lai : ");
            }
        }
    }



    // NAME
    public void inputNameBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Nhap vao ten sach : ");
        String name = sc.nextLine();
        while (name.trim().length() < 5) {
            System.out.println(" Nhap ten sach dai hon 10 ky tu ! ");
            name = sc.nextLine();
        }
        this.bookName = name;

    }

    // PRICE IMPORT
    public void inputIPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Nhap gia sach : ");

        while (true) {
            try {
                float price = Float.parseFloat(sc.nextLine());
                while (price < 0) {
                    System.out.println(" Gia phai > 0 : ");
                    price = Float.parseFloat(sc.nextLine());
                }
                this.importPrice = price;
                break;
            } catch (Exception e) {
                System.out.println(" Vui long nhap 1 so ! ");
            }
        }
    }

    // EXportPrice
    public void exportPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Nhap gia ban sach : ");
        float profi = getImportPrice() * 20 / 100;

        while (true) {
            try {
                float price = Float.parseFloat(sc.nextLine());
                while (price < getImportPrice() + (getImportPrice() * 20 / 100)) {
                    System.out.println(" Gia phai > 20% gia sach : ");
                    price = Float.parseFloat(sc.nextLine());
                }
                this.exportPrice = price;
                break;

            } catch (Exception e) {
                System.out.println(" Vui long nhap 1 so !");
            }
        }

    }

    // Quantity
    public void quantity() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Nhap so luong sach con lai : ");
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                this.quantity = number;
                break;

            } catch (Exception e) {
                System.out.println(" Vui long nhap 1 so ! ");
            }
        }
    }

    // TITLE
    public void titleBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Nhap tieu de (>30 ky tu) :");
        String str = sc.nextLine();
        while (str.length() < 5) {
            System.out.println(" Vui long nhap tieu de hon 30 ki tu !");
            str = sc.nextLine();
        }
        this.title = str;
    }

    // CONTENT
    public void contentBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Nhap nhap noi dung sach :");
        String str = sc.nextLine();
        while (str.length() < 5) {
            System.out.println(" Vui long nhap tieu de hon 30 ki tu !");
            str = sc.nextLine();
        }
        this.content = str;
    }

    // PUBLISHING
    public void publishbook() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Nhap ten nha san suat : ");
        this.publishing = sc.nextLine();
    }

    //STATUS
    public void bookStatus() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Nhap trang thai sach (true/false) : ");
        this.bookStatus = Boolean.parseBoolean(sc.nextLine());
    }

    public void inputDataBook() {
        inputIDBook();
        inputNameBook();
        inputIPrice();
        exportPrice();
        quantity();
        titleBook();
        contentBook();
        publishbook();
        bookStatus();
    }

    public float profit() {
        float profit = (getExportPrice() - getImportPrice()) * getQuantity();
        return profit;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void displayDataBook() {
        System.out.println(
                "Book :   \n" +
                        "     ID          :" + bookID + "\n" +
                        "     Name        :" + bookName + "\n" +
                        "     ImportPrice :" + importPrice + "\n" +
                        "     ExportPrice :" + exportPrice + "\n" +
                        "     Rrofit      :" + profit() + "\n" +
                        "     Quantity    :" + quantity + "\n" +
                        "     Author      :" + this.author.getAuthorName() + "\n" +
                        "     Title       :" + title + "\n" +
                        "     Publishing  :" + publishing + "\n" +
                        "     BookStatus  :" + bookStatus + "\n"
        );
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public Boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public int compareTo(Book o) {
        return (int) (this.exportPrice - o.exportPrice);
    }

    @Override
    public void inputData() {

    }

    @Override
    public void displayData() {

    }
}
