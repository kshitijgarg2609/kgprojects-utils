package com.kgprojects.util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

public class ColorUtils
{
	public static BufferedImage renewColors(BufferedImage img)
	{
		BufferedImage rnw = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		for(int y=0;y<img.getHeight();y++)
		{
			for(int x=0;x<img.getWidth();x++)
			{
				rnw.setRGB(x, y, img.getRGB(x,y));
			}
		}
		return rnw;
	}
	public static void replaceColor(BufferedImage img, Color old, Color neww)
	{
		for(int y=0;y<img.getHeight();y++)
		{
			for(int x=0;x<img.getWidth();x++)
			{
				if(img.getRGB(x, y)==old.getRGB())
				{
					img.setRGB(x, y, neww.getRGB());
				}
			}
		}
	}
	public static Set<Color> colorSet(BufferedImage img)
	{
		Set<Color> set = new HashSet<>();
		for(int y=0;y<img.getHeight();y++)
		{
			for(int x=0;x<img.getWidth();x++)
			{
				set.add(new Color(img.getRGB(x, y)));
			}
		}
		return set;
	}
}