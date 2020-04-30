import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class MainPanel extends JPanel{
	DataPanel dataPanel;
	ButtonPanel buttonPanel;
	DrawPanel drawPanel;

	public MainPanel(){
		setLayout(new BorderLayout());

		buttonPanel = new ButtonPanel();
		add(buttonPanel.getPanel(), BorderLayout.WEST);

		drawPanel = new DrawPanel();
		add(drawPanel, BorderLayout.CENTER);

		buttonPanel.inititateOther(drawPanel);
	}
}