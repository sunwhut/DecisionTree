package work;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * The class contains a number of static methods
 * for processing an array of marks, 
 * which are scores in a test. 
 */

public class ProcessMarks {
    /**
     * Returns the maximum mark of an array of marks
     * @param an array of marks
     * @return the maximum mark
     */
	public static int max(int[] marks){
		int max ;
		int[] tmp = new int[marks.length];
		for(int i=0; i<marks.length; i++){
			tmp[i] = marks[i];
		}
		Arrays.sort(tmp);
		max = tmp[tmp.length-1];
		return max;
		
	}
	
	/**
     * Returns the minimum mark of an array of marks
     * @param an array of marks
     * @return the minimum mark
     */
	public static int min(int[] marks){
		int min ;
		int[] tmp = new int[marks.length];
		for(int i=0; i<marks.length; i++){
			tmp[i] = marks[i];
		}
		Arrays.sort(tmp);
		min = tmp[0];
		return min;
		
	}
	
	/**
     * Returns the difference between the maximum and minimum marks
     * of an array of marks
     * @param an array of marks
     * @return the difference between the maximum and minimum marks
     */
	public static int range(int[] marks){
		int range;
		int[] tmp = new int[marks.length];
		for(int i=0; i<marks.length; i++){
			tmp[i] = marks[i];
		}
		Arrays.sort(tmp);
		range = tmp[marks.length-1] - tmp[0];
		return range;
	}
	
	/**
	 * Returns the the mean value of the set of marks
	 * @param an array of marks
	 * @return the mean value
	 */
	public static double mean(int[] marks){
		int  sum = 0;
		double mean;
		for(int i=0; i<marks.length; i++){
			sum += marks[i];
		}
		mean = (double)sum/marks.length;
		return mean;
		
	}
	
	/**
	 * Returns the the median value of the set of marks
	 * @param an array of marks
	 * @return the median value
	 */
	public static double median(int[] marks){
		double median;
		int[] tmp = new int[marks.length];
		for(int i=0; i<marks.length; i++){
			tmp[i] = marks[i];
		}
		Arrays.sort(tmp);
		int length = tmp.length;
		Arrays.sort(tmp);
		if(length%2 == 0){
			median = (tmp[length/2-1] + tmp[length/2])/2;
		}else{
			median = marks[(tmp.length-1)/2];
		}
		return median;
	}
	
	/**
	 * Returns the the mode of the set of marks , there may be one 
	 * or more than one value
	 * @param an array of marks
	 * @return the mode
	 */
	public static int[] mode(int[] marks){
		int count = 0;
		int max = 0;
		ArrayList<Integer> num = new ArrayList<Integer>();
		Map<Integer,Integer> distri = new HashMap<Integer,Integer>();
		for(int i=0; i<marks.length; i++){
			if(distri.containsKey(marks[i])){
				distri.put(marks[i], distri.get(marks[i])+1);
			}else{
				distri.put(marks[i], 1);
			}
		}
		Iterator iter = distri.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry entry = (Map.Entry) iter.next(); 
			Integer key = (Integer)entry.getKey();
			Integer val = (Integer) entry.getValue();
			count = val;
			if(count > max){
				num.clear();
				max = count;
				num.add(key);
			}else if(count == max){
				num.add(key);
			}
		}
		int[] mode = new int[num.size()];
		for(int i=0; i<num.size(); i++){
			mode[i] = num.get(i);
		}
		return mode;
	}
	
	/**
	 * Returns an array of characters, which are the grades 
	 * corresponding to the integer marks in the array of marks.
	 * @param an array of marks
	 * @return an array of characters
	 */
	public static char[] grades(int[] marks){
		int[] bounds = {90,75,60,50,45};
		char[] grades = new char[marks.length];
		for(int i=0; i<marks.length; i++){
			if(marks[i] >= bounds[0]){
				grades[i] = 'A';
			} else if(marks[i]<bounds[0] && marks[i]>=bounds[1]){
				grades[i] = 'B';
			}else if(marks[i]<bounds[1] && marks[i]>=bounds[2]){
				grades[i] = 'C';
			}else if(marks[i]<bounds[2] && marks[i]>=bounds[3]){
				grades[i] = 'D';
			}else if(marks[i]<bounds[3] && marks[i]>=bounds[4]){
				grades[i] = 'E';
			}else if(marks[i] <= bounds[4]){
				grades[i] = 'F';
			}
		}
		return grades;
	}
	
	/**
	 * Returns an array of integer values containing the 
	 * distribution of grades, which is the number of 
	 * occurrences of each grade in the assigned grades
	 * @param an array of characters, which are the 
	 * grades assigned for the array of marks
	 * @return an array of integer values
	 */
	public static int[] gradeDistn(char[] grades){
		Map<Character,Integer> distri = new HashMap<Character,Integer>();
		for(int i=0; i<grades.length; i++){
			if(distri.containsKey(grades[i])){
				distri.put(grades[i], distri.get(grades[i])+1);
			}else{
				distri.put(grades[i], 1);
			}
		}
		int[] count = new int[6];
		for(int i=0; i<count.length; i++){
			char tmp = (char) ('A'+i);
			if(distri.get(tmp) != null){
				count[i] = distri.get(tmp);
			}else{
				count[i] = 0;
			}
		}
		return count;
		
	}
	/**
	 * Just for test
	 */
	public static void main(String[] args) {
		int[] marks = Marks.getMarks();
		//print the maximum mark
		System.out.println("the maximum mark is : "+max(marks));
		//print the minimum mark
		System.out.println("the minimum mark is : "+min(marks));
		//print the range between the maximum mark and the minimum mark
		System.out.println("the range is :" +range(marks));
		//print the mean mark
		System.out.println("the mean mark is : "+mean(marks));
		//print the mediant mark
		System.out.println("the mediant mark is : "+median(marks));
		//print the mode of the marks
		System.out.print("the mode is/are : ");
		int[] mode =  mode(marks);
		for(int i=0; i<mode.length; i++){
			System.out.print(mode[i]+" ");
		}
		System.out.println();
		//print the grades of the marks
		System.out.println("the grades are :");
		char[] grades = grades(marks);
		for(int i=0; i<grades.length; i++){
			System.out.print(grades[i]+" ");
			if(i%30 == 29){
				System.out.println();
			}
		}
		System.out.println();
		//print the distribution of the grades
		System.out.println("the distribution is :");
		int[] count = gradeDistn(grades);
		for(int i=0; i<count.length; i++){
			char ch = (char) ('A' + i);
			System.out.println(ch + ":" + count[i]);
		}
	}
}
