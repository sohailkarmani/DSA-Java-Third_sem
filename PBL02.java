import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import com.opencsv.CSVReader;
class BinaryST01 {
  Node root;
  private static class Node {
    int key;
    String month;
    Node left, right;
    public Node( String month , int key) {
        this.key = key;
        this.month = month;
        left = null;
        right = null;
    }
  }
  public void BinaryST02() {
      root = null;
  }
  public void insert(String month , int key) {
      root = insertNode(root, key, month);
  }
  private Node insertNode(Node root, int key, String month) {
      if (root == null) {
          root = new Node(month , key);
          return root;
      }

      if (key < root.key) {
          root.left = insertNode(root.left, key, month);
      } else if (key > root.key) {
          root.right = insertNode(root.right, key, month);
      }

      return root;
  }

  public void inorderTravl() {
      inorder(root);
  }

  private void inorder(Node root) {
      if (root != null) {
          inorder(root.left);
          System.out.println(root.key + " " + root.month);
          inorder(root.right);
      }
  }

  private Node right(Node r){
    if(r.right == null) return r;
    return right(r.right);
  }
  private Node left(Node r){
    if(r.left == null) return r;
    return left(r.left);
  }

  public void max(){
    Node x = right(root);
    System.out.println(x.key + " " + x.month);
  }
  public void min(){
    Node x = left(root);
    System.out.println(x.key + " " + x.month);
    
  }

    
}



class CrisShRow {
  String Year;
  String Month;
  String Date;
  String Day;
  String HitRun;
  String Lighting;
  String Weather;
  String WorstInjury;




  
  public CrisShRow(String year, String month, String date, String day, String hitRun, String lighting, String weather,
    String worstInjury) {
    Year = year;
    Month = month;
    Date = date;
    Day = day;
    HitRun = hitRun;
    Lighting = lighting;
    Weather = weather;
    WorstInjury = worstInjury;
  }





  @Override
  public String toString() {
    return "CrashRow [Year=" + Year + ", Month=" + Month + ", Date=" + Date + ", Day=" + Day + ", HitRun=" + HitRun
        + ", Lighting=" + Lighting + ", Weather=" + Weather + ", WorstInjury=" + WorstInjury + "]";
  }



  
 


}

class Queeue {
  Node target;
  int size;

  static class Node {
    CrisShRow data;
    Node next;
    Node pre;
  
    public Node() {
    }
  
    public Node(CrisShRow crash) {
      this.data = crash;
    }
  
    public Node(CrisShRow crash, Node next) {
      this.data = crash;
      this.next = next;
    }
  
    public Node(CrisShRow crash, Node next, Node pre) {
      this.data = crash;
      this.next = next;
      this.pre = pre;
    }
  }

  public Queeue() {
    target = new Node();
  }

  public void enQueue(CrisShRow cra) {
    if (size == 0) {
      Node tempNode = new Node(cra, target, target);
      target.pre = target.next = tempNode;
      size++;
      return;
    }
    target.pre = new Node(cra, target, target.pre);
    target.pre.pre.next = target.pre;
    size++;
  }

  public CrisShRow deQueue() {
    CrisShRow temCrash = target.next.data;
    target.next.pre = target;
    target.next = target.next.next;
    return temCrash;
  }

  public boolean empty() {
    return (size == 0);
  }

  public void display() {
    Node n=target.next;
    while(n!=target){
    System.out.println(n.data);
    System.out.println(" ");
    n=n.next;
    }
  }
}


public class PBL02 {
  public static BufferedReader file=null;
  public static Queeue queue;
  public static Queeue clearweather;
  public static Queeue snowweather;
  public static Queeue rainweather;
  public static int[] deathsAllDays ;
  public static int[] fridayMonthsDeaths ;

  public static BinaryST01 hitRunCrashesEachMonth;
  public static BinaryST01 nonHitRunCrashesEachMonth;
  public static Queeue mondayCrashes;
  public static Queeue tuesdayCrashes;
  public static Queeue wednesdayCrashes;
  public static Queeue thursdayCrashes;
  public static Queeue fridayCrashes;
  public static Queeue saturdayCrashes;
  public static Queeue sundayCrashes;

