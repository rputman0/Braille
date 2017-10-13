//BRAILLE characters are represented by different patterns of dots, that are arranged in a CELL
public class Braille extends Cells{
  
       //Warning: only works on lower case letters 
       //uppercase is indicated by "6" (one cell) plus "braille lowercase" (another cell)
       static  String alphabet = "abcdefghijklmnopqrstuvwxyz";
       static  String[] braille = {"1", "1 3", "1 2", "1 2 4", "1 4", "1 2 3", "1 2 3 4", "1 3 4", "2 3", "2 3 4",
                "1 5", "1 3 5", "1 2 5", "1 2 4 5", "1 4 5", "1 2 3 5", "1 2 3 4 5", "1 3 4 5", "2 3 5",
                "2 3 4 5", "1 5 6", "1 3 5 6", "2 3 4 6", "1 2 5 6", "1 2 4 5 6", "1 4 5 6"};

       static  String special = "@!= []$#%&()?+-;0123456789";
       static  String[] brailleSpecial = {"2", "2 3 5 6", "1 2 3 4 5 6", " ", "2 3 6", "1 2 3 4 6", "1 2 3 6",
                "2 4 5 6", "1 2 6", "1 2 3 5 6", "1 3 4 5 6", "2 3 4 5", "1 2 4 6", "2 5 6", "5 6", "5 6",
                "4 5 6", "3", "3 5", "3 4", "3 4 6", "3 6", "3 4 5", "3 4 5 6", "3 4 5", "4 5"};
  
    public static void main(String[] args){
      String message = "snow white";
      System.out.println(message);
      toBraille(message);
    }
    
    //only works for messages with less than 25 char?
    static void toBraille(String numbers){
      if(numbers.length() > 25){
        while(numbers.length() < 25)
         //TODO: refactor loop to print only 25 characters per line, for entire string
         braille(toNumbers(numbers.substring(0,25)));
         braille(toNumbers(numbers.substring(25,50)));
         braille(toNumbers(numbers.substring(50)));
         System.out.println();
      }
      else
        braille(toNumbers(numbers));
    }

    static String[] toNumbers(String sentence){
     String[] message = new String[sentence.length()];
     for(int i=0;i<sentence.length();i++)
      message[i] = alphabetBraille(sentence.charAt(i));

     return message;
    }

    static String alphabetBraille(char letter){
        for(int i=0;i<26;i++){
          if(letter == alphabet.charAt(i))
            return braille[i];
          else if(letter == special.charAt(i))
            return brailleSpecial[i];
        }
     return "";
    }

}