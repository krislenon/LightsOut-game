import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class State{
	int[][] lights = new int[5][5];
	List<Point> prev = new ArrayList<Point>();
	State(){
		try { 
            BufferedReader reader = new BufferedReader(new FileReader("lightsout.in")); 
             
            Scanner scan = new Scanner(System.in); 
            String line; 
            int i = 0;

	        while ((line = reader.readLine()) != null) {
	            String[] vals = line.trim().split(" ");

	            for (int j = 0; j < 5; j++) {
	                this.lights[i][j] = Integer.parseInt(vals[j]);
	            }

	            i++;
	        } 
            reader.close();
            
        }catch (Exception e){}

        System.out.println("\nInitial State:");

        for (int i=0; i<5; i++){
        	for (int j=0; j<5; j++) {
        		System.out.print(this.lights[i][j] + " ");
        	}
        	System.out.println();
        }
	}


	State(State state){
        for (int i=0; i<5; i++){
        	for (int j=0; j<5; j++) {
        		this.lights[i][j]=state.lights[i][j];
        	}
        }
	}
}
