/*Question: 
 *  Input file 1 contains names and other strings.
 Input file 2 contains a list of names, one name per line.

Take these 2 files as input and print to standard out the line numbers 
from file 1 where the name in file 2 is found. For example, if file 2 
contains the name Alice, expected output would be Alice: 4, 56, 200. 
This means in file 1, the name Alice appears in the file on line 4, 56, 
and 200.


Looking for the most efficient solution taking into account i/o, cpu, 
and memory usage. You may state your assumptions and feel free to add 
additional justification as well.
 **************
 Comments 
 Name: Sava Vukomanovic
 Date: 04/07/2017
 Answer:
 
 Since we have array list at our disposal, they are a good tool when the file size is small to medium.
 In a scenario where a log file is 2 million lines long, we would resolve to using a binary search algorithm since 
 it has a notion of Θ(log(n)).
 
 The nested loop has a bigO notation of O(n^2).  Hence for every name within the loop will run y times more for each line. 
 This approach is fast with smaller data types.  In this example I used a nested loop as the outer loop only had 4 runs
 to make x 117 runs for the inner loop.  In the scenario in which anticipate greater data types for comparing two loops,
 a binary search algorithm would have to be implemented.
 *************
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class input {
	
	
	public static void main(String[] args){
		
	
	BufferedReader brNames, brStringNYTLines;
	FileReader  frNames, frStringNYTLines;
	brNames = brStringNYTLines =null;
	 frNames = frStringNYTLines = null;
	try {
		
		//Read input for the names you will be searching
		frNames = new FileReader("/Users/svukomanovic/Desktop/test2.txt");
		brNames = new BufferedReader(frNames);
		//Read input for lines
		frStringNYTLines = new FileReader("/Users/svukomanovic/Desktop/test.txt");
		brStringNYTLines = new BufferedReader(frStringNYTLines);
		
		String s1;	
		String s2;
		
		ArrayList<String> names = new ArrayList<String>();
		//Populate names
		while ((s1 = brNames.readLine()) != null) 
			names.add(s1);
						
		//Populate Lines from the NYT article
		ArrayList<String> NYTLines = new ArrayList<String>();
		while ((s2 = brStringNYTLines.readLine()) != null)
			NYTLines.add(s2); 
		
		
		//First for loop increments names
		for (int x = 0; x< names.size(); x++){
			String output="";
			String name="";
			//Second for loop increments the lines of the NYT article
				for (int y=0; y < NYTLines.size(); y++){
					//Appends the name China, Mexico, climate and Guangdong
					name = names.get(x);
					if(NYTLines.get(y).contains(name)){
						//Increments the string for the line number each time it appears
						output+= y + " ";
					}	
				}
				System.out.println(name + ": " + output + "\n");
			}
		
	 
	} catch (IOException e) {

		e.printStackTrace();

		} finally {
	
				try {
				
					if ( (brNames != null) || (brStringNYTLines !=null)){
						brNames.close();
						brStringNYTLines.close();
						}
	
				
					if ( (frNames != null) || (frStringNYTLines !=null)){
						frNames.close();	
						frStringNYTLines.close();
						}
	
					} catch (IOException ex) {
	
						ex.printStackTrace();
	
					}    
		}
	
	}	
}

