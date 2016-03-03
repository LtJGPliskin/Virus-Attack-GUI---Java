/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virus_example;

import javax.swing.JFrame;

/**
 *
 * @author boucher
 */
public class Board_Initialization extends JFrame
{
    
public Board_Initialization() 
{
    super("Virus Example");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add(new Parameter_Panel());
    pack();
    setLocationRelativeTo(null);    //put the gui in the center of the screen
    setVisible(true);
}
public Board_Initialization(int a, int b, int c, int d, int e) 
{
    super("Virus Example");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add(new Virus_Example(a,b,c, d, e));
    pack();
    setVisible(true);
}
public static void main(String[] args) 
{
    Board_Initialization newGame = new Board_Initialization();   
}
}
