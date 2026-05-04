package rvt;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class GrafikasPanelis extends JPanel {
  
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawRect(150,150,95,80);
        g.setColor(Color.BLACK);
        g.drawRect(170,180,20,50);
        g.drawRect(207,180,28,28);
        g.setColor(Color.RED);
        g.drawLine(150,150,197,110);
        g.drawLine(197,110,245,150);
        g.setColor(Color.YELLOW);
        g.fillOval(187,120,20,20);
    }
}
