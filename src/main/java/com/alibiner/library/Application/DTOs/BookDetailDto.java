package com.alibiner.library.Application.DTOs;

public class BookDetailDto extends BaseDto{
    private long id;
    private String title;
    private String author;
    private String ISBN;
    private int page;
    private boolean status;

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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        // Desenin genişliğini ve yüksekliğini belirleyelim
        // Her bir satır için maksimum uzunluğu hesaplayalım
        int maxContentLength = Math.max(
                Math.max("Id: ".length() + String.valueOf(id).length(),
                        "Title: ".length() + title.length()),
                Math.max("Author: ".length() + author.length(), "ISBN : ".length() + ISBN.length())
        );
        maxContentLength = Math.max(maxContentLength, "Page : ".length() + String.valueOf(page).length());
        maxContentLength = Math.max(maxContentLength, "Status: ".length() + String.valueOf(status).length());

        // Desenin genişliği için güvenli bir boşluk payı bırakalım (minimum 30 diyelim)
        int desiredWidth = Math.max(maxContentLength + 4, 30); // 4 boşluk (sağdan 2, soldan 2)

        StringBuilder sb = new StringBuilder();

        // Üst kenar
        sb.append("█ "); // Sol üst köşe
        for (int i = 0; i < desiredWidth - 4; i++) { // Ortadaki kareler
            sb.append("█");
        }
        sb.append(" █\n"); // Sağ üst köşe

        // Boş satır (üst kenarın altı)
        sb.append("█ ");
        for (int i = 0; i < desiredWidth - 4; i++) {
            sb.append(" ");
        }
        sb.append(" █\n");

        // İçerik satırları
        sb.append(formatLine("Id: " + id, desiredWidth));
        sb.append(formatLine("Title : " + title, desiredWidth));
        sb.append(formatLine("Author: " + author, desiredWidth));
        sb.append(formatLine("ISBN : " + ISBN, desiredWidth));
        sb.append(formatLine("Page : " + page, desiredWidth));
        sb.append(formatLine("Status: " + status, desiredWidth));

        // Boş satır (içeriğin altı)
        sb.append("█ ");
        for (int i = 0; i < desiredWidth - 4; i++) {
            sb.append(" ");
        }
        sb.append(" █\n");

        // Alt kenar
        sb.append("█ "); // Sol alt köşe
        for (int i = 0; i < desiredWidth - 4; i++) { // Ortadaki kareler
            sb.append("█");
        }
        sb.append(" █"); // Sağ alt köşe


        return sb.toString();
    }

    // Her bir içerik satırını formatlayan yardımcı metod
    private String formatLine(String content, int desiredWidth) {
        StringBuilder line = new StringBuilder();
        line.append("█ "); // Sol kenar karesi ve boşluk

        // İçeriği yerleştir ve kalan boşlukları doldur
        line.append(content);
        for (int i = content.length(); i < desiredWidth - 4; i++) {
            line.append(" ");
        }
        line.append(" █\n"); // Sağ boşluk ve kenar karesi
        return line.toString();
    }
}
