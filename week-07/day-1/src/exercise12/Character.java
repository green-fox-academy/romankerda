package exercise12;

public class Character {

  private String name;
  private String height;
  private String mass;
  private String hairColor;
  private String skin_color;
  private String ezeColor;
  private String birthYear;
  private String gender;
  private String age;

  public Character(String name, String height, String mass, String hairColor,
                   String skin_color, String ezeColor, String birthYear, String gender) {
    this.name = name;
    this.height = height;
    this.mass = mass;
    this.hairColor = hairColor;
    this.skin_color = skin_color;
    this.ezeColor = ezeColor;
    this.birthYear = birthYear;
    this.gender = gender;
  }

  public int getMass() {
    if (this.mass.matches("[0-9,]+")) {
      if (this.mass.indexOf(',') != -1) {
        StringBuilder sb = new StringBuilder(this.mass);
        sb.deleteCharAt(sb.indexOf(","));
        return Integer.parseInt(String.valueOf(sb));
      }
      return Integer.parseInt(mass);
    } else {
      return -1;
    }
  }

  public String getName() {
    return name;
  }

  public int getHeight() {
    if (this.height.matches("[0-9,]+")) {
      if (this.height.indexOf(',') != -1) {
        StringBuilder sb = new StringBuilder(this.height);
        sb.deleteCharAt(sb.indexOf(","));
        return Integer.parseInt(String.valueOf(sb));
      }
      return Integer.parseInt(height);
    } else {
      return -1;
    }
  }

  public String getGender() {
    return gender.equals("male") || gender.equals("female") ? gender : "other";
  }

  public String getAgeGroup() {
    age = this.birthYear;
    if (age.contains("BBY")) {
      age = birthYear.substring(0, birthYear.length() - 3);
    }
    if (this.age.equals("unknown")) {
      return "unknown";
    }
    if (age.contains("BBY")) {
      StringBuilder sb = new StringBuilder(this.age);
      //sb.substring(0,sb.indexOf("."));
      age = String.valueOf(sb.substring(0,sb.indexOf(".")));
    }
    if (Integer.parseInt(age) > 40) {
      return "above 40";
    }
    if (Integer.parseInt(age) > 21) {
      return "between 21 and 40";
    }
    return "below 21";
  }
}




