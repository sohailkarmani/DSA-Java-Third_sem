class SumAverage{
    int data;
    SumAverage next;

public SumAverage(int data){
    this.data=data;
}
public static int PrintSum(SumAverage p){
    int sum=0;
    
    int count=0;
    for(int i=1;i<=10;i++){
        p.next=new SumAverage(i*2);
        
        sum+=p.next.data;
        System.out.println(count);
        count++;
    }
    return sum;
}
public static float AverageA(SumAverage p){
    int sum=0,count=0;
    
    for(int i=1;i<=10;i++){
        p.next=new SumAverage(i*2);
        
        sum+=p.next.data;
        
        count++;
    }
     System.out.println("Element Count  "+count);
     
     float Ave=(float)sum/count;
return Ave;
}
public static void main(String[] args) {
    SumAverage start=new SumAverage(2);
    SumAverage p=start;
    System.out.println(PrintSum(p));
    System.out.println(AverageA(p));
    }
}