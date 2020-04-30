import javax.swing.JFrame;

public class Program{
    private static final int FRAME_WIDTH = 450;
    private static final int FRAME_HEIGHT = 300;

    public static void main(String[] args){  
        JFrame frame = new JFrame("Random Name Picker");
        frame.add(new MainPanel());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }    
}
