/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawable;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 *
 * @author ASUS
 */
public class drawable_gif extends JPanel{
    private Image image;


public drawable_gif() {
image = new ImageIcon(getClass().getResource("/drawable/mleb.png")).getImage();
}
@Override
protected void paintComponent(Graphics grphcs){
    super.paintComponent(grphcs);
    Graphics2D gd =(Graphics2D) grphcs.create();
    gd.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    gd.dispose();
}
}
