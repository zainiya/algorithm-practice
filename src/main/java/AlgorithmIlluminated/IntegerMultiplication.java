package AlgorithmIlluminated;
public class IntegerMultiplication {

  public static void main(String[] args) {
    String b = "5678";
    String a = "1234";

    int sum = 0;
    for (int i = a.length() - 1, cnt = 0; i >= 0; i--, cnt++) {
      int row = 0;
      for (int j = b.length() - 1, k = 0; j >= 0; j--, k++) {
        int x = Integer.parseInt(String.valueOf(a.charAt(i)));
        int y = Integer.parseInt(String.valueOf(b.charAt(j)));
        row += (int) (x * y * (Math.pow(10, k)));
      }
      sum += (int) (row * Math.pow(10, cnt));
    }
    System.out.println("compute = " + sum);
  }
}
