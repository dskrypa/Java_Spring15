package clock;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JComponent;
import java.util.*;

/**
 * Analog Clock.
 * 
 * @author Douglas Skrypa
 * @version 1
 */
public class ClockComponent extends JComponent
{
	private static final long serialVersionUID = -8095439838160461120L;

	public void paintComponent(Graphics g)
    {
        final double toRADIAN = Math.PI / 180.0;
        
        //a & b following general equasion of an ellipse 
        final double a = getWidth() / 2;
        final double b = getHeight() / 2; 
        
        Graphics2D g2 = (Graphics2D) g;
        
        Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, getWidth(), getHeight());
        
        g2.setColor(Color.BLACK);
        g2.draw(ellipse);
        
        double faceTheta = 0;
        double fA = a * 7/8;
        double fB = b * 7/8;
        
        for (faceTheta = 0; faceTheta <= 360; faceTheta += 30)
        {
            double fX = fA * Math.cos(faceTheta * toRADIAN) + a;
            double fY = fB * Math.sin(faceTheta * toRADIAN) + b;
            double fX2 = a * Math.cos(faceTheta * toRADIAN) + a;
            double fY2 = b * Math.sin(faceTheta * toRADIAN) + b;
            
            Line2D.Double face = new Line2D.Double(fX,fY,fX2,fY2);
            g2.draw(face);
            
        }
        
        GregorianCalendar time = new GregorianCalendar();
        int hour = time.get(Calendar.HOUR_OF_DAY);
        int min = time.get(Calendar.MINUTE);
        int second = time.get(Calendar.SECOND);
            
        //12 hour clock
        if (hour > 12) 
        {
            hour -= 12;
        }    
        
        //Hour hand calculations
        double degreesPerHour = 30;
        double hourTheta = ((hour - 3) * degreesPerHour * toRADIAN) + ((min * 0.5) * toRADIAN);
        
        double hA = a / 2;
        double hB = b / 2;
        
        double hX = hA * Math.cos(hourTheta) + a;
        double hY = hB * Math.sin(hourTheta) + b;
        
        Line2D.Double hourHand = new Line2D.Double(a,b,hX,hY);
        
        //Minute hand calculations
        double degreesPerMin = 6;
        double minTheta = ((min-15) * degreesPerMin) * toRADIAN;
        
        double mA = a * 3/4;
        double mB = b * 3/4;
        
        double mX = mA * Math.cos(minTheta) + a;
        double mY = mB * Math.sin(minTheta) + b;
        
        Line2D.Double minHand = new Line2D.Double(a,b,mX,mY);
        
        //Second hand calcualtions
        double degreesPerSecond = 6;
        double secTheta = ((second-15) * degreesPerSecond) * toRADIAN;
        
//        double sA = a * 15/16;
//        double sB = b * 15/16;
        
        double sX = mA * Math.cos(secTheta) + a;
        double sY = mB * Math.sin(secTheta) + b;
        
        Line2D.Double secHand = new Line2D.Double(a,b,sX,sY);
        
        //Draws
        g2.draw(hourHand);
        g2.draw(minHand);
        g2.draw(secHand);
    }
}
