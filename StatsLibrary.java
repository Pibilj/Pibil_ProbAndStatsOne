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
        
        //is even
        if(listOfNumbers.size() %2 == 0 ){
            middleNum = listOfNumbers.size()/2;
            return listOfNumbers.get(middleNum);
        }
        else{
            middleNum = listOfNumbers.size()/2; 
            return listOfNumbers.get(middleNum);
        }
        
        
    }
    public int computeMode(ArrayList<Integer> listOfNumbers){
        int modeValue = 0;
        int count = 0;
        int highestCount = 0;
        //First value to compare
        for(int i = 0; i<listOfNumbers.size() -1; i++){
            //second value to compare
            for(int j = i +1; j < listOfNumbers.size(); j++){
                //check to see if the numbers are the same
                if(listOfNumbers.get(i) == listOfNumbers.get(j)){
                    count++;
                    //check to see if there is a number pair higher then previous
                    if(count > highestCount){
                        highestCount = count;
                        modeValue = listOfNumbers.get(i);
                    }
                }
            }
            //reset counter after each i value
            count = 0;
        }
        
        return modeValue;
        
    }
    
    public double computeStandardDeviation(ArrayList<Integer> listOfNumbers){
        double mean = computeMean(listOfNumbers);
        double standardDeviation = 0;
        
        for(int singleNum : listOfNumbers){
            standardDeviation += Math.pow(singleNum - mean, 2);
        }
        
        return Math.sqrt(standardDeviation / listOfNumbers.size());
    }
    
    
}   
