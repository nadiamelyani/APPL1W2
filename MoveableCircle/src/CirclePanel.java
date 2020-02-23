// ******************************************************************
// CirclePanel.java
//
// A panel with a circle drawn in the center and buttons on the
// bottom that move the circle.
// ******************************************************************
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CirclePanel extends JPanel
{
    private final int CIRCLE_SIZE = 50;
    private int x,y;
    private int frameX, frameY;
    private Color c;
    //---------------------------------------------------------------
    // Set up circle and buttons to move it.
    //---------------------------------------------------------------
    public CirclePanel(int width, int height, int frameX, int frameY)
    {
        // Set coordinates so circle starts in middle
        x = (width/2)-(CIRCLE_SIZE/2);
        y = (height/2)-(CIRCLE_SIZE/2);
        this.frameX = frameX;
        this.frameY = frameY;
        c = Color.green;
        // Need a border layout to get the buttons on the bottom
        this.setLayout(new BorderLayout());
        // Create buttons to move the circle
        JButton left = new JButton("Left");
        JButton right = new JButton("Right");
        JButton up = new JButton("Up");
        JButton down = new JButton("Down");
        // Add listeners to the buttons
        left.addActionListener(new MoveListener(-20,0));
        right.addActionListener(new MoveListener(20,0));
        up.addActionListener(new MoveListener(0,-20));
        down.addActionListener(new MoveListener(0,20));

        // Need a panel to put the buttons on or they'll be on
        // top of each other.
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(down);
        // Add the button panel to the bottom of the main panel
        this.add(buttonPanel, "South");
        
        left.setMnemonic('L');
        right.setMnemonic('R');
        up.setMnemonic('U');
        down.setMnemonic('D');
        
        left.setToolTipText("Press alt + L to move 20px to the left");
        right.setToolTipText("Press alt + R to move 20px to the right");
        up.setToolTipText("Press alt + U to move 20px up");
        down.setToolTipText("Press alt + D to move 20px down");
    }
    //---------------------------------------------------------------
    // Draw circle on CirclePanel
    //---------------------------------------------------------------
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        page.setColor(c);
        page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
    }
    //---------------------------------------------------------------
    // Class to listen for button clicks that move circle.
    //---------------------------------------------------------------
    private class MoveListener implements ActionListener
    {
        private int dx;
        private int dy;
    //---------------------------------------------------------------
    // Parameters tell how to move circle at click.
    //---------------------------------------------------------------
        public MoveListener(int dx, int dy)
        {
            this.dx = dx;
            this.dy = dy;                
        }
    //---------------------------------------------------------------
    // Change x and y coordinates and repaint.
    //---------------------------------------------------------------
        public void actionPerformed(ActionEvent e)
        {    
            boolean inEdge;
            inEdge = true;
            try { 
                edge();
            } catch (Exception exc) {
                x = x;
                y = y;
            }
        }
        
        public void edge() throws Exception {
            int tempX, tempY;
            tempX = x + dx;
            tempY = y + dy;
            if((tempX) < 0 || (tempY += dy) < 0 || tempX > (frameX) || tempY > (frameY)) {
                throw new Exception();
            } else {
                x += dx;
                y += dy;
                repaint();
            }  
        }
    }
}