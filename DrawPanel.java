import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import java.util.Collections;
import java.util.Comparator;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Font;
import java.util.ArrayList;

import java.util.Random;

public class DrawPanel extends JPanel{
    private Random rand;
    private ArrayList<String> nameList;
    private ArrayList<String> pickingHat;

    public DrawPanel(){
        System.out.println("DRAW PANEL MADE");
        rand = new Random();
        nameList = new ArrayList<String>();
        pickingHat = new ArrayList<String>();
    }

    public void addName(String name){
        nameList.add(name);
        repaint();
    }

    public void pickNext(){
        int index = rand.nextInt(pickingHat.size());
        JOptionPane.showMessageDialog(new JFrame("Next Player"), pickingHat.get(index) + ", you're up!");
        pickingHat.remove(index);
        repaint();
    }

    public void reset(){
        nameList.clear();
        repaint();
    }

    public void paintComponent(Graphics g){  
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("Purisa", 1, 15));
        g2.drawString("Original List", 5, 25);
        g2.setFont(new Font("Purisa", 0, 15));
        for(int i = 0; i < nameList.size(); i++){
            g2.drawString("-" + nameList.get(i), 15, i * 15 + 40);
        }

        g2.drawLine(120, 0, 120, super.getHeight());
        if(pickingHat.isEmpty()){
            for(String i : nameList){
                pickingHat.add(i);
            }
        }

        g2.setFont(new Font("Purisa", 1, 15));
        g2.drawString("Current List", 125, 25);
        g2.setFont(new Font("Purisa", 0, 15));
        for(int i = 0; i < pickingHat.size(); i++){
            g2.drawString("-" + pickingHat.get(i), 135, i * 15 + 40);
        }
    }
}