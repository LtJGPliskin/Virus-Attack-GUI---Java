package virus_example;
import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * MinePanel class to build the face and the back of the game 
 *
 * @author Austin Boucher
 * @version 1 March 2016
 */
public class Virus_Example extends JPanel
{
private int w;//holds number of initial infected computers
private int outgoingInfections;//holds the number of maximum number of outgoing infections
private int infectionRate;      //holds the infection rate
private float vuln;             //holds the invulnerability rate
private int possibleInfections; //holds the max number of infections until pc crashes
private Spot [][] board;                    //generates a spot class board
private int[][] output = new int [100][100];//used to assure multiple infections don't go out
private int column = 100;                    //sets the number of columns
private int rows = 100;                      //sets the number of rows
private final int size = (500);             //Holds the size of the board
public Virus_Example(int pc_infected, float inVuln, int ininfectionRate, int inoutgoingInfectings, int inPossibleInfection)//start the program                          
{
    possibleInfections = inPossibleInfection;//reads in possible maximum infections
    if(possibleInfections < 3)
    {
        possibleInfections = 3;//if user input less than 3, makes it 3
    }
    setPreferredSize(new Dimension(size, size));//Creates the visable game
    addMouseListener(new MineMouseListener());  //allows for clicking
    w = 1;                      //sets the minimum number of initial computers to 1        
    outgoingInfections = inoutgoingInfectings;//reads in outgoing infections
    infectionRate = ininfectionRate;          //reads in infection rate
    vuln = inVuln;                            //reads in invulnerablity rate
    setPreferredSize(new Dimension(size, size));//Creates the visable game
    board = new Spot[column][rows];         //creates a board of class spot
    if(pc_infected > w)                     //if initial infection rate is greater than 1, records that number
    {
    w = pc_infected;
    }
    initialize();                           //initializes the board
}
private void security()                     //wipes the invulnerability and resets it based on the vuln parameter
{
    for(int x = 0; x < column; x++)         //wipes the board
        {
        for(int y = 0; y < rows; y++)
            {
                board[x][y].security = false;
            }
        }
    for(int x = 0; x < column; x++)         //randomly grants spots invulnerability based on the vuln parameter
        {
            for(int y = 0; y < rows; y++)
            {
                int p = (int)((Math.random() * 100));
                if(p < vuln)                //if the random number is less than the vuln number, grants the spot invulnerability
                {
                    if(board[x][y].first_infect != true)//if the spot isn't already infected grants the spot invulnerability
                    {
                    board[x][y].security = true;
                    }
                }
                
            }
        }
}
private void infect()                       //infects spots based on inputted parameters
{
    for(int x = 0; x < column; x++)         //used to detect if a spot is infected
        {
            for(int y = 0; y < rows; y++)   //used to detect if a spot is infected
            {
         if(board[x][y].first_infect == true && board[x][y].diedOut == false)//if the spot is infected and hasnt crashed, runs the code
                {
             int g = (int)(Math.random() * outgoingInfections);              //holds total possible outgoing infections range from 1 - input
             if(g < 1)
             {
                 g = 1;
             }
             for(int z = 0; z < g; z++)                                     //runs g amount of times 
             {
                int p = (int)(Math.random() * 100);                         //used to find a random spot
                int l = (int)(Math.random() * 100);                         //used to find a random spot
                int t = (int)(Math.random() * 100);                         //used to check against the infection rate
            if(board[p][l].security == false)                               //used to account for invulnerability
              {
                if(board[p][l].first_infect == false && output[p][l] != 1)                       //if the spot is vulnerable and hasnt been infected, infects the spot and increments infections by one
                {
                    board[p][l].infections++;
                    output[p][l] = 1;
                }
                if(board[p][l].first_infect == true && t < infectionRate)   //if the spot has been infected and the random number t is less than the infection rate, reinfects the spot
                    {
                     board[p][l].infections++;          
                     output[p][l] = 2;
                    }
                if(board[p][l].infections >= possibleInfections)            //if the times the spot has been infected gets passed the crash parameter, kills the spot
                {
                        board[p][l].diedOut = true;
                }
                }
                }
                }   
        }}
    for(int x = 0; x < column; x++)                       //stops multiple readings of newly infected spots per generation
        {
        for(int y = 0; y < rows; y++)                       
            {
                if(output[x][y] == 1)                     //if the spot is flagged as 1, infects the spot
                {
                    board[x][y].first_infect = true;
                }
                if(output[x][y] == 2)
                {
                   board[x][y].first_infect = true;       //if the spot is flagged as 2, reinfects the spot
                   board[x][y].second_infect = true;
                }
            }
        }
}
class MineMouseListener implements MouseListener          //listens to clicks
{
        @Override
    public void mouseClicked(MouseEvent e) 
    {
        security();                                         //wipes and reapplies securities to the board
        infect();                                           //infects the board
       repaint();                                           //repaints the board
       }
        @Override
        public void mousePressed(MouseEvent e) {
            //System.out.println("press");
        }     
        @Override
        public void mouseReleased(MouseEvent e) {
            //System.out.println("release");
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            //System.out.println("mouse entered");
        }
        @Override
        public void mouseExited(MouseEvent e) {
            //System.out.println("mouse exited");
        }
        
}
private void initialize()                   //fills the board with blank variables
{
    for(int x = 0; x < column; x++)         //fills the check array with 0s
    {
        for(int y = 0; y < column; y++)
        {
            output[x][y] = 0;
        }
    }
    setPreferredSize(new Dimension(size, size));//Creates the visable game
    board = new Spot[column][rows];         //creates a board of class spot
    for (int i = 0; i < column; i++)        
    {
    for (int j = 0; j < rows; j++) 
     {
         board[i][j] = new Spot(false, false, false, false, 0);
     }
    }
    for(int i = 0; i < w; i++)              //generates an inital spot to infect
    {
    int p = (int)(Math.random() * 100);
    int l = (int)(Math.random() * 100);
    board[p][l].first_infect = true;
    }
}

@Override
public void paint(Graphics g)               //generates the board's colors
{
        g.setColor(Color.BLACK);            //sets the color
        int a;                              //holds the row number (times 5)
        int b = 0;                          //holds the column number (times 5)
        a = 0;                              //initializes the row number
       
        for(int x = 0; x < column; x++)     //paints the board depending on the spots variables
        {
            b = 0;
            for(int y = 0; y < rows; y++)
            {
            g.setColor(Color.BLACK); 
            g.fillRect(a, b, 5, 5);
            g.setColor(Color.RED);
            if(board[x][y].first_infect == true && board[x][y].second_infect != true)//if the spot is infected, paints it red
            {
            g.fillRect(a, b, 5, 5);
            }
            g.setColor(Color.CYAN);
            if(board[x][y].second_infect == true && board[x][y].diedOut != true)//if the spot is double infected, paints it cyan
            {
                g.fillRect(a, b, 5, 5);
            }
            g.setColor(Color.YELLOW);
            if(board[x][y].diedOut == true)      //if the spot is flooded, paints it yellow
            {
                g.fillRect(a, b, 5, 5);
            }
            g.setColor(Color.PINK);
            if(board[x][y].security == true)     //if the spot is invulnerable, paints it pink
            {
                g.fillRect(a, b, 5, 5);
            }
            b += 5;
            }
            a += 5;
        }
    revalidate();                               //revalidates the board
}
}
/**
 *
 * @author Austin Boucher
 */
