package rvt;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class GrafikasPanelis extends JPanel {
  
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(10,10,40,40);
        g.drawLine(50,50,70,60);
        g.fillOval(65,55,30,30);
    }
}
