package com.kodilla.patterns.prototype.library;

public final class Book extends Prototype<Book> {

    private final String title;
    private final String author;
    private final int publicationDate;

    public Book(String title, String author, int publicationDate) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

    public Book getCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "      Book: " +
                " title = '" + title + '\'' +
                ", author = '" + author + '\'' +
                ", publicationDate =  " + publicationDate +
                ';' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (getPublicationDate() != book.getPublicationDate()) return false;
        if (!getTitle().equals(book.getTitle())) return false;
        return getAuthor().equals(book.getAuthor());
    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + getAuthor().hashCode();
        result = 31 * result + getPublicationDate();
        return result;
    }
}