  public static ArrayList<CrisShRow> sortedCrashes[][];

  public static void step1() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 12; j++) {
        for (int k = 0; k < sortedCrashes[i][j].size(); k++) {
          queue.enQueue(sortedCrashes[i][j].get(k));
        }
      }
    }
  }

  public static void fileread() {
    try {
      CSVReader file = new CSVReader( new FileReader("ped_crashes.csv"));
      String[] row;
      file.readNext();
      while ((row = file.readNext()) != null) {
        sortDataByArray(
            new CrisShRow(
                row[0],
                row[1],
                row[2],
                row[4],
                row[7],
                row[8],
                row[9],
                row[11]
            ));
      }

    } catch (Exception e) {
      System.out.println(e);
    }
  }
  
 
  public static void step2() {
    clearweather = new Queeue();
    snowweather = new Queeue();
    rainweather = new Queeue();
    for (int x = 6; x < 9; x++) {
      for(int i = 0 ; i< 12 ; i++){
        for(int y=0;y<sortedCrashes[x][i].size();y++){
          String weather=sortedCrashes[x][i].get(y).Weather;
          if(weather.equals("Clear")){
              clearweather.enQueue(sortedCrashes[x][i].get(y));
          }
          else if(weather.equals("Snow")){
            snowweather.enQueue(sortedCrashes[x][i].get(y));
          }
          else if(weather.equals("Rain")){
            rainweather.enQueue(sortedCrashes[x][i].get(y));
          }
        }
      }
    }
  }

  public static void step3(){
    mondayCrashes = new Queeue();
    tuesdayCrashes = new Queeue();
    wednesdayCrashes = new Queeue();
    thursdayCrashes = new Queeue();
    fridayCrashes = new Queeue();
    saturdayCrashes = new Queeue();
    sundayCrashes = new Queeue();

    for (
      Queeue.Node p = queue.target.next;
      p != queue.target;
      p = p.next
    ) {
      String day = p.data.Day;
      switch (day) {
        case "Monday":
          mondayCrashes.enQueue(p.data);
          break;
        case "Tuesday":
          tuesdayCrashes.enQueue(p.data);
          break;
        case "Wednesday":
          wednesdayCrashes.enQueue(p.data);
          break;
        case "Thursday":
          thursdayCrashes.enQueue(p.data);
          break;
        case "Friday":
          fridayCrashes.enQueue(p.data);
       
          break;
        case "Saturday":
          saturdayCrashes.enQueue(p.data);
          break;
        case "Sunday":
          sundayCrashes.enQueue(p.data);
          break;
        default:
          break;
      }
    }

  }

  public static void step4(){
          int[] hitrun = new int[12];
          int[] nothitrun = new int[12];

          Queeue.Node x = queue.target.next;
          while(x!=queue.target){
            CrisShRow temp = x.data;
            if(temp.HitRun.equals("Hit-and-run")){

            if(temp.Month.equals("January")){
                hitrun[0]++;
            }else if(temp.Month.equals("March")){
              hitrun[2]++;

            }else if(temp.Month.equals("February")){
              hitrun[1]++;

            }else if(temp.Month.equals("April")){
              hitrun[3]++;
            }else if(temp.Month.equals("June")){
              hitrun[5]++;
            }else if(temp.Month.equals("May")){
              hitrun[4]++;
            }else if(temp.Month.equals("December")){
              hitrun[11]++;
            }else if(temp.Month.equals("July")){
              hitrun[6]++;
            }else if(temp.Month.equals("August")){
              hitrun[7]++;
            }else if(temp.Month.equals("September")){
              hitrun[8]++;
            }else if(temp.Month.equals("October")){
              hitrun[9]++;
            }else if(temp.Month.equals("November")){
              hitrun[10]++;
            }
          } else{
            if(temp.Month.equals("January")){
              nothitrun[0]++;
          }else if(temp.Month.equals("March")){
            nothitrun[2]++;

          }else if(temp.Month.equals("February")){
            nothitrun[1]++;

          }else if(temp.Month.equals("April")){
            nothitrun[3]++;
          }else if(temp.Month.equals("June")){
            nothitrun[5]++;
          }else if(temp.Month.equals("May")){
            nothitrun[4]++;
          }else if(temp.Month.equals("December")){
            nothitrun[11]++;
          }else if(temp.Month.equals("July")){
            nothitrun[6]++;
          }else if(temp.Month.equals("August")){
            nothitrun[7]++;
          }else if(temp.Month.equals("September")){
            nothitrun[8]++;
          }else if(temp.Month.equals("October")){
            nothitrun[9]++;
          }else if(temp.Month.equals("November")){
            nothitrun[10]++;
          }
          }

            x=x.next;
          }  

          String months[] = {
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December",
          };
          hitRunCrashesEachMonth = new BinaryST01();
          nonHitRunCrashesEachMonth = new BinaryST01();

          for(int i = 0 ; i < 12 ; i++){
              hitRunCrashesEachMonth.insert(months[i], hitrun[i]);
              nonHitRunCrashesEachMonth.insert(months[i], nothitrun[i]);

          }          

  }

  
  public static void p1(){
          deathsAllDays = new int[7];
          fridayMonthsDeaths = new int[12];
          Queeue.Node u = mondayCrashes.target.next;

          while(u != mondayCrashes.target){
              if(u.data.WorstInjury.contains("(K)")) deathsAllDays[0]++;
              u=u.next;
          }
          
          u = tuesdayCrashes.target.next;

          while(u != tuesdayCrashes.target){
            if(u.data.WorstInjury.contains("(K)")) deathsAllDays[1]++;
            u=u.next;
        
          }
          u = wednesdayCrashes.target.next;

          while(u != wednesdayCrashes.target){
            if(u.data.WorstInjury.contains("(K)")) deathsAllDays[2]++;
            u=u.next;
        
          }
          u = thursdayCrashes.target.next;

          while(u != thursdayCrashes.target){
            if(u.data.WorstInjury.contains("(K)")) deathsAllDays[3]++;
            u=u.next;
        
          }    
          u = fridayCrashes.target.next;

          while(u != fridayCrashes.target){
            if(u.data.WorstInjury.contains("(K)")) {
              deathsAllDays[4]++;

              if(u.data.Month.equals("January")) fridayMonthsDeaths[0]++;
              if(u.data.Month.equals("February")) fridayMonthsDeaths[1]++;
              if(u.data.Month.equals("March")) fridayMonthsDeaths[2]++;
              if(u.data.Month.equals("April")) fridayMonthsDeaths[3]++;
              if(u.data.Month.equals("May")) fridayMonthsDeaths[4]++;
              if(u.data.Month.equals("June")) fridayMonthsDeaths[5]++;
              if(u.data.Month.equals("July")) fridayMonthsDeaths[6]++;
              if(u.data.Month.equals("August")) fridayMonthsDeaths[7]++;
              if(u.data.Month.equals("September")) fridayMonthsDeaths[8]++;
              if(u.data.Month.equals("October")) fridayMonthsDeaths[9]++;
              if(u.data.Month.equals("November")) fridayMonthsDeaths[10]++;
              if(u.data.Month.equals("December")) fridayMonthsDeaths[11]++;

            }
            u=u.next;

          

            
        
          }    
          u = saturdayCrashes.target.next;

          while(u != saturdayCrashes.target){
            if(u.data.WorstInjury.contains("(K)")) deathsAllDays[5]++;
            u=u.next;
        
          }    
          u = sundayCrashes.target.next;

          while(u != sundayCrashes.target){
            if(u.data.WorstInjury.contains("(K)")) deathsAllDays[6]++;
            u=u.next;
        
          }
        

          int maxAt = 0;

          for (int i = 0; i < deathsAllDays.length; i++) {
            maxAt = deathsAllDays[i] > deathsAllDays[maxAt] ? i : maxAt;
          }

          switch(maxAt){
              case 0:
              System.out.println("Monday Was Deadliest with deaths: " + deathsAllDays[0]);
              break;

              case 1:
              System.out.println("Tuesday Was Deadliest with deaths: " + deathsAllDays[1]);
              break;

              case 2:
              System.out.println("Wedneday Was Deadliest with deaths: " + deathsAllDays[2]);
              break;

              case 3:
              System.out.println("THursday Was Deadliest with deaths: " + deathsAllDays[3]);
              break;

              case 4:
              System.out.println("Friday Was Deadliest with deaths: " + deathsAllDays[4]);
              break;

              case 5:
              System.out.println("Saturday Was Deadliest with deaths: " + deathsAllDays[5]);
              break;

              case 6:
              System.out.println("Sunday Was Deadliest with deaths: " + deathsAllDays[6]);
              break;
          }

           maxAt = 0;

          for (int i = 0; i < fridayMonthsDeaths.length; i++) {
            maxAt = fridayMonthsDeaths[i] > fridayMonthsDeaths[maxAt] ? i : maxAt;
          }

          switch(maxAt){
              case 0:
              System.out.println("January Was Deadliest with deaths: " + fridayMonthsDeaths[0]);
              break;

              case 1:
              System.out.println("February Was Deadliest with deaths: " + fridayMonthsDeaths[1]);
              break;

              case 2:
              System.out.println("March Was Deadliest with deaths: " + fridayMonthsDeaths[2]);
              break;

              case 3:
              System.out.println("April Was Deadliest with deaths: " + fridayMonthsDeaths[3]);
              break;

              case 4:
              System.out.println("May Was Deadliest with deaths: " + fridayMonthsDeaths[4]);
              break;

              case 5:
              System.out.println("June Was Deadliest with deaths: " + fridayMonthsDeaths[5]);
              break;

              case 6:
              System.out.println("July Was Deadliest with deaths: " + fridayMonthsDeaths[6]);
              break;

              case 7:
              System.out.println("August Was Deadliest with deaths: " + fridayMonthsDeaths[7]);
              break;
              
              case 8:
              System.out.println("September Was Deadliest with deaths: " + fridayMonthsDeaths[8]);
              break;
              case 9:
              System.out.println("October Was Deadliest with deaths: " + fridayMonthsDeaths[9]);
              break;
              case 10:
              System.out.println("November Was Deadliest with deaths: " + fridayMonthsDeaths[10]);
              break;
              case 11:
              System.out.println("December Was Deadliest with deaths: " + fridayMonthsDeaths[11]);
              break;
          }


  }

  public static void p2(){
        int[] rainyCrashesEachMonth = new int[12];
        Queeue.Node x = rainweather. target.next;
          while(x!=rainweather.target){
            if(x.data.Month.equals("January")) rainyCrashesEachMonth[0]++;
            if(x.data.Month.equals("February")) rainyCrashesEachMonth[1]++;
            if(x.data.Month.equals("March")) rainyCrashesEachMonth[2]++;
            if(x.data.Month.equals("April")) rainyCrashesEachMonth[3]++;
            if(x.data.Month.equals("May")) rainyCrashesEachMonth[4]++;
            if(x.data.Month.equals("June")) rainyCrashesEachMonth[5]++;
            if(x.data.Month.equals("July")) rainyCrashesEachMonth[6]++;
            if(x.data.Month.equals("August")) rainyCrashesEachMonth[7]++;
            if(x.data.Month.equals("September")) rainyCrashesEachMonth[8]++;
            if(x.data.Month.equals("October")) rainyCrashesEachMonth[9]++;
            if(x.data.Month.equals("November")) rainyCrashesEachMonth[10]++;
            if(x.data.Month.equals("December")) rainyCrashesEachMonth[11]++;


            x=x.next;
          }
          System.out.println("Rain weather crash each month");

          System.out.println("Januray " + rainyCrashesEachMonth[0] );
          System.out.println("Feb " + rainyCrashesEachMonth[1] );
          System.out.println("MAr " + rainyCrashesEachMonth[2] );
          System.out.println("April " + rainyCrashesEachMonth[3] );
          System.out.println("May " + rainyCrashesEachMonth[4] );
          System.out.println("june " + rainyCrashesEachMonth[5] );
          System.out.println("july " + rainyCrashesEachMonth[6] );
          System.out.println("aug " + rainyCrashesEachMonth[7] );
          System.out.println("sep " + rainyCrashesEachMonth[8] );
          System.out.println("oct " + rainyCrashesEachMonth[9] );
          System.out.println("nov " + rainyCrashesEachMonth[10] );
          System.out.println("dec " + rainyCrashesEachMonth[11] );


        // 
        // iterate rainweather
        // if (n.data.month == january) rainCrashesEachMonth[0]++;
  }
  public static void problem3(){
      System.out.println("Hit Run ");
      hitRunCrashesEachMonth.max();
      hitRunCrashesEachMonth.min();
      System.out.println("Not Hit Run ");
      nonHitRunCrashesEachMonth.max();
      nonHitRunCrashesEachMonth.min();
  }

  public static void postulate(){
    int mondayTuesday = 0;
    int saturdaysunday = 0;
    Queeue.Node u= mondayCrashes.target.next;
    while(u != mondayCrashes.target){
      if(u.data.Lighting.contains("Dark")) mondayTuesday++;
      u=u.next;
  }
  
  u = tuesdayCrashes.target.next;

  while(u != tuesdayCrashes.target){
    if(u.data.Lighting.contains("Dark")) mondayTuesday++;
    u=u.next;

  }

  u = saturdayCrashes.target.next;

  while(u != saturdayCrashes.target){
    if(u.data.Lighting.contains("Dark")) saturdaysunday++;
    u=u.next;

  }    
  u = sundayCrashes.target.next;

  while(u != sundayCrashes.target){
    if(u.data.Lighting.contains("Dark")) saturdaysunday++;
    u=u.next;

  }

  System.out.println("Postulate is : " + (mondayTuesday < saturdaysunday));
  }

  public static void makeAllVariables() {
    sortedCrashes = new ArrayList[9][12];
    for (int x = 0; x < 9; x++) {
      for (int y = 0; y < 12; y++) {
        sortedCrashes[x][y] = new ArrayList<CrisShRow>();
      }
    }
    
  }

  public static void main(String[] args) {
    makeAllVariables();
    queue = new Queeue();
    fileread();
    step1();
    // queue.display();
    step2();
    step3();
    step4();
    System.out.println("Problem 1.......... ");
    p1();
    System.out.println("Problem 2........... ");

    p2();
    System.out.println("Problem 3.......... ");

    problem3();
    System.out.println("postulate......... ");

    postulate();

  }



  public static void sortDataByArray(CrisShRow crash) {
    switch (crash.Year) {
      case "2010":
          switch (crash.Month) {
            case "January":
            sortedCrashes[0][0].add(crash);
            break;
            case "February":
            sortedCrashes[0][1].add(crash);
            break;
            case "March":
            sortedCrashes[0][2].add(crash);
            break;
            case "April":
            sortedCrashes[0][3].add(crash);
            break;
            case "May":
              sortedCrashes[0][4].add(crash);
              break;
            case "June":
              sortedCrashes[0][5].add(crash);
              break;
            case "July":
              sortedCrashes[0][6].add(crash);
              break;
            case "August":
              sortedCrashes[0][7].add(crash);
              break;
            case "September":
              sortedCrashes[0][8].add(crash);
              break;
            case "October":
              sortedCrashes[0][9].add(crash);
              break;
            case "November":
              sortedCrashes[0][10].add(crash);
              break;
            case "December":
              sortedCrashes[0][11].add(crash);
              break;
            default:
              break;
          }
          break;
        case "2011":
          switch (crash.Month) {
            case "January":
              sortedCrashes[1][0].add(crash);
              break;
  
            case "February":
              sortedCrashes[1][1].add(crash);
              break;
  
            case "March":
              sortedCrashes[1][2].add(crash);
              break;
  
            case "April":
              sortedCrashes[1][3].add(crash);
              break;
  
            case "May":
              sortedCrashes[1][4].add(crash);
              break;
  
            case "June":
              sortedCrashes[1][5].add(crash);
              break;
  
            case "July":
              sortedCrashes[1][6].add(crash);
              break;
  
            case "August":
              sortedCrashes[1][7].add(crash);
              break;
  
            case "September":
              sortedCrashes[1][8].add(crash);
              break;
  
            case "October":
              sortedCrashes[1][9].add(crash);
              break;
  
            case "November":
              sortedCrashes[1][10].add(crash);
              break;
  
            case "December":
              sortedCrashes[1][11].add(crash);
              break;
  
            default:
              break;
          }
          break;
  
        case "2012":
          switch (crash.Month) {
            case "January":
              sortedCrashes[2][0].add(crash);
              break;
  
            case "February":
              sortedCrashes[2][1].add(crash);
              break;
  
            case "March":
              sortedCrashes[2][2].add(crash);
              break;
  
              case "April":
              sortedCrashes[2][3].add(crash);
              break;
            case "May":
              sortedCrashes[2][4].add(crash);
              break;
            case "June":
              sortedCrashes[2][5].add(crash);
              break;
            case "July":
              sortedCrashes[2][6].add(crash);
              break;
            case "August":
              sortedCrashes[2][7].add(crash);
              break;
            case "September":
              sortedCrashes[2][8].add(crash);
              break;
            case "October":
              sortedCrashes[2][9].add(crash);
              break;
            case "November":
              sortedCrashes[2][10].add(crash);
              break;
            case "December":
              sortedCrashes[2][11].add(crash);
              break;
  
            default:
              break;
          }
          break;
  
        case "2013":
          switch (crash.Month) {
            case "January":
              sortedCrashes[3][0].add(crash);
              break;
  
            case "February":
              sortedCrashes[3][1].add(crash);
              break;
  
            case "March":
              sortedCrashes[3][2].add(crash);
              break;
  
              case "April":
              sortedCrashes[3][3].add(crash);
              break;
            case "May":
              sortedCrashes[3][4].add(crash);
              break;
            case "June":
              sortedCrashes[3][5].add(crash);
              break;
            case "July":
              sortedCrashes[3][6].add(crash);
              break;
            case "August":
              sortedCrashes[3][7].add(crash);
              break;
            case "September":
              sortedCrashes[3][8].add(crash);
              break;
            case "October":
              sortedCrashes[3][9].add(crash);
              break;
            case "November":
              sortedCrashes[3][10].add(crash);
              break;
            case "December":
              sortedCrashes[3][11].add(crash);
              break;
  
            default:
              break;
          }
          break;
  
        case "2014":
          switch (crash.Month) {
            case "January":
              sortedCrashes[4][0].add(crash);
              break;
  
            case "February":
              sortedCrashes[4][1].add(crash);
              break;
  
            case "March":
              sortedCrashes[4][2].add(crash);
              break;
              case "April":
              sortedCrashes[4][3].add(crash);
              break;
            case "May":
              sortedCrashes[4][4].add(crash);
              break;
            case "June":
              sortedCrashes[4][5].add(crash);
              break;
            case "July":
              sortedCrashes[4][6].add(crash);
              break;
            case "August":
              sortedCrashes[4][7].add(crash);
              break;
            case "September":
              sortedCrashes[4][8].add(crash);
              break;
            case "October":
              sortedCrashes[4][9].add(crash);
              break;
            case "November":
              sortedCrashes[4][10].add(crash);
              break;
            case "December":
              sortedCrashes[4][11].add(crash);
              break;
            default:
              break;
          }
          break;
  
        case "2015":
          switch (crash.Month) {
            case "January":
              sortedCrashes[5][0].add(crash);
              break;
  
            case "February":
              sortedCrashes[5][1].add(crash);
              break;
  
            case "March":
              sortedCrashes[5][2].add(crash);
              break;
              case "April":
              sortedCrashes[5][3].add(crash);
              break;
            case "May":
              sortedCrashes[5][4].add(crash);
              break;
            case "June":
              sortedCrashes[5][5].add(crash);
              break;
            case "July":
              sortedCrashes[5][6].add(crash);
              break;
            case "August":
              sortedCrashes[5][7].add(crash);
              break;
            case "September":
              sortedCrashes[5][8].add(crash);
              break;
            case "October":
              sortedCrashes[5][9].add(crash);
              break;
            case "November":
              sortedCrashes[5][10].add(crash);
              break;
            case "December":
              sortedCrashes[5][11].add(crash);
              break;
  
            default:
              break;
          }
          break;
  
        case "2016":
          switch (crash.Month) {
            case "January":
              sortedCrashes[6][0].add(crash);
              break;
  
            case "February":
              sortedCrashes[6][1].add(crash);
              break;
  
            case "March":
              sortedCrashes[6][2].add(crash);
              break;
              case "April":
              sortedCrashes[6][3].add(crash);
              break;
            case "May":
              sortedCrashes[6][4].add(crash);
              break;
            case "June":
              sortedCrashes[6][5].add(crash);
              break;
            case "July":
              sortedCrashes[6][6].add(crash);
              break;
            case "August":
              sortedCrashes[6][7].add(crash);
              break;
            case "September":
              sortedCrashes[6][8].add(crash);
              break;
            case "October":
              sortedCrashes[6][9].add(crash);
              break;
            case "November":
              sortedCrashes[6][10].add(crash);
              break;
            case "December":
              sortedCrashes[6][11].add(crash);
              break;
            default:
              break;
          }
          break;
  
        case "2017":
          switch (crash.Month) {
            case "January":
              sortedCrashes[7][0].add(crash);
              break;
  
            case "February":
              sortedCrashes[7][1].add(crash);
              break;
  
            case "March":
              sortedCrashes[7][2].add(crash);
              break;
              case "April":
              sortedCrashes[7][3].add(crash);
              break;
            case "May":
              sortedCrashes[7][4].add(crash);
              break;
            case "June":
              sortedCrashes[7][5].add(crash);
              break;
            case "July":
              sortedCrashes[7][6].add(crash);
              break;
            case "August":
              sortedCrashes[7][7].add(crash);
              break;
            case "September":
              sortedCrashes[7][8].add(crash);
              break;
            case "October":
              sortedCrashes[7][9].add(crash);
              break;
            case "November":
              sortedCrashes[7][10].add(crash);
              break;
            case "December":
              sortedCrashes[7][11].add(crash);
              break;
            default:
              break;
          }
          break;
  
        case "2018":
          switch (crash.Month) {
            case "January":
              sortedCrashes[8][0].add(crash);
              break;
  
            case "February":
              sortedCrashes[8][1].add(crash);
              break;
  
            case "March":
              sortedCrashes[8][2].add(crash);
              break;
              case "April":
              sortedCrashes[8][3].add(crash);
              break;
            case "May":
              sortedCrashes[8][4].add(crash);
              break;
            case "June":
              sortedCrashes[8][5].add(crash);
              break;
            case "July":
              sortedCrashes[8][6].add(crash);
              break;
            case "August":
              sortedCrashes[8][7].add(crash);
              break;
            case "September":
              sortedCrashes[8][8].add(crash);
              break;
            case "October":
              sortedCrashes[8][9].add(crash);
              break;
            case "November":
              sortedCrashes[8][10].add(crash);
              break;
            case "December":
              sortedCrashes[8][11].add(crash);
              break;
            default:
              break;
          }
          break;
  
        default:
  
          break;
      }
    }
  
  

}
