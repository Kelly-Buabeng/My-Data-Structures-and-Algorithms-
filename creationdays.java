import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;



public class creationdays {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    ArrayList<String[]> bibleVerses = new ArrayList<>();
    bibleVerses.add(new String[] {"1", "Day 1: God created light, called light day and darkness night"});
    bibleVerses.add(new String[] {"2", "Day 2: God created the sky"});
    bibleVerses.add(new String[] {"3", "Day 3: God created the land, sea and vegetation"});
    bibleVerses.add(new String[] {"4", "Day 4: God created the sun, moon and stars"});
    bibleVerses.add(new String[] {"5", "Day 5: God created smaller animals such as birds and fishes"});
    bibleVerses.add(new String[] {"6", "Day 6: God created larger animals and humans"});
    bibleVerses.add(new String[] {"7", "Day 7: God rested and blessed the seventh day and made it Holy"});

  

   
    System.out.print("Enter a day of creation week (1-7) ");
    int userInput = input.nextInt();

    

    if (userInput >= 1 && userInput <= 7) {
      System.out.println(bibleVerses.get(userInput - 1)[1]);
  } else {
      System.out.println("Invalid Input. Please enter a valid day (1-7).");
  }


    ArrayList<String[]> verseNumbers = new ArrayList<>();
    verseNumbers.add(new String[] {"1", "Day 1 : Genesis 1:3-5"});
    verseNumbers.add(new String[] {"2", "Day 2 : Genesis 1:6-8"});
    verseNumbers.add(new String[] {"3", "Day 3 : Genesis 1:9-13"});
    verseNumbers.add(new String[] {"4", "Day 4 : Genesis 1:14-19"});
    verseNumbers.add(new String[] {"5", "Day 5 : Genesis 1:20-23"});
    verseNumbers.add(new String[] {"6", "Day 6 : Genesis 1:24-31"});
    verseNumbers.add(new String[] {"7", "Day 7 : Genesis 2:1-3"});

    System.out.print("Do you wish to see the days with their chapters and verses (y/n)? ");
        String userInput2 = input.next();
    
    if (userInput2.equalsIgnoreCase("y")) {
      for (String[] verse : verseNumbers) {
          System.out.println(verse[1]);
      }
  } else if (userInput2.equalsIgnoreCase("n")) {
      System.out.println("Thank you! Goodbye.");
  } else {
      System.out.println("Invalid input. Please enter 'y' or 'n'.");
  }
    
    

    input.close(); 
  }
}