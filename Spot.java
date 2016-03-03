/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virus_example;

/**
 *
 * @author boucher
 */
public class Spot {
    public boolean second_infect;                     
    public boolean first_infect;
    public boolean security;
    public boolean diedOut;
    public int infections;
    
    
    public Spot(boolean infirst_infect, boolean insecond_infect, boolean indiedOut, boolean inSecurity, int count)//generates a class that accounts for two varibales
    {
    second_infect = insecond_infect;
    first_infect = infirst_infect;
    diedOut = indiedOut;
    security = inSecurity;
    infections = count;
    }
}
