package virus_example;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
/**
 *
 *
 * @author Austin Boucher
 * @version 13 Jan 2015
 */
public class Parameter_Panel extends JPanel {

    // back-end: board data
    private JTextField outgoing;//creates a temporary slot for name
    private JTextField cycles;//creates a temporart slot for numbers
    private JTextField probability;//creates a temporart slot for numbers
    private JTextField outgoingInfections;//creates a temporart slot for numbers
    private JTextField possibleInfections;
    private int buttonpress;//keeps count of times a contact has been added

    //constructor
    
    public Parameter_Panel() //makes the board
    {
        setPreferredSize(new Dimension(700, 275));
        setLayout(new BorderLayout());

        //Field with label
        outgoing = new JTextField(15);
        cycles = new JTextField(25);
        probability = new JTextField(35);
        outgoingInfections = new JTextField(25);
        possibleInfections = new JTextField(25);
        JLabel nameLabel2 = new JLabel("Field: ");
        nameLabel2.setLabelFor(outgoing);
        JLabel nameLabel = new JLabel("Field: ");
        nameLabel.setLabelFor(outgoing);
        nameLabel.setLabelFor(probability);

        JPanel fieldsPanel = new JPanel();//creates a grid for the text fields
        fieldsPanel.setLayout(new GridLayout(15,1));
        JLabel myLabel = new JLabel("Already Infected Machines:");
        fieldsPanel.add(myLabel);
        fieldsPanel.add(outgoing);
        JLabel myLabel2 = new JLabel("Chances a computer will be Invulnerable (1 - 100):");
        fieldsPanel.add(myLabel2);
        fieldsPanel.add(cycles);
        JLabel myLabel3 = new JLabel("Reinfection Rate(1 - 100):");
        fieldsPanel.add(myLabel3);
        fieldsPanel.add(probability);
        JLabel myLabel4 = new JLabel("Maximum Outgoing Infections:");
        fieldsPanel.add(myLabel4);
        fieldsPanel.add(outgoingInfections);
        JLabel myLabel5 = new JLabel("Maximum infections before death(minimum 3):");
        fieldsPanel.add(myLabel5);
        fieldsPanel.add(possibleInfections);
        outgoingInfections.setText("1");
        outgoing.setText("1");
        cycles.setText("1");
        probability.setText("1");
        possibleInfections.setText("1");

        //Text area.
       
        //Button:
        
        JButton button = new JButton( new AbstractAction("Run Program")//custom action event for the specific button
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {    
            try
        {
            int a = Integer.parseInt(outgoing.getText());
            int b = Integer.parseInt(cycles.getText());
            int c = Integer.parseInt(probability.getText());
            int d = Integer.parseInt(outgoingInfections.getText());
            int f = Integer.parseInt(possibleInfections.getText());
            Board_Initialization g = new Board_Initialization(a, b, c, d, f);
        }
            catch(NumberFormatException p)
            {
            }
            
            
            }
        }); 
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new GridLayout(1, 1));
        buttonPane.add(button);
        JLabel description = new JLabel("Yellow = flooded Machine");
        JLabel description2 = new JLabel("Pink = Invulnerable Machine");
        JLabel description3 = new JLabel("Black = Fresh Vulnerable Machine");
        JLabel description4 = new JLabel("Red = Single Infection Machine");
        JLabel description5 = new JLabel("Cyan = Multiple Infected Machine");
        fieldsPanel.add(description);
        fieldsPanel.add(description2);
        fieldsPanel.add(description3);
        fieldsPanel.add(description4);
        fieldsPanel.add(description5);
        //pack stuff together
        JPanel pane = new JPanel(new BorderLayout());
        pane.add(buttonPane, BorderLayout.WEST);
        pane.add(fieldsPanel, BorderLayout.EAST);

        add(pane, BorderLayout.CENTER);
    }
    }


    
             
               

