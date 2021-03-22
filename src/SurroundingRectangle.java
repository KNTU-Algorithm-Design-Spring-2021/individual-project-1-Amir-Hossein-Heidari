import java.util.Scanner;

public class SurroundingRectangle {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.print("Hi my name is Surrounding Rectangle in fact the minimum Surrounding Rectangle\n" +
                            "now enter the count of dots which your shape consists of : ");
        int n=in.nextInt();
        System.out.println("\nIts time to enter the coordinates don't worry you have all the time in world\n" +
                            "Do it this way first the x axis then a space and then the y axis then the other dots\n");
        double[][] XY=new double[2][n];
        for(int i=0;i<n;i++){
            XY[0][i]=in.nextDouble();
            XY[1][i]=in.nextDouble();            
        }
        if(n>1000){
            System.out.println("\n\nAre not u a little sadistic to me! it's a complex shape\n" +
                                "Whatever give me a second...");
        }
        Pair xMaxMin=maxMin(XY[0],0,n-1);
        Pair yMaxmin=maxMin(XY[1],0,n-1);
        System.out.println("\nYour result is ready :\n" +
                            "\nvertex 0 :  x = " + xMaxMin.min + " y = " + yMaxmin.min +
                            "\n\nvertex 1 :  x = " + xMaxMin.max + " y = " + yMaxmin.min +
                            "\n\nvertex 2 :  x = " + xMaxMin.min + " y = " + yMaxmin.max +
                            "\n\nvertex 3 :  x = " + xMaxMin.max + " y = " + yMaxmin.max);
        in.close();
    }

    private static Pair maxMin(double[] input,int low,int high){
        Pair minmax=new Pair();
        
        if (low==high){
            minmax.max=input[low];
            minmax.min=input[low];
            return minmax;
        }
        
        if (high-low==1){
            if(input[low]>input[high]){
                minmax.max=input[low];
                minmax.min=input[high];
            }else{
                minmax.max=input[high];
                minmax.min=input[low];
            }
            return minmax;
        }
        
        int mid=(low+high)/2;
        Pair left=maxMin(input,low,mid);
        Pair right=maxMin(input,mid+1,high);

        minmax.min = left.min<right.min ? left.min : right.min;
        minmax.max = left.max>right.max ? left.max : right.max;

        return minmax;
    }
}