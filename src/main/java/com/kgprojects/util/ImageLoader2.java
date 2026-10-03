package com.kgprojects.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import org.apache.commons.io.FilenameUtils;
/**
 * @author Kshitij Garg
 */
public class ImageLoader2
{
	public static final Set<String> imgExtensions = new HashSet<>(
			Arrays.asList("jpg","png","PNG","JPG","jpeg","JPEG"));
	public static BufferedImage imageLoaderFromFolder(File dir)
	{
		return imageLoaderFromFolder(dir, 0);
	}
	public static BufferedImage imageLoaderFromFolder(File dir,int indx)
	{
		BufferedImage bi = null;
		try
		{
			File img = dir.listFiles()[indx];
			if(imgExtensions.contains(FilenameUtils.getExtension(img.getName())))
			{
				bi=ImageIO.read(img);
			}
		}
		catch(Exception ex)
		{
			
		}
		return bi;
	}
	public static BufferedImage captureImageFromSwing(JComponent comp)
	{
		BufferedImage bi = null;
		try
		{
			bi = new BufferedImage(comp.getWidth(), comp.getHeight(), BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2d = bi.createGraphics();
	        if (comp.isOpaque())
	        {
	            g2d.setColor(comp.getBackground());
	        }
	        else
	        {
	            g2d.setColor(Color.WHITE);
	        }
	        g2d.fillRect(0, 0, comp.getWidth(), comp.getHeight());
	        comp.printAll(g2d);
	        g2d.dispose();
		}
		catch(Exception ex)
		{
			
		}
		return bi;
	}
}