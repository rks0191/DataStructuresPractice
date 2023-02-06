import java.util.HashSet;

public class ExampleProblem {
    public int solution(int[] A) {
        HashSet minSet = new HashSet();
        //System.out.println(A.length);

        int minNumber =1;
        for(int element : A){
            minSet.add(element);
        }
        for(int i =1; i <= A.length+1; i++){
            if(!minSet.contains(i)){
                minNumber = i;
                break;
            }
        }
        return minNumber;
    }
}
