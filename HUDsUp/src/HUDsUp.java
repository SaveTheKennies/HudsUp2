import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class HUDsUp {

	
	 private void createAndDisplayGUI()
	    {
	        JFrame frame = new JFrame("HUDs Up");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(1280, 720);
			frame.setResizable(false);

	        CustomPanel contentPane = new CustomPanel();
	        frame.setContentPane(contentPane);
	        frame.pack();
	        frame.setLocationByPlatform(true);
	        frame.setVisible(true);
	    }

	    public static void main(String[] args)
	    {
	        SwingUtilities.invokeLater(new Runnable()
	        {
	            public void run()
	            {
	                new HUDsUp().createAndDisplayGUI();
	            }
	        });
	    }
	}

	class CustomPanel extends JComponent
	{
	    private int spedImageX = 50;
	    private int spedImageY = 460;
	    
	    private int rearImageX = 440;
	    private int rearImageY = 15;
	    
	    private int clockImageX = 450;
	    private int clockImageY = 500;
	    
	    private int phoneImageX = 1060;
	    private int phoneImageY = 200;
	   
	    
	    private int spedIndex;
	    private int rearIndex;
	    private int clockIndex;
	    private int phoneIndex;

	    private ImageIcon clockImage;
	    private ImageIcon spedImage;
	    private ImageIcon rearImage;
	    private ImageIcon phoneImage;
	    private ImageIcon spedFocus;
	    private ImageIcon spedUnfocus;
	    private ImageIcon clockFocus;
	    private ImageIcon clockUnfocus;
	    private ImageIcon rearFocus;
	    private ImageIcon rearUnfocus;
	    private ImageIcon phoneFocus;
	    private ImageIcon phoneUnfocus;

	    private Rectangle spedBounds;
	    private Rectangle rearBounds;
	    private Rectangle clockBounds;
	    private Rectangle phoneBounds;
	    
	    private ImageIcon background;

	    public CustomPanel()
	    {
	        clockImage = new ImageIcon();
	        spedImage = new ImageIcon();
	        rearImage = new ImageIcon();
	        phoneImage = new ImageIcon();
	        try
	        {
	        	
	        	background = new ImageIcon("res/display.png");
	        	
	            spedFocus = new ImageIcon("res/speedometerFocus.png");
	            spedUnfocus = new ImageIcon("res/speedometer.png");
	            
	            clockFocus = new ImageIcon("res/timeFocus.png");
	            clockUnfocus = new ImageIcon("res/timeUnfocus.png");
	            
	            rearFocus = new ImageIcon("res/rearViewFocus.png");
	            rearUnfocus = new ImageIcon("res/rearView.png");
	            
	            phoneFocus = new ImageIcon("res/phoneCallFocus.png");
	            phoneUnfocus = new ImageIcon("res/phoneCallUnfocus.png");
	            
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        spedIndex = 1;
	        clockIndex = 1;
	        rearIndex = 1;
	        phoneIndex = 1;
	        
	        rearImage.setImage(rearUnfocus.getImage());
	        spedImage.setImage(spedUnfocus.getImage());
	        clockImage.setImage(clockUnfocus.getImage());
	        phoneImage.setImage(phoneUnfocus.getImage());

	        spedBounds = new Rectangle(spedImageX - 30,
	                                        spedImageY - 30,
	                                        spedUnfocus.getIconWidth() + 60,
	                                        spedUnfocus.getIconHeight() + 60);  
	        
	        rearBounds = new Rectangle(rearImageX - 30,
                    						rearImageY - 30,
                    						rearUnfocus.getIconWidth() + 60,
                    						rearUnfocus.getIconHeight() + 60);
	        
	        clockBounds = new Rectangle(clockImageX - 30,
						                    clockImageY - 30,
						                    clockUnfocus.getIconWidth() + 60,
						                    clockUnfocus.getIconHeight() + 60);
	        
	        phoneBounds = new Rectangle(phoneImageX - 30,
						                    phoneImageY - 30,
						                    phoneUnfocus.getIconWidth() + 60,
						                    phoneUnfocus.getIconHeight() + 60);
	        
	        setOpaque(true);        
	        addMouseMotionListener(new MouseController());         
	    }

	    private int setSpedImage(int counter)
	    {

	        if (counter == 1)
	        {
	            spedImage = new ImageIcon();
	            spedImage.setImage(spedFocus.getImage());
	            spedBounds = new Rectangle(spedImageX - 30,
	                                        spedImageY - 30,
	                                        spedFocus.getIconWidth() + 60,
	                                        spedFocus.getIconHeight() + 60);
	            repaint();
	            counter++;
	            return (counter);
	        }   
	        else if (counter == 2)
	        {   
	            spedImage = new ImageIcon();    
	            spedImage.setImage(spedUnfocus.getImage());
	            spedBounds = new Rectangle(spedImageX - 30,
	                                        spedImageY - 30,
	                                        spedUnfocus.getIconWidth() + 60,
	                                        spedUnfocus.getIconHeight() + 60);
	            repaint();
	            return (--counter);
	        }
	        return 1;
	    }
	    
	    private int setRearImage(int counter)
	    {

	        if (counter == 1)
	        {
	            rearImage = new ImageIcon();
	            rearImage.setImage(rearFocus.getImage());
	            rearBounds = new Rectangle(rearImageX - 30,
	                                        rearImageY - 30,
	                                        rearFocus.getIconWidth() + 60,
	                                        rearFocus.getIconHeight() + 60);
	            repaint();
	            counter++;
	            return (counter);
	        }   
	        else if (counter == 2)
	        {   
	            rearImage = new ImageIcon();
	            rearImage.setImage(rearUnfocus.getImage());
	            rearBounds = new Rectangle(rearImageX - 30,
	                                        rearImageY - 30,
	                                        rearUnfocus.getIconWidth() + 60,
	                                        rearUnfocus.getIconHeight() + 60);
	            repaint();
	            return (--counter);
	        }
	        return 1;
	    }
	    
	    private int setClockImage(int counter)
	    {

	        if (counter == 1)
	        {
	            clockImage = new ImageIcon();
	            clockImage.setImage(clockFocus.getImage());
	            clockBounds = new Rectangle(clockImageX - 30,
	                                        clockImageY - 30,
	                                        clockFocus.getIconWidth() + 60,
	                                        clockFocus.getIconHeight() + 60);
	            repaint();
	            counter++;
	            return (counter);
	        }   
	        else if (counter == 2)
	        {   
	        	clockImage = new ImageIcon();
	            clockImage.setImage(clockUnfocus.getImage());
	            clockBounds = new Rectangle(clockImageX - 30,
	                                        clockImageY - 30,
	                                        clockUnfocus.getIconWidth() + 60,
	                                        clockUnfocus.getIconHeight() + 60);
	            repaint();
	            return (--counter);
	        }
	        return 1;
	    }
	    
	    private int setPhoneImage(int counter)
	    {

	        if (counter == 1)
	        {
	            phoneImage = new ImageIcon();
	            phoneImage.setImage(phoneFocus.getImage());
	            phoneBounds = new Rectangle(phoneImageX - 30,
	                                        phoneImageY - 30,
	                                        phoneFocus.getIconWidth() + 60,
	                                        phoneFocus.getIconHeight() + 60);
	            repaint();
	            counter++;
	            return (counter);
	        }   
	        else if (counter == 2)
	        {   
	            phoneImage = new ImageIcon();
	            phoneImage.setImage(phoneUnfocus.getImage());
	            phoneBounds = new Rectangle(phoneImageX - 30,
	                                        phoneImageY - 30,
	                                        phoneUnfocus.getIconWidth() + 60,
	                                        phoneUnfocus.getIconHeight() + 60);
	            repaint();
	            return (--counter);
	        }
	        return 1;
	    }

	    @Override
	    public Dimension getPreferredSize()
	    {
	        return (new Dimension(1280, 720));
	    }

	    @Override
	    public void paintComponent(Graphics g)
	    { 
	        g.clearRect(0, 0, getWidth(), getHeight());
	        g.drawImage(background.getImage(), 0, 0, null);
	        g.drawImage(spedImage.getImage(), spedImageX, spedImageY, null);
	        g.drawImage(clockImage.getImage(), clockImageX, clockImageY, null);
	        g.drawImage(rearImage.getImage(), rearImageX, rearImageY, null);
	        g.drawImage(phoneImage.getImage(), phoneImageX, phoneImageY, null);
	        super.paintComponent(g);        
	    }

	    private class MouseController implements MouseMotionListener
	    {
	        public void mouseDragged(MouseEvent e) {
	        	
	        }
	    	
	    	public void mouseMoved(MouseEvent me)
	        {           
	            int xHitOnPanel = me.getX();
	            int yHitOnPanel = me.getY();

	            if (spedBounds.contains(xHitOnPanel, yHitOnPanel)) {
	            	if(spedIndex ==1) {
	                	spedIndex = setSpedImage(spedIndex);
	            	}
	            } else {
	            	if(spedIndex ==2) {
	            		spedIndex = setSpedImage(spedIndex);
	            	}
	            } 
	            
	            if (rearBounds.contains(xHitOnPanel, yHitOnPanel)) {
	            	if(rearIndex ==1) {
	            		rearIndex = setRearImage(rearIndex);
	            	}
	            } else {
	            	if(rearIndex ==2) {
	            		rearIndex = setRearImage(rearIndex);
	            	}
	            } 
	            
	            if (clockBounds.contains(xHitOnPanel, yHitOnPanel)){
	            	if(clockIndex == 1) {
	            		clockIndex = setClockImage(clockIndex);
	            	}
	            } else {
	            	if(clockIndex == 2) {
	            		clockIndex = setClockImage(clockIndex);
	            	}
	            }
	            
	            if (phoneBounds.contains(xHitOnPanel, yHitOnPanel)){
	            	if(phoneIndex == 1) {
	            		phoneIndex = setPhoneImage(phoneIndex);
	            	}
	            } else {
	            	if(phoneIndex == 2) {
	            		phoneIndex = setPhoneImage(phoneIndex);
	            	}
	            }
	        }
	    }
}
