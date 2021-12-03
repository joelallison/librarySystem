package com.joelallison;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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

        while(menu()){
            updateLib();
        }

    }

    public static String getInput(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
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

    public static boolean menu() {
        boolean running = true;
        System.out.println("Options --> { Add book(s) [a], Edit a book's information [e], Take out a book [t], Return a book [r] , Quit the program [q] }\n");
        String choice = getInput().toLowerCase(Locale.ROOT);
        switch (choice) {
            case "a":
                addBooks();
                break;
            case "e":
                findBook();
                editBook(new Book());
                break;
            case "q":
                running = false;
                break;
        }
        return running;
    }

    public static void addBooks() {
        boolean addingBooks = true;
        while(addingBooks){
            library.add(newBook());
            boolean valid = false;
            while(!valid){
                System.out.println("Do you want to add a new book? [y/n]");
                String choice = getInput();
                if (choice.equalsIgnoreCase("n")){
                    addingBooks = false;
                    valid = true;
                }else if (!choice.equalsIgnoreCase("y")){
                    System.out.println("That's not a valid option.");
                }else{
                    valid = true;
                }
            }
        }
    }

    public static Book newBook() {
        Book book = new Book();
        book.setOutOfLib(false);

        System.out.println("For each of the following, if you don't know the value please enter '[null]'.\n\nWhat's the book's title?");
        book.setTitle(getInput());
        System.out.println("Who's the book written by?");
        book.setAuthor(getInput());
        System.out.println("What's the book's isbn?");
        book.setIsbn(getInput());
        System.out.println("What genre is the book?");
        book.setGenre(getInput());

        return book;
    }

    public static void editBook(Book book){
        
    }

    public static Book findBook(){

        //"if(book.getIsbn().equals(xxxxx))"
        return new Book(); //change this
    }

    public static void updateLib(){
        for (Book b:library) {
            try {
                FileWriter myWriter = new FileWriter(libFile.getName(), false); //True means append to file contents, False means overwrite
                myWriter.write("`"+b.getTitle()+"`"+b.getAuthor()+"`"+b.getIsbn()+"`"+b.getGenre()+"`"+b.isOutOfLib());
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }
}
