// This Project have completed by  Mohammad Adib sereshki
		
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean drawing;
	public boolean drawErase;
	public Color penColor = Color.red;
	private ArrayList<DrawPanel.ColorPoint> points;
	private final int POINT_SIZE = 10;
	Point erasePoint;

	public DrawPanel() {
		setBackground(Color.white);
		setPreferredSize(new Dimension(320, 200));
		this.drawing = false;
		this.drawErase = false;
		this.points = new ArrayList<ColorPoint>();
		this.erasePoint = new Point();
		DrawPanel.DrawingListener listener = new DrawPanel.DrawingListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}

	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		for (DrawPanel.ColorPoint p : this.points) {
			page.setColor(p.c);
			page.fillOval(p.p.x - 5, p.p.y - 5, 10, 10);
		}
		if (this.drawErase) {
			page.setColor(Color.black);
			page.drawOval(this.erasePoint.x - 5, this.erasePoint.y - 5, 10, 10);
		}
	}

	public void clear() {
		this.points = new ArrayList<ColorPoint>();
		repaint();
	}

	private class DrawingListener implements MouseListener, MouseMotionListener {
		private DrawingListener() {
		}

		public void mousePressed(MouseEvent event) {
		}

		public void mouseClicked(MouseEvent event) {
			DrawPanel.this.drawing = (!DrawPanel.this.drawing);
		}

		public void mouseReleased(MouseEvent event) {
		}

		public void mouseDragged(MouseEvent event) {
		}

		public void mouseEntered(MouseEvent event) {
		}

		public void mouseExited(MouseEvent event) {
		}

		public void mouseMoved(MouseEvent event) {
			if (DrawPanel.this.drawing) {
				Point p = event.getPoint();
				DrawPanel.this.points.add(new DrawPanel.ColorPoint(p, DrawPanel.this.penColor));
				DrawPanel.this.repaint();
			}
			if (DrawPanel.this.drawErase) {
				DrawPanel.this.erasePoint = event.getPoint();
			}
		}
	}

	private class ColorPoint {
		private Point p;
		private Color c;

		public ColorPoint(Point p, Color c) {
			this.p = p;
			this.c = c;
		}
	}
}
