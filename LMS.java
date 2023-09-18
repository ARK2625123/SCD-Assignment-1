import java.util.*;
class Book {


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
}

public void display(){
System.out.println ( "ID: " + id + "Title: " + title + " by " + author + "(" + year + ")" );
}

static{
int BooknextId = 1; // Initialize the static ID counter
}

public static class LMS {
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
}}}