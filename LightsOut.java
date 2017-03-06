import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class LightsOut{

    static int[][] light= new int[5][5];
	public static void main(String[] args){

		try { 
            BufferedReader reader = new BufferedReader(new FileReader("lightsout.in")); 
             
            Scanner scan = new Scanner(System.in); 
            String line; 
            int i = 0;

	        while ((line = reader.readLine()) != null) {
	            String[] vals = line.trim().split(" ");

	            for (int j = 0; j < 5; j++) {
	                light[i][j] = Integer.parseInt(vals[j]);
	            }

	            i++;
	        } 
            reader.close();
            
        }catch (Exception e){}

		JFrame frame = new JFrame("Lights Out");
		frame.setPreferredSize(new Dimension(300,300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(5,5));

		
        JButton[][] button = new JButton[5][5];

        for (int i=0; i<5; i++){
        	for (int j=0; j<5; j++){
        		if(light[i][j]==0){
                    button[i][j] = new JButton();
	        		button[i][j].setBackground(Color.black);
        		}else{
                    button[i][j] = new JButton();
        			button[i][j].setBackground(Color.white);
        		}

                final JButton[][] buttons = button;
                final int[][] lights = light;
                final int row = i;
                final int col = j;

                button[i][j].addActionListener(new ActionListener(){ 
                    public void actionPerformed(ActionEvent e){
                        if(row==0 && col==0){
                            if(lights[row][col]==0){
                                buttons[row][col].setBackground(Color.white);
                                lights[row][col]=1; 
                                if(lights[row+1][col]==0){
                                    buttons[row+1][col].setBackground(Color.white); 
                                    lights[row+1][col]=1; 
                                }else{
                                    buttons[row+1][col].setBackground(Color.black);
                                    lights[row+1][col]=0; 
                                }
                                if(lights[row][col+1]==0){
                                    buttons[row][col+1].setBackground(Color.white); 
                                    lights[row][col+1]=1; 
                                }else{
                                    buttons[row][col+1].setBackground(Color.black);
                                    lights[row][col+1]=0; 
                                } 
                            }else{
                                buttons[row][col].setBackground(Color.black);
                                lights[row][col]=0; 
                                if(lights[row+1][col]==0){
                                    buttons[row+1][col].setBackground(Color.white); 
                                    lights[row+1][col]=1; 
                                }else{
                                    buttons[row+1][col].setBackground(Color.black);
                                    lights[row+1][col]=0; 
                                }
                                if(lights[row][col+1]==0){
                                    buttons[row][col+1].setBackground(Color.white); 
                                    lights[row][col+1]=1; 
                                }else{
                                    buttons[row][col+1].setBackground(Color.black);
                                    lights[row][col+1]=0; 
                                } 
                            }
                        }else if(row==4 && col==0){
                            if(lights[row][col]==0){
                                buttons[row][col].setBackground(Color.white);
                                lights[row][col]=1; 
                                if(lights[row-1][col]==0){
                                    buttons[row-1][col].setBackground(Color.white); 
                                    lights[row-1][col]=1; 
                                }else{
                                    buttons[row-1][col].setBackground(Color.black);
                                    lights[row-1][col]=0; 
                                }
                                if(lights[row][col+1]==0){
                                    buttons[row][col+1].setBackground(Color.white); 
                                    lights[row][col+1]=1; 
                                }else{
                                    buttons[row][col+1].setBackground(Color.black);
                                    lights[row][col+1]=0; 
                                } 
                            }else{
                                buttons[row][col].setBackground(Color.black);
                                lights[row][col]=0; 
                                if(lights[row-1][col]==0){
                                    buttons[row-1][col].setBackground(Color.white); 
                                    lights[row-1][col]=1; 
                                }else{
                                    buttons[row-1][col].setBackground(Color.black);
                                    lights[row-1][col]=0; 
                                }
                                if(lights[row][col+1]==0){
                                    buttons[row][col+1].setBackground(Color.white); 
                                    lights[row][col+1]=1; 
                                }else{
                                    buttons[row][col+1].setBackground(Color.black);
                                    lights[row][col+1]=0; 
                                } 
                            }

                        }else if(row==0 && col==4){
                            if(lights[row][col]==0){
                                buttons[row][col].setBackground(Color.white);
                                lights[row][col]=1; 
                                if(lights[row+1][col]==0){
                                    buttons[row+1][col].setBackground(Color.white); 
                                    lights[row+1][col]=1; 
                                }else{
                                    buttons[row+1][col].setBackground(Color.black);
                                    lights[row+1][col]=0; 
                                }
                                if(lights[row][col-1]==0){
                                    buttons[row][col-1].setBackground(Color.white); 
                                    lights[row][col-1]=1; 
                                }else{
                                    buttons[row][col-1].setBackground(Color.black);
                                    lights[row][col-1]=0; 
                                } 
                            }else{
                                buttons[row][col].setBackground(Color.black);
                                lights[row][col]=0; 
                                if(lights[row+1][col]==0){
                                    buttons[row+1][col].setBackground(Color.white); 
                                    lights[row+1][col]=1; 
                                }else{
                                    buttons[row+1][col].setBackground(Color.black);
                                    lights[row+1][col]=0; 
                                }
                                if(lights[row][col-1]==0){
                                    buttons[row][col-1].setBackground(Color.white); 
                                    lights[row][col-1]=1; 
                                }else{
                                    buttons[row][col-1].setBackground(Color.black);
                                    lights[row][col-1]=0; 
                                } 
                            }
                            
                        }else if(row==4 && col==4){
                            if(lights[row][col]==0){
                                buttons[row][col].setBackground(Color.white);
                                lights[row][col]=1; 
                                if(lights[row-1][col]==0){
                                    buttons[row-1][col].setBackground(Color.white); 
                                    lights[row-1][col]=1; 
                                }else{
                                    buttons[row-1][col].setBackground(Color.black);
                                    lights[row-1][col]=0; 
                                }
                                if(lights[row][col-1]==0){
                                    buttons[row][col-1].setBackground(Color.white); 
                                    lights[row][col-1]=1; 
                                }else{
                                    buttons[row][col-1].setBackground(Color.black);
                                    lights[row][col-1]=0; 
                                } 
                            }else{
                                buttons[row][col].setBackground(Color.black);
                                lights[row][col]=0; 
                                if(lights[row-1][col]==0){
                                    buttons[row-1][col].setBackground(Color.white); 
                                    lights[row-1][col]=1; 
                                }else{
                                    buttons[row-1][col].setBackground(Color.black);
                                    lights[row-1][col]=0; 
                                }
                                if(lights[row][col-1]==0){
                                    buttons[row][col-1].setBackground(Color.white); 
                                    lights[row][col-1]=1; 
                                }else{
                                    buttons[row][col-1].setBackground(Color.black);
                                    lights[row][col-1]=0; 
                                } 
                            }
                        }else if(row==4){
                            if(lights[row][col]==0){
                                buttons[row][col].setBackground(Color.white);
                                lights[row][col]=1; 
                                if(lights[row-1][col]==0){
                                    buttons[row-1][col].setBackground(Color.white); 
                                    lights[row-1][col]=1; 
                                }else{
                                    buttons[row-1][col].setBackground(Color.black);
                                    lights[row-1][col]=0; 
                                }
                                if(lights[row][col+1]==0){
                                    buttons[row][col+1].setBackground(Color.white); 
                                    lights[row][col+1]=1; 
                                }else{
                                    buttons[row][col+1].setBackground(Color.black);
                                    lights[row][col+1]=0; 
                                } 
                                if(lights[row][col-1]==0){
                                    buttons[row][col-1].setBackground(Color.white); 
                                    lights[row][col-1]=1; 
                                }else{
                                    buttons[row][col-1].setBackground(Color.black);
                                    lights[row][col-1]=0; 
                                }
                            }else{
                                buttons[row][col].setBackground(Color.black); 
                                lights[row][col]=0; 
                                if(lights[row-1][col]==0){
                                    buttons[row-1][col].setBackground(Color.white); 
                                    lights[row-1][col]=1; 
                                }else{
                                    buttons[row-1][col].setBackground(Color.black);
                                    lights[row-1][col]=0; 
                                }
                                if(lights[row][col+1]==0){
                                    buttons[row][col+1].setBackground(Color.white); 
                                    lights[row][col+1]=1; 
                                }else{
                                    buttons[row][col+1].setBackground(Color.black);
                                    lights[row][col+1]=0; 
                                } 
                                if(lights[row][col-1]==0){
                                    buttons[row][col-1].setBackground(Color.white); 
                                    lights[row][col-1]=1; 
                                }else{
                                    buttons[row][col-1].setBackground(Color.black);
                                    lights[row][col-1]=0; 
                                }  
                            }
                        }else if(row==0){
                            if(lights[row][col]==0){
                                buttons[row][col].setBackground(Color.white);
                                lights[row][col]=1; 
                                if(lights[row+1][col]==0){
                                    buttons[row+1][col].setBackground(Color.white); 
                                    lights[row+1][col]=1; 
                                }else{
                                    buttons[row+1][col].setBackground(Color.black);
                                    lights[row+1][col]=0; 
                                }
                                if(lights[row][col+1]==0){
                                    buttons[row][col+1].setBackground(Color.white); 
                                    lights[row][col+1]=1; 
                                }else{
                                    buttons[row][col+1].setBackground(Color.black);
                                    lights[row][col+1]=0; 
                                } 
                                if(lights[row][col-1]==0){
                                    buttons[row][col-1].setBackground(Color.white); 
                                    lights[row][col-1]=1; 
                                }else{
                                    buttons[row][col-1].setBackground(Color.black);
                                    lights[row][col-1]=0; 
                                }
                            }else{
                                buttons[row][col].setBackground(Color.black); 
                                lights[row][col]=0; 
                                if(lights[row+1][col]==0){
                                    buttons[row+1][col].setBackground(Color.white); 
                                    lights[row+1][col]=1; 
                                }else{
                                    buttons[row+1][col].setBackground(Color.black);
                                    lights[row+1][col]=0; 
                                }
                                if(lights[row][col+1]==0){
                                    buttons[row][col+1].setBackground(Color.white); 
                                    lights[row][col+1]=1; 
                                }else{
                                    buttons[row][col+1].setBackground(Color.black);
                                    lights[row][col+1]=0; 
                                } 
                                if(lights[row][col-1]==0){
                                    buttons[row][col-1].setBackground(Color.white); 
                                    lights[row][col-1]=1; 
                                }else{
                                    buttons[row][col-1].setBackground(Color.black);
                                    lights[row][col-1]=0; 
                                }  
                            }
                        }else if(col==0){
                            if(lights[row][col]==0){
                                buttons[row][col].setBackground(Color.white);
                                lights[row][col]=1; 
                                if(lights[row-1][col]==0){
                                    buttons[row-1][col].setBackground(Color.white); 
                                    lights[row-1][col]=1; 
                                }else{
                                    buttons[row-1][col].setBackground(Color.black);
                                    lights[row-1][col]=0; 
                                }
                                if(lights[row+1][col]==0){
                                    buttons[row+1][col].setBackground(Color.white); 
                                    lights[row+1][col]=1; 
                                }else{
                                    buttons[row+1][col].setBackground(Color.black);
                                    lights[row+1][col]=0; 
                                }
                                if(lights[row][col+1]==0){
                                    buttons[row][col+1].setBackground(Color.white); 
                                    lights[row][col+1]=1; 
                                }else{
                                    buttons[row][col+1].setBackground(Color.black);
                                    lights[row][col+1]=0; 
                                } 
                            }else{
                                buttons[row][col].setBackground(Color.black); 
                                lights[row][col]=0; 
                                if(lights[row-1][col]==0){
                                    buttons[row-1][col].setBackground(Color.white); 
                                    lights[row-1][col]=1; 
                                }else{
                                    buttons[row-1][col].setBackground(Color.black);
                                    lights[row-1][col]=0; 
                                }
                                if(lights[row+1][col]==0){
                                    buttons[row+1][col].setBackground(Color.white); 
                                    lights[row+1][col]=1; 
                                }else{
                                    buttons[row+1][col].setBackground(Color.black);
                                    lights[row+1][col]=0; 
                                }
                                if(lights[row][col+1]==0){
                                    buttons[row][col+1].setBackground(Color.white); 
                                    lights[row][col+1]=1; 
                                }else{
                                    buttons[row][col+1].setBackground(Color.black);
                                    lights[row][col+1]=0; 
                                } 
                            }
                        }else if(col==4){
                            if(lights[row][col]==0){
                                buttons[row][col].setBackground(Color.white);
                                lights[row][col]=1; 
                                if(lights[row-1][col]==0){
                                    buttons[row-1][col].setBackground(Color.white); 
                                    lights[row-1][col]=1; 
                                }else{
                                    buttons[row-1][col].setBackground(Color.black);
                                    lights[row-1][col]=0; 
                                }
                                if(lights[row+1][col]==0){
                                    buttons[row+1][col].setBackground(Color.white); 
                                    lights[row+1][col]=1; 
                                }else{
                                    buttons[row+1][col].setBackground(Color.black);
                                    lights[row+1][col]=0; 
                                }
                                if(lights[row][col-1]==0){
                                    buttons[row][col-1].setBackground(Color.white); 
                                    lights[row][col-1]=1; 
                                }else{
                                    buttons[row][col-1].setBackground(Color.black);
                                    lights[row][col-1]=0; 
                                }
                            }else{
                                buttons[row][col].setBackground(Color.black); 
                                lights[row][col]=0; 
                                if(lights[row-1][col]==0){
                                    buttons[row-1][col].setBackground(Color.white); 
                                    lights[row-1][col]=1; 
                                }else{
                                    buttons[row-1][col].setBackground(Color.black);
                                    lights[row-1][col]=0; 
                                }
                                if(lights[row+1][col]==0){
                                    buttons[row+1][col].setBackground(Color.white); 
                                    lights[row+1][col]=1; 
                                }else{
                                    buttons[row+1][col].setBackground(Color.black);
                                    lights[row+1][col]=0; 
                                }
                                if(lights[row][col-1]==0){
                                    buttons[row][col-1].setBackground(Color.white); 
                                    lights[row][col-1]=1; 
                                }else{
                                    buttons[row][col-1].setBackground(Color.black);
                                    lights[row][col-1]=0; 
                                }  
                            }
                        }else{
                            if(lights[row][col]==0){
                                buttons[row][col].setBackground(Color.white);
                                lights[row][col]=1; 
                                if(lights[row-1][col]==0){
                                    buttons[row-1][col].setBackground(Color.white); 
                                    lights[row-1][col]=1; 
                                }else{
                                    buttons[row-1][col].setBackground(Color.black);
                                    lights[row-1][col]=0; 
                                }
                                if(lights[row+1][col]==0){
                                    buttons[row+1][col].setBackground(Color.white); 
                                    lights[row+1][col]=1; 
                                }else{
                                    buttons[row+1][col].setBackground(Color.black);
                                    lights[row+1][col]=0; 
                                }
                                if(lights[row][col+1]==0){
                                    buttons[row][col+1].setBackground(Color.white); 
                                    lights[row][col+1]=1; 
                                }else{
                                    buttons[row][col+1].setBackground(Color.black);
                                    lights[row][col+1]=0; 
                                } 
                                if(lights[row][col-1]==0){
                                    buttons[row][col-1].setBackground(Color.white); 
                                    lights[row][col-1]=1; 
                                }else{
                                    buttons[row][col-1].setBackground(Color.black);
                                    lights[row][col-1]=0; 
                                }
                            }else{
                                buttons[row][col].setBackground(Color.black); 
                                lights[row][col]=0; 
                                if(lights[row-1][col]==0){
                                    buttons[row-1][col].setBackground(Color.white); 
                                    lights[row-1][col]=1; 
                                }else{
                                    buttons[row-1][col].setBackground(Color.black);
                                    lights[row-1][col]=0; 
                                }
                                if(lights[row+1][col]==0){
                                    buttons[row+1][col].setBackground(Color.white); 
                                    lights[row+1][col]=1; 
                                }else{
                                    buttons[row+1][col].setBackground(Color.black);
                                    lights[row+1][col]=0; 
                                }
                                if(lights[row][col+1]==0){
                                    buttons[row][col+1].setBackground(Color.white); 
                                    lights[row][col+1]=1; 
                                }else{
                                    buttons[row][col+1].setBackground(Color.black);
                                    lights[row][col+1]=0; 
                                } 
                                if(lights[row][col-1]==0){
                                    buttons[row][col-1].setBackground(Color.white); 
                                    lights[row][col-1]=1; 
                                }else{
                                    buttons[row][col-1].setBackground(Color.black);
                                    lights[row][col-1]=0; 
                                }  
                            }
                        }
                        checkLights();
                    }
                });
        		frame.add(button[i][j]);
        	}
        }



        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    static public void checkLights(){
        int k = 0;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(light[i][j] == 0){
                    k++;
                }
            }
        }
        if(k == 25){
            JOptionPane.showMessageDialog(null, "Congatulations! You Won!");
            System.exit(0);
        }
    }
}
        

   
