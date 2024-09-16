import java.util.ArrayList;
 
public class StatsLibrary
{
    
    public double computeMean(ArrayList<Integer> listOfNumbers){
        
        int sum = 0;
        
        for(int singleNumber : listOfNumbers){
            
            sum+= singleNumber;
        }
        
        return sum / (double) listOfNumbers.size();
        
    }
    
    public double computeMedian(ArrayList<Integer> listOfNumbers){
        
        int middleNum = 0;
        int count =0;
        //is even
        if(listOfNumbers.size() %2 == 0 ){
        middleNum = listOfNumbers.size()/2;
        return listOfNumbers.get(middleNum);
        }
        
        return 0;
    }
}   
