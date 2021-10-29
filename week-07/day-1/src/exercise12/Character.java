package exercise12;

import javax.sound.sampled.Line;

public class Character {

  private String name;
  private int height;
  private int mass;
  private String hairColor;
  private String skin_color;
  private String eyeColor;
  private String birthYear;
  private String gender;
  private String age;

  public Character(String line) {
    String[] charArr = line.split(";");
    this.name = charArr[0];
    this.height = parseValue(charArr[1]);
    this.mass = parseValue(charArr[2]);
    this.hairColor = charArr[3];
    this.skin_color = charArr[4];
    this.eyeColor = charArr[5];
    this.birthYear = charArr[6];
    this.gender = charArr[7];
  }

    private int parseValue(String string){
      if (string.matches("[0-9,]+")) {
        if (string.indexOf(',') != -1) {
          StringBuilder sb = new StringBuilder(string);
          sb.deleteCharAt(sb.indexOf(","));
          return Integer.parseInt(String.valueOf(sb));
        }
        return Integer.parseInt(string);
      } else {
        return -1;
      }
    }


  public String getName() {
    return name;
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
    if (Double.parseDouble(age) > 40) {
      return "above 40";
    }
    if (Double.parseDouble(age) > 21) {
      return "between 21 and 40";
    }
    return "below 21";
  }

  public int getHeight() {
    return height;
  }

  public int getMass() {
    return mass;
  }
}




