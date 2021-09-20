package BlogPostPackage;

public class App {
  public static void main(String[] args) {

    String text2 = "A popular long-form, stick-figure-illustrated blog about almost everything.";
    String text3 = "Daniel Hanley, a cyber security engineer at IBM, doesn’t want to be the center of attention. " +
            "When I asked to take his picture outside one of IBM’s New York City offices, he told me that he " +
            "wasn’t really into the whole organizer profile thing.";


    BlogPost one = new BlogPost("Lorem Ipsum", "John Doe", "2000.05.04",
            "Lorem ipsum dolor sit amet.");
    BlogPost two = new BlogPost("Wait but why", "Tim Urban", "2010.10.10",
            text2);
    BlogPost three = new BlogPost("One Engineer Is Trying to Get IBM to Reckon With Trump",
            "Wiliam Turton", "2017.03.28", text3);



  }
}
