package com.kgprojects.util;

import java.awt.Color;
/**
 * @author Kshitij Garg
 */
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.apache.commons.io.FileUtils;
public class ImageLoader
{
	public static BufferedImage convertToMonoChrome(BufferedImage img)throws Exception
	{
		BufferedImage mono_img = new BufferedImage(img.getWidth() ,img.getHeight() ,BufferedImage.TYPE_BYTE_BINARY);
		for(int x=0;x<img.getWidth();x++)
		{
			for(int y=0;y<img.getHeight();y++)
			{
				if(img.getRGB(x, y)==Color.BLACK.getRGB())
				{
					mono_img.setRGB(x, y, Color.BLACK.getRGB());
				}
				else
				{
					mono_img.setRGB(x, y, Color.WHITE.getRGB());
				}
			}
		}
		return mono_img;
	}
	public static byte[] imageToBytes(BufferedImage img)throws Exception
	{
		return imageToBytes(img,"jpg");
	}
	public static byte[] imageToBytes(BufferedImage img, String format)throws Exception
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(img, format, baos);
		byte arr[] = baos.toByteArray();
		baos.close();
		return arr;
	}
	public static BufferedImage bytesToImage(byte arr[])throws Exception
	{
		ByteArrayInputStream bais = new ByteArrayInputStream(arr);
		BufferedImage bi = ImageIO.read(bais);
		bais.close();
		return bi;
	}
	public static String javafyImage(File img, String className)throws Exception
	{
		return javafyImage(FileUtils.readFileToByteArray(img),className);
	}
	public static String javafyImage(BufferedImage img, String className)throws Exception
	{
		return javafyImage(imageToBytes(img), className);
	}
	public static String javafyImage(byte img[], String className)throws Exception
	{
		Queue<String> qu = new LinkedList<>();
		for(byte b : img)
		{
			qu.add(String.format("(byte)%d", Byte.toUnsignedInt(b)));
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;!qu.isEmpty();i++)
		{
			String e = qu.remove();
			sb.append(e);
			if(!qu.isEmpty())
			{
				sb.append(",");
			}
			if(i%15==0)
			{
				sb.append("\r\n");
			}
		}
		String str = String.format("public class %s\r\n"
				+ "{\r\n"
				+ "	public static final byte arr[] = new byte[] {%s};\r\n"
				+ "}", className, sb.toString());
		return str;
	}
	public static BufferedImage scaledImage(Image img,int w,int h)
	{
		return scaledImage(img, w, h, BufferedImage.TYPE_INT_RGB);
	}
	public static BufferedImage scaledImage(Image img,int w,int h,int imageType)
	{
		BufferedImage b;
		Graphics2D g2;
		b=new BufferedImage(w,h,imageType);
		g2=b.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(img,0,0,w,h,null);
		g2.dispose();
		return b;
	}
	public static BufferedImage scaledImageWithPadding(Image img,int w,int h)
	{
		return scaledImageWithPadding(img, w, h, Color.BLACK);
	}
	public static BufferedImage scaledImageWithPadding(Image img,int w,int h,Color backgroundColor)
	{
		BufferedImage originalImage = (BufferedImage) img;
		int ow = originalImage.getWidth();
        int oh = originalImage.getHeight();
        double aspectRatio = (1.0* ow) / oh;
        int nw = w;
        int nh = h;
        if ((1.0*w)/h > aspectRatio)
        {
            nw = (int)(h*aspectRatio);
        }
        else
        {
            nh = (int)(w/aspectRatio);
        }
        BufferedImage b = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = b.createGraphics();
        g2.setColor(backgroundColor);
        g2.fillRect(0, 0, w, h);
        Image scaledImage = originalImage.getScaledInstance(nw, nh, Image.SCALE_SMOOTH);
        int x = (w - nw) / 2;
        int y = (h - nh) / 2;
        g2.drawImage(scaledImage, x, y, null);
        g2.dispose();
        return b;

	}
	public static BufferedImage loadImage(InputStream name)
	{
		BufferedImage icon;
		try
		{
			icon=ImageIO.read(name);
			name.close();
		}
		catch(Exception e)
		{
			return null;
		}
		return icon;
	}
	public static BufferedImage loadImage(File name)
	{
		BufferedImage icon;
		try
		{
			icon=ImageIO.read(name);
		}
		catch(Exception e)
		{
			return null;
		}
		return icon;
	}
	public static BufferedImage loadImage(InputStream name,int w,int h)
	{
		BufferedImage icon;
		try
		{
			icon=ImageIO.read(name);
			icon=scaledImage(icon,w,h);
			name.close();
		}
		catch(Exception e)
		{
			return null;
		}
		return icon;
	}
	public static BufferedImage loadImage(File name,int w,int h)
	{
		BufferedImage icon;
		try
		{
			icon=ImageIO.read(name);
			icon=scaledImage(icon,w,h);
		}
		catch(Exception e)
		{
			return null;
		}
		return icon;
	}
	public static BufferedImage loadImage(String name)
	{
		return loadImage(new File(name));
	}
	public static BufferedImage loadImage(String name,int w,int h)
	{
		return loadImage(new File(name),w,h);
	}
	public static void setLabelImage(File fileName, JLabel label)
	{
		try
		{
			label.setIcon(new ImageIcon(loadImage(fileName, label.getWidth(), label.getHeight())));
		}
		catch(Exception e) {}
	}
	public static void setLabelImage(InputStream fileName, JLabel label)
	{
		try
		{
			label.setIcon(new ImageIcon(loadImage(fileName, label.getWidth(), label.getHeight())));
			fileName.close();
		}
		catch(Exception e) {e.printStackTrace();}
	}
}