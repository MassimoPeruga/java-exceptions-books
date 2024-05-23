package org.learning.exceptions;

public class Book {
    //attributi
    private String title;
    private int pages;
    private String author;
    private String publisher;

    //costruttore
    public Book(String title, int pages, String author, String publisher) {
        setTitle(title);
        setPages(pages);
        setAuthor(author);
        setPublisher(publisher);
    }

    //setter
    public void setTitle(String title) {
        this.title = checkValue(title);
    }

    public void setPages(int pages){
        this.pages = checkValue(pages);
    }

    public void setAuthor(String author){
        this.author = checkValue(author);
    }

    public void setPublisher(String publisher) {
        this.publisher = checkValue(publisher);
    }

    //getter
    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    //methods
    private String checkValue(String value) throws IllegalArgumentException{
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Il campo non può essere vuoto");
        } else return value;
    }

    private Integer checkValue(Integer value) throws IllegalArgumentException{
        if (value <= 0) {
            throw new IllegalArgumentException("Il numero di pagine deve essere maggiore di 0");
        } else return value;
    }

    @Override
    public String toString() {
        return '{' +
                "Titolo= '" + title + '\'' +
                ", Numero pagine= " + pages +
                ", Scrittore= '" + author + '\'' +
                ", Editore= '" + publisher + '\'' +
                '}';
    }
}