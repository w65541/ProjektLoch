package lib;

import javax.swing.*;
import java.awt.*;


public class BasicBackgroundPanel extends JPanel
{
private Image background;

    public BasicBackgroundPanel() {
        setLayout( new GridBagLayout() );
    }

    public BasicBackgroundPanel(Image background)
{
this.background = background;
setLayout( new BorderLayout() );
}
public void setImage(Image image)
{
    background = image;
    repaint();
}
public void setIcon(Image image)
{
    background = image;
    repaint();
}
@Override
protected void paintComponent(Graphics g)
{
super.paintComponent(g);

g.drawImage(background, 0, 0, null); // image full size
//g.drawImage(background, 0, 0, getWidth(), getHeight(), null); // image scaled
}

@Override
public Dimension getPreferredSize()
{
return new Dimension(background.getWidth(this), background.getHeight(this));
}
}