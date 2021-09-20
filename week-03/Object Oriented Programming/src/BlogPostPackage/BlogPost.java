package BlogPostPackage;

public class BlogPost {

  String authorName;
  String title;
  String text;
  String publicationDate;

  public BlogPost(String title, String authorName, String publicationDate, String text) {
    this.authorName = authorName;
    this.title = title;
    this.text = text;
    this.publicationDate = publicationDate;
  }
}

