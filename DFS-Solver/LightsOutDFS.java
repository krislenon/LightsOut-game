import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Point;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.EmptyStackException;

public class LightsOutDFS{
	public static void main(String[] args){
		List<State> frontier = new ArrayList<State>();

		State state = new State(); //initial state

		
		frontier.add(state);

		while(!frontier.isEmpty()) {
			State currentState = dequeue(frontier);
			if(GoalTest(currentState)) {
				State solve = new State(currentState);
                Iterator<Point> i = currentState.prev.iterator();
                while(i.hasNext()){
                    solve.prev.add(i.next());
                }
                writeResult(solve.prev);
				break;
			} else {
                for(Point a : Actions(currentState)){
					State next = new State(currentState);
                    System.out.println(a);
                    Iterator<Point> ite = currentState.prev.iterator();
                    while(ite.hasNext()){
                        next.prev.add(ite.next());
                    }
		            enqueue(frontier, Result(next,a));
		        }
			}
		}
	}

    public static void writeResult(List<Point> prev){
        int[][] arr = new int[5][5];

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                arr[i][j] = 0;
            }
        }

        for(Point a : prev){
            int row = (int)(a.getX());
            int col = (int)(a.getY());
            arr[row][col] = 1;
        }
        System.out.println("\nSolution:");

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        try{
            BufferedWriter writer = new BufferedWriter (new FileWriter("lightsout.out"));
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++){
                    writer.write(arr[i][j]+" ");   
                }
                writer.write("\n");
            }
        writer.close();   
            
        }catch (Exception e){}
        
    }


	public static State dequeue(List<State> frontier) {
        if (frontier.size() != 0) {
            return frontier.remove(frontier.size()-1);
        }
        else
            throw new EmptyStackException();
        /*
		State current = frontier.get(frontier.size()-1);
        frontier.remove(frontier.size()-1);
        State current = frontier.get(0);
		frontier.remove(0);
		return current;
        */
	}

	public static void enqueue(List<State> frontier, State current) {
        frontier.add(current);
        /*
        int length = 5;
		frontier.add(0, current);
        if(frontier.size()>5){
            frontier.remove(length);
        }
        */
	}

	public static List<Point> Actions(State current){
		List<Point> notClick = new ArrayList<Point>();
		for (int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				Point point = new Point(i,j);
				notClick.add(point);
			}
		}

		for(Point a : current.prev){
			notClick.remove(a);
        }
		return notClick;
	}

	public static State Result(State current, Point a) {
		int i = (int)(a.getX());
		int j = (int)(a.getY());
		if(i==0 && j==0){
            if(current.lights[i][j]==0){
                current.lights[i][j]=1; 
                if(current.lights[i+1][j]==0){
                    current.lights[i+1][j]=1; 
                }else{
                    current.lights[i+1][j]=0; 
                }
                if(current.lights[i][j+1]==0){ 
                    current.lights[i][j+1]=1; 
                }else{
                    current.lights[i][j+1]=0; 
                } 
            }else{
                current.lights[i][j]=0; 
                if(current.lights[i+1][j]==0){
                    current.lights[i+1][j]=1; 
                }else{
                    current.lights[i+1][j]=0; 
                }
                if(current.lights[i][j+1]==0){
                    current.lights[i][j+1]=1; 
                }else{
                    current.lights[i][j+1]=0; 
                } 
            }
        }else if(i==4 && j==0){
            if(current.lights[i][j]==0){
                current.lights[i][j]=1; 
                if(current.lights[i-1][j]==0){
                    current.lights[i-1][j]=1; 
                }else{
                    current.lights[i-1][j]=0; 
                }
                if(current.lights[i][j+1]==0){
                    current.lights[i][j+1]=1; 
                }else{
                    current.lights[i][j+1]=0; 
                } 
            }else{
                current.lights[i][j]=0; 
                if(current.lights[i-1][j]==0){
                    current.lights[i-1][j]=1; 
                }else{
                    current.lights[i-1][j]=0; 
                }
                if(current.lights[i][j+1]==0){
                    current.lights[i][j+1]=1; 
                }else{
                    current.lights[i][j+1]=0; 
                } 
            }

        }else if(i==0 && j==4){
            if(current.lights[i][j]==0){
                current.lights[i][j]=1; 
                if(current.lights[i+1][j]==0){
                    current.lights[i+1][j]=1; 
                }else{
                    current.lights[i+1][j]=0; 
                }
                if(current.lights[i][j-1]==0){
                    current.lights[i][j-1]=1; 
                }else{
                    current.lights[i][j-1]=0; 
                } 
            }else{
                current.lights[i][j]=0; 
                if(current.lights[i+1][j]==0){
                    current.lights[i+1][j]=1; 
                }else{
                    current.lights[i+1][j]=0; 
                }
                if(current.lights[i][j-1]==0){
                    current.lights[i][j-1]=1; 
                }else{
                    current.lights[i][j-1]=0; 
                } 
            }
            
        }else if(i==4 && j==4){
            if(current.lights[i][j]==0){
                current.lights[i][j]=1; 
                if(current.lights[i-1][j]==0){
                    current.lights[i-1][j]=1; 
                }else{
                    current.lights[i-1][j]=0; 
                }
                if(current.lights[i][j-1]==0){
                    current.lights[i][j-1]=1; 
                }else{
                    current.lights[i][j-1]=0; 
                } 
            }else{
                current.lights[i][j]=0; 
                if(current.lights[i-1][j]==0){
                    current.lights[i-1][j]=1; 
                }else{
                    current.lights[i-1][j]=0; 
                }
                if(current.lights[i][j-1]==0){
                    current.lights[i][j-1]=1; 
                }else{
                    current.lights[i][j-1]=0; 
                } 
            }
        }else if(i==4){
            if(current.lights[i][j]==0){
                current.lights[i][j]=1; 
                if(current.lights[i-1][j]==0){ 
                    current.lights[i-1][j]=1; 
                }else{
                    current.lights[i-1][j]=0; 
                }
                if(current.lights[i][j+1]==0){
                    current.lights[i][j+1]=1; 
                }else{
                    current.lights[i][j+1]=0; 
                } 
                if(current.lights[i][j-1]==0){
                    current.lights[i][j-1]=1; 
                }else{
                    current.lights[i][j-1]=0; 
                }
            }else{
                current.lights[i][j]=0; 
                if(current.lights[i-1][j]==0){
                    current.lights[i-1][j]=1; 
                }else{
                    current.lights[i-1][j]=0; 
                }
                if(current.lights[i][j+1]==0){
                    current.lights[i][j+1]=1; 
                }else{
                    current.lights[i][j+1]=0; 
                } 
                if(current.lights[i][j-1]==0){ 
                    current.lights[i][j-1]=1; 
                }else{
                    current.lights[i][j-1]=0; 
                }  
            }
        }else if(i==0){
            if(current.lights[i][j]==0){
                current.lights[i][j]=1; 
                if(current.lights[i+1][j]==0){ 
                    current.lights[i+1][j]=1; 
                }else{
                    current.lights[i+1][j]=0; 
                }
                if(current.lights[i][j+1]==0){ 
                    current.lights[i][j+1]=1; 
                }else{
                    current.lights[i][j+1]=0; 
                } 
                if(current.lights[i][j-1]==0){
                    current.lights[i][j-1]=1; 
                }else{
                    current.lights[i][j-1]=0; 
                }
            }else{
                current.lights[i][j]=0; 
                if(current.lights[i+1][j]==0){
                    current.lights[i+1][j]=1; 
                }else{
                    current.lights[i+1][j]=0; 
                }
                if(current.lights[i][j+1]==0){
                    current.lights[i][j+1]=1; 
                }else{
                    current.lights[i][j+1]=0; 
                } 
                if(current.lights[i][j-1]==0){
                    current.lights[i][j-1]=1; 
                }else{
                    current.lights[i][j-1]=0; 
                }  
            }
        }else if(j==0){
            if(current.lights[i][j]==0){
                current.lights[i][j]=1; 
                if(current.lights[i-1][j]==0){
                    current.lights[i-1][j]=1; 
                }else{
                    current.lights[i-1][j]=0; 
                }
                if(current.lights[i+1][j]==0){
                    current.lights[i+1][j]=1; 
                }else{
                    current.lights[i+1][j]=0; 
                }
                if(current.lights[i][j+1]==0){
                    current.lights[i][j+1]=1; 
                }else{
                    current.lights[i][j+1]=0; 
                } 
            }else{
                current.lights[i][j]=0; 
                if(current.lights[i-1][j]==0){
                    current.lights[i-1][j]=1; 
                }else{
                    current.lights[i-1][j]=0; 
                }
                if(current.lights[i+1][j]==0){
                    current.lights[i+1][j]=1; 
                }else{
                    current.lights[i+1][j]=0; 
                }
                if(current.lights[i][j+1]==0){
                    current.lights[i][j+1]=1; 
                }else{
                    current.lights[i][j+1]=0; 
                } 
            }
        }else if(j==4){
            if(current.lights[i][j]==0){
                current.lights[i][j]=1; 
                if(current.lights[i-1][j]==0){
                    current.lights[i-1][j]=1; 
                }else{
                    current.lights[i-1][j]=0; 
                }
                if(current.lights[i+1][j]==0){
                    current.lights[i+1][j]=1; 
                }else{
                    current.lights[i+1][j]=0; 
                }
                if(current.lights[i][j-1]==0){ 
                    current.lights[i][j-1]=1; 
                }else{
                    current.lights[i][j-1]=0; 
                }
            }else{
                current.lights[i][j]=0; 
                if(current.lights[i-1][j]==0){
                    current.lights[i-1][j]=1; 
                }else{
                    current.lights[i-1][j]=0; 
                }
                if(current.lights[i+1][j]==0){
                    current.lights[i+1][j]=1; 
                }else{
                    current.lights[i+1][j]=0; 
                }
                if(current.lights[i][j-1]==0){
                    current.lights[i][j-1]=1; 
                }else{
                    current.lights[i][j-1]=0; 
                }  
            }
        }else{
            if(current.lights[i][j]==0){
                current.lights[i][j]=1; 
                if(current.lights[i-1][j]==0){ 
                    current.lights[i-1][j]=1; 
                }else{
                    current.lights[i-1][j]=0; 
                }
                if(current.lights[i+1][j]==0){
                    current.lights[i+1][j]=1; 
                }else{
                    current.lights[i+1][j]=0; 
                }
                if(current.lights[i][j+1]==0){ 
                    current.lights[i][j+1]=1; 
                }else{
                    current.lights[i][j+1]=0; 
                } 
                if(current.lights[i][j-1]==0){
                    current.lights[i][j-1]=1; 
                }else{
                    current.lights[i][j-1]=0; 
                }
            }else{
                current.lights[i][j]=0; 
                if(current.lights[i-1][j]==0){
                    current.lights[i-1][j]=1; 
                }else{
                    current.lights[i-1][j]=0; 
                }
                if(current.lights[i+1][j]==0){
                    current.lights[i+1][j]=1; 
                }else{
                    current.lights[i+1][j]=0; 
                }
                if(current.lights[i][j+1]==0){
                    current.lights[i][j+1]=1; 
                }else{
                    current.lights[i][j+1]=0; 
                } 
                if(current.lights[i][j-1]==0){
                    current.lights[i][j-1]=1; 
                }else{
                    current.lights[i][j-1]=0; 
                }  
            }
        }
        current.prev.add(a);
        
		return current;
	}

	public static Boolean GoalTest(State current) {
        int k = 0;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(current.lights[i][j] == 0){
                    k++;
                }
            }
        }
        if(k == 25) return true;
        else return false;
    }
   
}
