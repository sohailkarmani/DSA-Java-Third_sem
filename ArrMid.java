class Arr{
    public int search(int a[],int x){
        for(int i=0;i<a.length;i++){
            if(a[i]==x){return i;}
        }
        return -1;
    }

// public int binSearch(int b[],int y){
//     int lo=0;
//     int hi=b.length;
//     while(lo<hi){
//         int mid=lo+hi/2;
//         if(b[mid]==y) return mid;
//         else if(b[mid]<mid) lo=mid+1;
//         else hi=mid;
//     }
//     return -1;

//}


//reverse an array
public void reverse(int b[]){
    for(int i=b.length-1;i>=0;i--)
    {System.out.print(b[i]+"  ");}

}

//average of array elements
public float average(int a[]){
    int sum=0;
    for(int i=0;i<a.length;i++){
        sum=sum+a[i];
    }
    float avg=sum/a.length;
    return avg;
}

//sum of array elements
public int sum(int a[]){
    int sum=0;
    for(int i=0;i<a.length;i++){
        sum+=a[i];

    }
    return sum;
}

//min element in array
public int min(int a[]){
    int min=a[0];
    for(int i=0;i<a.length;i++){
        if(a[i]<min){min=a[i];}
    }
    return min;
}



 }

public class ArrMid {
    public static void main(String[] args) {
        Arr a1=new Arr();
        int a[]={0,5,6,7,8,9,-1,5,2,22};
        int b[]={11,12,13,14,15,16,17};
        
        System.out.println(a1.search(a, 5));
        a1.reverse(b);
        System.out.println();
        System.out.println(a1.average(a));

        System.out.println(a1.sum(a));


        System.out.println(a1.min(a));
    }
}
