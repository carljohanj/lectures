import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("all")
public class SierpinskiTriangle extends JPanel
{
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 800;
    private int depth;
    private double zoom = 1.0;
    private boolean colorEnabled = true;
    private int zoomCenterX = WIDTH / 2;
    private int zoomCenterY = HEIGHT / 2;

    public SierpinskiTriangle(int depth)
    {
        this.depth = depth;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyChar() == '+')
                {
                    zoom *= 1.2;
                    repaint();
                }
                else if (e.getKeyChar() == '-')
                {
                    zoom /= 1.2;
                    repaint();
                }
                else if (e.getKeyChar() == 'c')
                {
                    colorEnabled = !colorEnabled;
                    repaint();
                }
            }
        });

        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                zoomCenterX = e.getX();
                zoomCenterY = e.getY();
                repaint();
            }
        });

        setFocusable(true);
        requestFocusInWindow();
    }

    public static void main(String[] args)
    {
        String input = JOptionPane.showInputDialog(
                "Ange det rekursiva djupet (Förslag: testa med 0 och öka successivt upp till 10.) \n OBS! Det är en dålig idé att ange högre värden än så som kan resultera i ett Stack Overflow och att datorn fryser!"
        );

        int depth = 5;
        try
        {
            depth = Integer.parseInt(input);
            if (depth < 0)
            {
                JOptionPane.showMessageDialog(null, "Djupet kan inte vara negativt! Använder 5 som defaultvärde.");
                depth = 5;
            }
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Oigltig input. Använder 5 som värde för djupet.");
        }

        JFrame frame = new JFrame("Sierpiński Triangle");
        SierpinskiTriangle trianglePanel = new SierpinskiTriangle(depth);

        JScrollPane scrollPane = new JScrollPane(trianglePanel);
        scrollPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        frame.add(scrollPane);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        int x1 = (int) ((WIDTH / 2 - zoomCenterX) * zoom + zoomCenterX);
        int y1 = (int) ((20 - zoomCenterY) * zoom + zoomCenterY);
        int x2 = (int) ((20 - zoomCenterX) * zoom + zoomCenterX);
        int y2 = (int) ((HEIGHT - 20 - zoomCenterY) * zoom + zoomCenterY);
        int x3 = (int) ((WIDTH - 20 - zoomCenterX) * zoom + zoomCenterX);
        int y3 = (int) ((HEIGHT - 20 - zoomCenterY) * zoom + zoomCenterY);

        drawSierpinski(g, depth, x1, y1, x2, y2, x3, y3, true);
    }

    private void drawSierpinski(Graphics g, int depth, int x1, int y1, int x2, int y2, int x3, int y3, boolean useGreen)
    {
        if (depth == 0)
        {
            int[] xPoints = { x1, x2, x3 };
            int[] yPoints = { y1, y2, y3 };
            if (colorEnabled)
            {
                g.setColor(useGreen ? new Color(34, 139, 34) : new Color(138, 43, 226));
            }
            else
            {
                g.setColor(Color.WHITE);
            }
            g.fillPolygon(xPoints, yPoints, 3);
        }
        else
        {
            int x12 = (x1 + x2) / 2;
            int y12 = (y1 + y2) / 2;
            int x23 = (x2 + x3) / 2;
            int y23 = (y2 + y3) / 2;
            int x31 = (x3 + x1) / 2;
            int y31 = (y3 + y1) / 2;

            drawSierpinski(g, depth - 1, x1, y1, x12, y12, x31, y31, useGreen);
            drawSierpinski(g, depth - 1, x12, y12, x2, y2, x23, y23, !useGreen);
            drawSierpinski(g, depth - 1, x31, y31, x23, y23, x3, y3, useGreen);
        }
    }
}