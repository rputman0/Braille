 public class Cells{  
  //A "cell" is composed of 6 dots, arranged in two lateral rows 
  //The dot positions are identified from numbers 1 to 6
  private static String[] cell = {
     "[ ]","[ ]",
     "[ ]","[ ]",
     "[ ]","[ ]"};
 
  public static void main(String[]args){
  }
  
  static String braille(String[] braille){
    String vBraille = "";
    for(int i=0;i<braille.length;i++)
      vBraille += createCells(braille[i]);

    String horz = combine(vBraille,0,6) + combine(vBraille,6,13) + combine(vBraille,13,20);
    System.out.println(horz);
    return horz;
  }
  
  static String combine(String row, int start, int end){
    String combined = "";
    while(start<row.length()){
     combined += row.substring(start,end).trim() + " ";
     start += 22;
     end += 22;
    }
    combined += "\n";
    return combined;
  }
  
  static String createCells(String numbers){
    String cells = "";
    placeStars(numbers);
    for(int i=0;i<cell.length;i++){
      cells += cell[i];
      if(i%2 != 0)
        cells += "\n";
    }
    clearCells();
    cells += "\n";
    return cells;
  }
  
  static void placeStars(String position){
   String[] numbers = position.split(" ");
   for(int i=0;i<numbers.length;i++)
    assignStarPosition(numbers[i]);
   }
  
  static void assignStarPosition(String position){
    if(Integer.parseInt(position) > 0 && Integer.parseInt(position) < 7)
    for(int i=0;i<cell.length;i++)
      cell[Integer.parseInt(position)-1] = "[*]";  
  }
  
  static void printCell(){
    for(int i=0;i<cell.length;i++){
      System.out.print(cell[i]);
      if(i%2 != 0)
        System.out.println();
    }
  }
  
  static void clearCells(){
    for(int i=0;i<cell.length;i++)
      cell[i] = "[ ]";  
  }
  
}