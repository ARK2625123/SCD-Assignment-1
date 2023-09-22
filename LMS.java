import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.Scanner;
class Library{
        protected ArrayList<Book> BookList;

        private int nextId;
   
   


    public Library() {
        
   
        nextId=1;
       
    }


    


    public void addItem(Book book){
        book.setid(nextId);
        nextId++;
        BookList.add(book);
    }
       

    
    public void addItem(Library lib){
       
        
       
       
            Scanner s = new Scanner(System.in);  
            System.out.println("Enter title");
            String title = s.nextLine();
            
                Scanner author_name = new Scanner(System.in);
                System.out.println("Enter Author name for Book");
                String author = author_name.nextLine();
            
                Scanner year_book = new Scanner(System.in);
                System.out.println("Enter Publishing Year of the Book");
                int year = year_book.nextInt();
            
                Book book = new Book(title,author, year);
                lib.addItem(book);
                
            
    
    
    }

    public void deleteItem(int id){
        BookList.removeIf(BookList -> BookList.id == id);
        
    }
   
        
    public void editItem(Library lib) {
        Scanner scanner = new Scanner(System.in);
       


        System.out.print("Enter the ID of the book to edit:");
        int id = scanner.nextInt();
    
    
        boolean found = false;
    
        for (int i=0;i<BookList.size();i++) {
            
            if (BookList.get(i).id == id) 
                        {
            
                        
                            
                            System.out.print("Enter new title for the book: ");
                            String newTitle = scanner.next();
                            System.out.print("Enter new author for the book: ");
                            String newAuthor = scanner.next();
                            BookList.get(i).setTitle(newTitle);
                            BookList.get(i).setAuthor(newAuthor);
                            System.out.println("Book updated successfully.");
                            found = true;
                        }
                    }
                
    

                       
                       
    
        if (!found) {
            System.out.println("Book with ID " + id + " not found.");
        }
    }
    
    
   

    public void displayAllItems() {
        
            System.out.println("-----------------------The Library has Following---------------------------");
    
        

        for (int i=0;i<BookList.size();i++) {
           
               BookList.get(i);
         
            }
         
        }
    


    public void displaySingleItem(int id){
         
         for (int i=0;i<BookList.size();i++){
            
            if(BookList.get(i).id==id){
                BookList.get(i).display();
            }
        }
    }

    

  



    public void loadDataFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
    
                if (parts.length < 6) {
                    System.out.println("Invalid data format in line: " + line);
                    continue;
                }
    
                int id;
                try {
                    id = Integer.parseInt(parts[0].trim());
                } catch (NumberFormatException x) {
                    System.out.println("Invalid item type in line: " + line);
                    continue; // Skip this line
                }
    
                String title = parts[1].trim();
                String authors = parts[2].trim();
                int year = 0;
           
                    
                    try {
                        year = Integer.parseInt(parts[3].trim());
                    } catch (NumberFormatException x) {
                        System.out.println("Invalid year");
                        continue; 
                    }
                
    
              
                        Book book = new Book(title,authors, year);
                        addItem(book);
                        break;
                   
            }
        } catch (IOException e) {
            System.out.println("Error reading from the file: " + e.getMessage());
        }
    }
}


class Book extends Library{


public static int nextId; // Static variable to auto-increment the ID
public int id;
public String title;
public String author;
public int year;

Book(String t, String a, int y) {
id = nextId++; // Assign the next available ID and increment it
title = t;
author = a;
year = y;
BookList.add(this);
}

public void display(){
System.out.println ( "ID: " + id + ",Title: " + title + ", Author: " + author + ", Year: " + year  );
}

static{
int BooknextId = 1; // Initialize the static ID counter
}

public void setid(int id){
this.id=id;
}

public void setAuthor(String a){
this.author=a;
}

public void setTitle(String t){
this.title=t;
}


}

public class LMS {
    public static void main(String[] args) {
       
         String title, author;
         int year;
         Scanner input = new Scanner(System.in);
         System.out.println("Enter the title of the book: ") ;
         title=input.nextLine();
         System.out.println("Enter the author of the book: ") ;
         author=input.nextLine();
         System.out.println( "Enter the year of publication of the book: ");
         year=input.nextInt();

         Book book=new Book(title, author, year);
         book.display();
        
return ;
}}