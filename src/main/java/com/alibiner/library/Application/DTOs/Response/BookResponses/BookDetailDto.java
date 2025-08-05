package com.alibiner.library.Application.DTOs.Response.BookResponses;

import com.alibiner.library.Application.DTOs.BaseDto;

/**
 * BookDetailDto is a Data Transfer Object (DTO) that holds book details.
 * <p>
 * It is used to show the book's information such as title, author, ISBN,
 * and status (whether it is available or not).
 */
public class BookDetailDto implements BaseDto {
    /** Unique ID for the book */
    private long id;

    /** Title of the book */
    private String title;

    /** Author of the book */
    private String author;

    /** ISBN number of the book */
    private String ISBN;

    /** True if the book is available, false if it is reserved */
    private boolean status;

    /** A readable status: "Available" or "Not Available" */
    private String checkOutStatus;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCheckOutStatus() {
        return checkOutStatus;
    }

    /**
     * Sets the check-out status based on a boolean.
     * If true, sets it as "Available", else "Not Available".
     * @param checkOutStatus true if book is free, false if reserved
     */
    public void setCheckOutStatus(boolean checkOutStatus) {
        if (checkOutStatus)
            this.checkOutStatus = "Available";
        else
            this.checkOutStatus = "Not Available";
    }

    /**
     * Returns the book's information as a styled box of text.
     * Helpful for printing book details in the console.
     *
     * @return a formatted string with all book details
     */
    @Override
    public String toString() {
        // calculates max width and formats output nicely
        int maxContentLength = Math.max(
                Math.max("Id: ".length() + String.valueOf(id).length(),
                        "Title: ".length() + title.length()),
                Math.max("Author: ".length() + author.length(), "ISBN : ".length() + ISBN.length())
        );
        maxContentLength = Math.max(maxContentLength, "Status: ".length() + String.valueOf(status).length());
        maxContentLength = Math.max(maxContentLength,checkOutStatus.length());


        int desiredWidth = Math.max(maxContentLength + 4, 30);

        StringBuilder sb = new StringBuilder();


        sb.append("█ ");
        for (int i = 0; i < desiredWidth - 4; i++) {
            sb.append("█");
        }
        sb.append(" █\n");


        sb.append("█ ");
        for (int i = 0; i < desiredWidth - 4; i++) {
            sb.append(" ");
        }
        sb.append(" █\n");


        sb.append(formatLine("Id: " + id, desiredWidth));
        sb.append(formatLine("Title : " + title, desiredWidth));
        sb.append(formatLine("Author: " + author, desiredWidth));
        sb.append(formatLine("ISBN : " + ISBN, desiredWidth));
        sb.append(formatLine("Status: " + checkOutStatus, desiredWidth));


        sb.append("█ ");
        for (int i = 0; i < desiredWidth - 4; i++) {
            sb.append(" ");
        }
        sb.append(" █\n");


        sb.append("█ ");
        for (int i = 0; i < desiredWidth - 4; i++) {
            sb.append("█");
        }
        sb.append(" █");


        return sb.toString();
    }

    /**
     * Helper method to format one line of the box.
     *
     * @param content the text to show
     * @param desiredWidth total width of the box
     * @return a formatted line string
     */
    private String formatLine(String content, int desiredWidth) {
        StringBuilder line = new StringBuilder();
        line.append("█ ");

        line.append(content);
        for (int i = content.length(); i < desiredWidth - 4; i++) {
            line.append(" ");
        }
        line.append(" █\n");
        return line.toString();
    }
}
