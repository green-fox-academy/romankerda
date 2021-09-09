public class CodingHours {
    public static void main(String[] args) {
        // An average Green Fox attendee codes 6 hours daily
        // The semester is 17 weeks long
        //
        // Print how many hours is spent with coding in a semester by an attendee,
        // if the attendee only codes on workdays.
        //
        // Print the percentage of the coding hours in the semester if the average
        // work hours weekly is 52

        int daily = 6;
        int weeks = 17;
        int weekDays = 5;
        int avgWorkHrs = 52;
        int hrsPerSemestr;
        float percOfCodingHrs;

        hrsPerSemestr = daily * weekDays * weeks;
        System.out.println("Hours spent with coding in a semester by an attendee = " + hrsPerSemestr);

        percOfCodingHrs = (float)(daily * weekDays) / avgWorkHrs * 100;
        System.out.println("The percentage of the coding hours in the semester = " + percOfCodingHrs);
    }
}
