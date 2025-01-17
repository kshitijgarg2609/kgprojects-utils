package com.kgprojects.ui;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
/**
 * @author Kshitij Garg
 */
public class ImageDisplayer extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2230815060267841605L;
	private int width = 800,height = 400;
	private JPanel jp;
	private JTextField imageNumber;
	private JLabel imageScreen;
	private JLabel imageLabelField;
	private JButton previousImageButton;
	private JButton nextImageButton;
	public ImageDisplayer()
	{
		super("Image Display");
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds((w - width) / 2, (h - height) / 2, width, height);
		setResizable(false);
        getContentPane().setLayout(null);
        
        jp = new JPanel();
        jp.setBounds(50, 50, width-100, height-100);
        jp.setLayout(null);
        getContentPane().add(jp);
        
        imageScreen = new JLabel("");
        imageScreen.setBackground(Color.CYAN);
        imageScreen.setOpaque(true);
        imageScreen.setBounds(10, 11, 492, 278);
        jp.add(imageScreen);
        
        previousImageButton = new JButton("Previous Image");
        previousImageButton.setBounds(512, 126, 178, 23);
        jp.add(previousImageButton);
        
        nextImageButton = new JButton("Next Image");
        nextImageButton.setBounds(512, 160, 178, 23);
        jp.add(nextImageButton);
        
        imageNumber = new JTextField();
        imageNumber.setBounds(512, 95, 178, 20);
//        ((AbstractDocument)imageNumber.getDocument()).setDocumentFilter(new DocumentFilter() {
//        @Override
//        public void insertString(FilterBypass fb, int offset, String string
//        		, javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException
//        {
//        	try
//        	{
//        		Integer.parseInt(string);
//        		super.insertString(fb, offset, string, attr);
//        	}
//        	catch(Exception e)
//        	{
//        		
//        	}
//        }
//        });
        jp.add(imageNumber);
        imageNumber.setColumns(10);
        
        imageLabelField = new JLabel("",SwingConstants.CENTER);
        imageLabelField.setBackground(Color.YELLOW);
        imageLabelField.setOpaque(true);
        imageLabelField.setBounds(512, 51, 178, 33);
        jp.add(imageLabelField);
        
        JLabel imagelabelTag = new JLabel("Image Label : ",SwingConstants.CENTER);
        imagelabelTag.setBounds(512, 11, 178, 27);
        jp.add(imagelabelTag);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setVisible(true);
        repaint();
        revalidate();
	}
	public BufferedImage scaledImage(Image a, int w2, int h2)
	{
        BufferedImage b = new BufferedImage(w2, h2, 2);
        Graphics2D g2 = b.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(a, 0, 0, w2, h2, (ImageObserver) null);
        g2.dispose();
        return b;
    }
	public void updateMainScreen(BufferedImage icon)
	{
		imageScreen.setIcon(new ImageIcon(scaledImage(icon, imageScreen.getWidth(), imageScreen.getHeight())));
    }
	public JTextField getImageNumber() {
		return imageNumber;
	}
	public JLabel getImageScreen() {
		return imageScreen;
	}
	public JLabel getImageLabelField() {
		return imageLabelField;
	}
	public JButton getPreviousImageButton() {
		return previousImageButton;
	}
	public JButton getNextImageButton() {
		return nextImageButton;
	}
	
}