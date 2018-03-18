public class BinarySearch {

	public static void main(String[] args) {

		int data[] = { 3, 6, 7, 10, 34, 56, 60 };
		int numberToFind = 10;
        int x = 0;
		// PUT YOUR CODE HERE
for(int i = 0; i < data.length;i++){
if(data[i]==numberToFind){
System.out.print(i);
x++;
}
}
if(x == 0){
System.out.print(-1);
}
		// PUT YOUR CODE HERE
	}
}
      