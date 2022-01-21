package library;

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

        User currentUser = User.login();

        currentUser.menu();

        updateLib();

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
                String[] dataArray = data.split("`");
                library.add(new Book(dataArray[0], dataArray[1], dataArray[2], dataArray[3], Boolean.valueOf(dataArray[4])));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public static void addBooks() {
        boolean addingBooks = true;
        while(addingBooks){
            library.add(newBook());
            boolean valid = false;
            while(!valid){
                System.out.println("Do you want to add a new book? [y/n]");
                String choice = basicUtil.getInput();
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

        System.out.println("For each of the following, if you don't know the value please enter '-'.\n\nWhat's the book's title?");
        book.setTitle(basicUtil.getInput());
        System.out.println("Who's the book written by?");
        book.setAuthor(basicUtil.getInput());
        System.out.println("What's the book's isbn?");
        book.setIsbn(basicUtil.getInput());
        System.out.println("What genre is the book?");
        book.setGenre(basicUtil.getInput());

        return book;
    }

    public static void editBook(Book book){

    }

    public static boolean bookExists(Book book){
        for (Book b:library) {
            if(book.getTitle().equals(b.getTitle()) && book.getAuthor().equals(b.getAuthor()) && book.getIsbn().equals(b.getIsbn()) && book.getGenre().equals(b.getGenre()) && book.isOutOfLib()==b.isOutOfLib()){
                return true;
            }
        }
        return false;
    }

    public static Book findBook(){
        int count = 0;
        System.out.println("What property do you want to use to search for the book? [title, author, isbn, genre, status]"); //I figure it's somewhat useful to be able to sort by books that are actually available to take out
        String userInput = basicUtil.getInput();
        switch(userInput){
            case "title":
                System.out.println("What's the book called?");
                userInput = basicUtil.getInput();
                for (Book b: library) {
                    if(b.getTitle().equalsIgnoreCase(userInput)){
                        System.out.print(count + ") ");
                        printBook(b);
                        count++;
                    }
                }
                break;
            case "author":
                System.out.println("Who's the book written by?");
                userInput = basicUtil.getInput();
                for (Book b: library) {
                    if(b.getAuthor().equalsIgnoreCase(userInput)){
                        System.out.print(count + ") ");
                        printBook(b);
                        count++;
                    }
                }
                break;
            case "isbn":
                System.out.println("What's the book's ISBN?");
                userInput = basicUtil.getInput();
                for (Book b: library) {
                    if(b.getIsbn().equalsIgnoreCase(userInput)){
                        System.out.print(count + ") ");
                        printBook(b);
                        count++;
                    }
                }
                break;
            case "genre":
                System.out.println("What genre is the book?");
                userInput = basicUtil.getInput();
                for (Book b: library) {
                    if(b.getGenre().equalsIgnoreCase(userInput)){
                        System.out.print(count + ") ");
                        printBook(b);
                        count++;
                    }
                }
                break;
            case "status":
                System.out.println("The book is out of the library? [true/false]");
                userInput = basicUtil.getInput();
                for (Book b: library) {
                    if(String.valueOf(b.isOutOfLib()).equalsIgnoreCase(userInput)){
                        System.out.print(count + ") ");
                        printBook(b);
                        count++;
                    }
                }
                break;
            default:
                System.out.println("That's not a valid option...");
        }

        //"if(book.getIsbn().equals(xxxxx))"
        return new Book(); //change this
    }

    public static void listLib(){
        for (Book b:library) {
            printBook(b);
        }
    }

    public static void printBook(Book b){
        System.out.print(( b.isOutOfLib() ? 1 : 0 )); //true is 1, false is 0
        System.out.println("    " + b.getTitle() + " by " + b.getAuthor() + " --> ISBN: " + b.getIsbn() + ", " + b.getGenre());
    }

    public static void updateLib(){
        try {
            FileWriter overwriter = new FileWriter(libFile.getName(), false); //True means append to file contents, False means overwrite
            overwriter.write("");
            overwriter.close();
            FileWriter myWriter = new FileWriter(libFile.getName(), true);
            for (Book b:library) {
                System.out.println("'" + b.getTitle() + "' added.");
                myWriter.write(b.toText());
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}