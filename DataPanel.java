import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.GridLayout;

public class DataPanel{
    //Instance variables
    private JPanel dataPan;

    private JLabel numOfCir;
    private JTextField fieldNumOfCir;
    private JLabel radOfS;
    private JTextField fieldRadOfS;  
    private JLabel radOfL;
    private JTextField fieldRadOfL;

    private final int FIELD_WIDTH = 10;
    
    public DataPanel(){
        //Construct the labels and textboxes
        numOfCir = createLabel("Number of Circles:");
        numOfCir.setToolTipText("Set the number of circles you would like to create");
        fieldNumOfCir = createTextBox(5);
        radOfS = createLabel("Radius of Smallest Circle:");
        radOfS.setToolTipText("Sets the smallest radius allowed when creating the circles");
        fieldRadOfS = createTextBox(10);
        radOfL = createLabel("Radius of Largest Circle:");
        radOfL.setToolTipText("Sets the largest radius allowed when creating the circles");
        fieldRadOfL = createTextBox(300);

        //Add into a panel
        putInPanel();

        System.out.println("DATA PANEL MADE");
    }

    //Private functions
    private JLabel createLabel(String title){
        JLabel label = new JLabel(title);
        return label;
    }

    private JTextField createTextBox(int defaultValue){
        JTextField field = new JTextField(FIELD_WIDTH);
        field.setText("" + defaultValue);
        field.setEditable(true);
        return field;
    }

    private void putInPanel(){
        dataPan = new JPanel();
        dataPan.setLayout(new GridLayout(1, 6));
        dataPan.add(numOfCir);
        dataPan.add(fieldNumOfCir);

        dataPan.add(radOfS);
        dataPan.add(fieldRadOfS);

        dataPan.add(radOfL);
        dataPan.add(fieldRadOfL);
    }

    //Public functions
    /**
     * Returns the value inside JTextField: fieldNumOfCir
     * @return Integer value inside fieldNumOfCir
     */
    public int getNumField(){
        int ret = Integer.parseInt(fieldNumOfCir.getText());
        return ret;
    }

    
    /**
     * Returns the value inside JTextField: fieldRadOfS
     * @return Integer value inside fieldRadOfS
     */
    public int getRadS(){
        int ret = Integer.parseInt(fieldRadOfS.getText());
        return ret;
    }

    /**
     * Returns the value inside JTextField: fieldRadOfL
     * @return Integer value inside fieldRadOfL
     */
    public int getRadL(){
        int ret = Integer.parseInt(fieldRadOfL.getText());
        return ret;
    }

    /**
     * Returns the reference value to dataPanel
     * @return Reference value of dataPanel
     */
    public JPanel getPanel(){
        return dataPan;
    }
}