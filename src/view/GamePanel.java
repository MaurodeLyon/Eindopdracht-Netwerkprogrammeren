package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{

	public GamePanel(){
		setPreferredSize(new Dimension(1080, 720));
		setBackground(Color.BLACK);
		
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D)g;
		g2.setColor(Color.WHITE);
		g2.draw((Shape)new Rectangle2D.Float(20f,20f,1040f,680f));
		Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2.setStroke(dashed);
        g2.drawLine(1080/2, 20, 1080/2, 700);
        g2.setStroke((Stroke) new BasicStroke());
        g2.drawLine(20, 700, 1060, 20);
        g2.drawLine(20, 20,1060, 700);
		
		
	}
}
