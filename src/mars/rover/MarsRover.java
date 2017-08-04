/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mars.rover;

import java.util.Scanner;

/**
 *
 * @author sriram
 */
public class MarsRover {
    public static int x;
    public static int y;
    public static int fx;
    public static int fy;
    public static int ffx=-1;
    public static int ffy=-1;
    public static String direction;
    public static String[] instructions;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Please Enter upper right corner of the plataeu (EX- 5 5)");
        Scanner s=new Scanner(System.in);
        String l1=s.nextLine();
        String[] inCord=l1.split(" ");
        fx=Integer.parseInt(inCord[0]);
        fy=Integer.parseInt(inCord[1]);
        
        for(int j=0;j<2;j++){
        System.out.println("Please Enter the coordinates at which you want to deploy the rover (EX - 1 2 N)");
        String l2=s.nextLine();
        String[] nl2=l2.split(" ");
        x=Integer.parseInt(nl2[0]);
        y=Integer.parseInt(nl2[1]);
        direction=nl2[2];
        System.out.println("Please Enter the instructions to the rover(EX - LMLMLMLMM)");
        String l3=s.nextLine();
        instructions=l3.split("");
        for(int i=0;i<instructions.length;i++){
            if (instructions[i] != null && !instructions[i].isEmpty()){
                if(instructions[i].equals("M")){
              moveRover();
              }
            else{
              changeRoverDirection(instructions[i]);
              }
            }
          }
        ffx=x;
        ffy=y;
        System.out.println("Final Destination of the rover is - "+x+" "+y+" "+direction);
        
       }
        
    }
    
    public static void moveRover(){
          if(direction.equals("W")){
              if(x-1>=0 && (x-1!=ffx || y!=ffy)){
                  x=x-1;
               }
           }
          else if(direction.equals("E")){
              if(x+1<=fx && (x+1!=ffx || y!=ffy)){
                  x=x+1;
              }
          }
          else if(direction.equals("N")){
              if(y+1<=fy && (x!=ffx || y+1!=ffy)){
                  y=y+1;
              }
          }
          else{
              if(y-1>=0 && (x!=ffx || y-1!=ffy)){
                  y=y-1;
              }
          }
    }
    
    public static void changeRoverDirection(String instruction){
        if(direction.equals("N") && instruction.equals("L")){
            direction="W";
        }
        else if(direction.equals("N") && instruction.equals("R")){
           direction="E";
       }
        else if(direction.equals("S") && instruction.equals("L")){
            direction="E";
        }
        else if(direction.equals("S") && instruction.equals("R")){
           direction="W";
       }
        else if(direction.equals("W") && instruction.equals("L")){
            direction="S";
        }
        else if(direction.equals("W") && instruction.equals("R")){
           direction="N";
       }
        else if(direction.equals("E") && instruction.equals("L")){
            direction="N";
        }
        else{
           direction="S";
       }
        
    }
    
}
