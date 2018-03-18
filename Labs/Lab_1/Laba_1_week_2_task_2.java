public class MatrixPrint {
	public static void main(String args[]){
    int len = 5;
  int x = 1;
  int matrix[len][len];
  for (int i = 0; i < len; i++)
  {
    for (int j = 0; j < len; j++)
    {
      matrix[i][j] = x;
      x++;
    }
  }
    System.out.print("\n");
  for (int i = 0; i < len; i++)
  {
    for (int j = 0; j < len; j++)
    {
      if (i == j || i + j == len-1) {
        System.out.print(" * ");
      }
      else {
        System.out.print(" " + matrix[i][j]);
      }
    }
    System.out.print("\n");
}
 }     
      