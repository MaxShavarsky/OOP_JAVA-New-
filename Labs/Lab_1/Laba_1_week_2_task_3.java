public class ArraySort {

 public static void main(String[] args) {
  int[] array = {30, 2, 10, 4, 6};
  int length = array.length;

  //PUT YOUR CODE HERE
        int a=0;
  for(int i=0;i<length;i++){
                    for(int j=0;j<length-1;j++){
                        if(array[j+1]<array[j]){
                            a=array[j+1];
                            array[j+1]=array[j];
                            array[j]=a;
                        }
                    }
                }
  
  //PUT YOUR CODE HERE

  for (int i = 0; i < length; i++) {
   System.out.print(array[i] + " ");
  }
 }
}