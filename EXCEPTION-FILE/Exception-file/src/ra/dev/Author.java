package ra.dev;
import java.util.Scanner;
import java.io.Serializable;
public class Author implements Serializable,IBook {
    private int authorID;
    private String authorName;
    private Boolean authorStatus;
    public Author() {
    }
    public Author(int authorID, String authorName, Boolean authorStatus) {
        this.authorID = authorID;
        this.authorName = authorName;
        this.authorStatus = authorStatus;
    }

    public void setInputID(){
        this.authorID = BookManagement.authorList.size()+1;
    }
//    public void inputID() {
//        System.out.print(" Nhap ID tac gia : ");
//        Scanner sc = new Scanner(System.in);
//        do {
//            try {
//                int id = Integer.parseInt(sc.nextLine());
//                for (Author idnew : BookManagement.authorList) {
//                    while (id==idnew.getAuthorID()) {
//                        System.out.println("ID đã tồn tại, vui lòng nhập ID khác : ");
//                        id=Integer.parseInt(sc.nextLine());
//                    }
//                    this.authorID = id;
//                }
//                break;
//            } catch (Exception e) {
//                System.out.println("Vui long nhap 1 so ! : ");
//            }
//        } while (true);
//    }
    public void inputName() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Nhap ten tac gia : ");
        String name = sc.nextLine();
        while (name.trim().length() < 6) {
            System.out.println(" Vui long nhap ten dai hon 6 ki tu ! :");
            name = sc.nextLine();
        }
        this.authorName = name;
    }
    public void inputStatus() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Nhap trang thai (true/false) : ");
        Boolean status = Boolean.parseBoolean(sc.nextLine());
        this.authorStatus =status;
    }
    public void inputData() {
        setInputID();
        inputName();
        inputStatus();
    }
    public void displayData() {
        System.out.println(
                "Author : \n" +
                        "      ID     : " + authorID + "\n" +
                        "      Name   : " + authorName + "\n" +
                        "      Status : " + authorStatus + "\n"
        );
    }

    //  GETTER - SETTER
    public int getAuthorID() {
        return authorID;
    }
    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Boolean getAuthorStatus() {
        return authorStatus;
    }

    public void setAuthorStatus(Boolean authorStatus) {
        this.authorStatus = authorStatus;
    }
}//END CLASS AUTHOR !
