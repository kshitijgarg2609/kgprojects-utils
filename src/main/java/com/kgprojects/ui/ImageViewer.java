package com.kgprojects.ui;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.kgprojects.util.ImageLoader;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ImageViewer extends DefaultFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6378364605194706978L;
	private JLabel imgLabel;
	private Rectangle dim = new Rectangle(750, 550);
	public ImageViewer()
	{
		super("Image Viewer");
		getContentPane().setLayout(null);
		
		imgLabel = new JLabel();
		imgLabel.setBackground(Color.CYAN);
		imgLabel.setOpaque(true);
		imgLabel.setBounds(CenterRectangle.getInnerRectangle(getWidth(), getHeight(), dim.width, dim.height));
		getContentPane().add(imgLabel);
		ready();
	}
	public void updateImage(byte img[])throws Exception
	{
		InputStream is = new ByteArrayInputStream(img);
		updateImage(ImageIO.read(is));
		is.close();
	}
	public void updateImage(BufferedImage img)
	{
		imgLabel.setIcon(new ImageIcon(ImageLoader
				.scaledImage(img, imgLabel.getWidth(), imgLabel.getHeight())));
	}
}