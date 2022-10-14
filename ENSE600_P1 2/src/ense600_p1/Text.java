package ense600_p1;

/**
 *
 * @author Leo Jia
 */

//Abstract class text, with a string of text and the author name/username
public abstract class Text {

    private String text;
    private String author;

    //Default constructor
    public Text(String text, String author) {
        this.text = text;
        this.author = author;
    }

    //Default toString
    public String toString() {
        return getText() + " (" + getAuthor() + ")";
    }

    //Get methods
    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }
}
