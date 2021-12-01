package com.joelallison;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static File libFile = new File("library.txt");
    private static ArrayList<Book> library = new ArrayList<Book>();

    public static void main(String[] args) {

        System.out.println("Library Sys");
        createFile();
        getArrayFromFile();
        menu();
    }

    public static void createFile() {
        System.out.println("Checking file...");
        try {
            if (libFile.createNewFile()) {
                System.out.println("File created: " + libFile.getName());
            } else {
                System.out.println("File already exists d(^u^)");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public static void getArrayFromFile(){
        try{
            Scanner myReader = new Scanner(libFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }

    }

    /*public static Book txtToBook(String txt){

        return (studentID + "," + studentName + "," + studentEmail);
    }*/

    public static void menu() {
        Scanner input = new Scanner(System.in);

        boolean inUse = true;
        while(inUse){
            System.out.println("Options --> { Add a book [a], Edit a book's information [e], Take out a book [t], Return a book [r] , Quit the program [q] }\n");
            String choice = input.next().toLowerCase(Locale.ROOT);
            switch (choice){
                case "a":
                    addBook();
                    break;
                case "e":
                    findBook();
                    editBook(new Book());
                case "q":
                    inUse = false;
                    break;
            }
        }
    }

    public static void addBook() {
        Book book = new Book();

        System.out.println("For each of the following, if you don't know the value please enter '[null]'.\n\nWhat's the book's title?");
        
    }

    public static void editBook(Book book){
        
    }

    public static Book findBook(){

        //"if(book.getIsbn().equals(xxxxx))"
        return new Book(); //change this
    }
}
