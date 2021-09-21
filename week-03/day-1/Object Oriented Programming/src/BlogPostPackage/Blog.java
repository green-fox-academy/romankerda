package BlogPostPackage;

import java.util.ArrayList;
import java.util.List;

public class Blog {

  private List<BlogPost> list;

  public Blog() {
    list = new ArrayList<>();
  }

  public void add(BlogPost post) {
    list.add(post);
  }

  public void delete(int index) {
    list.remove(index);
  }

  public void update(int index, BlogPost post) {
    list.add(index, post);
  }
}
