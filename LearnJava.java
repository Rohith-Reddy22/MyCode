import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class LearnJava{
  public static void main(String[] args){
    int size = 10_000;
    List<Integer> nums = new ArrayList<>(size);
    Random randm = new Random();
    for(int i=0; i<size; i++){
      nums.add(randm.nextInt(100));
    }
    long startSeq = System.currentTimeMillis();
    int sum1 = nums.stream()
      .mapToInt(i -> i)
      .sum();
    long endSeq = System.currentTimeMillis();
    
    long startPara = System.currentTimeMillis();
    int sum2 = nums.parallelStream()
      .mapToInt(i -> i)
      .sum();
    long endPara = System.currentTimeMillis();
    System.out.println(sum1 + " " + sum2);
    System.out.println("Seq : " + (endSeq - startSeq) + "ms");
    System.out.println("Para : " + (endPara - startPara) + "ms");
  }
}