package com.kgprojects.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;

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
}