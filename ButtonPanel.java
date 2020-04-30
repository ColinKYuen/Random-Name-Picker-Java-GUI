import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileFilter;
import java.io.File;

public class ButtonPanel{
    private JPanel buttonPanel;
    private JButton importList;
    private JButton nextPlayer;
    private JButton clearList;

    private DrawPanel drawPanel;

    public ButtonPanel(){
        importList();
        nextPlayer();
        clearList();

        putInPanel();
        System.out.println("BUTTONS PANEL MADE");
    }

    public void inititateOther(DrawPanel draw){
        drawPanel = draw;
    }

    public void importList(){
        importList = new JButton("Import List");
        importList.setSize(50, 50);
        class importListListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
                System.out.println("importList");
                try{
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setAcceptAllFileFilterUsed(false);
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
                    fileChooser.addChoosableFileFilter(filter);
                    fileChooser.showOpenDialog(null);
                    File myFile = fileChooser.getSelectedFile();
                    Scanner myScanner = new Scanner(myFile);
                    while(myScanner.hasNextLine()){
                        String name = myScanner.nextLine();
                        drawPanel.addName(name);
                        System.out.println(name);
                    }
                    myScanner.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                    System.out.println("\nLol im not dealing with it\n");
                }
                
            }
        }
        ActionListener listener = new importListListener();
        importList.addActionListener(listener);
    }

    public void clearList(){
        clearList = new JButton("Clear List");
        clearList.setSize(50, 50);
        class clearListListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
                System.out.println("clearList");
                drawPanel.reset();
            }
        }
        ActionListener listener = new clearListListener();
        clearList.addActionListener(listener);
    }

    public void nextPlayer(){
        nextPlayer = new JButton("Next Player");
        nextPlayer.setSize(50, 50);
        class nextPlayerListener implements ActionListener{
            public void actionPerformed(ActionEvent event){
                System.out.println("nextPlayer");
                drawPanel.pickNext();
            }
        }
        ActionListener listener = new nextPlayerListener();
        nextPlayer.addActionListener(listener);
    }

    private void putInPanel(){
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(importList);
        buttonPanel.add(clearList);
        buttonPanel.add(nextPlayer);
    }

    public JPanel getPanel(){
        return buttonPanel;
    }
}