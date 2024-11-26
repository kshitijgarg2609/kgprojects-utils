package com.kgprojects.ui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class CenterRectangle
{
	public static Rectangle getInnerRectangle(int w,int h,int b)
	{
		return getInnerRectangle(w,h,(w-b),(h-b));
	}
	public static Rectangle getInnerRectangle(int w,int h,int iw,int ih)
	{
		if(w<=0||h<=0||iw<=0||ih<=0||iw>=w||ih>=h)
		{
			return null;
		}
		return (new Rectangle(((w-iw)/2),((h-ih)/2),iw,ih));
	}
	public static Rectangle getScreenRectangle(int iw,int ih)
	{
		Dimension dim=(Toolkit.getDefaultToolkit()).getScreenSize();
		return getInnerRectangle((int)(dim.getWidth()),(int)(dim.getHeight()),iw,ih);
	}
	public static Rectangle getScreenRectangle()
	{
		Dimension dim=(Toolkit.getDefaultToolkit()).getScreenSize();
		return (new Rectangle(0,0,(int)(dim.getWidth()),(int)(dim.getHeight())));
	}
}