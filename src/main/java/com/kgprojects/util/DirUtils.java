package com.kgprojects.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
/**
 * @author Kshitij Garg
 */
public class DirUtils
{
	public static boolean[] mkdirIfNotExists(File file)
	{
		return mkdirIfNotExists(new File[] {file});
	}
	public static boolean[] mkdirIfNotExists(File files[])
	{
		boolean arr[] = new boolean[files.length];
		for(int i=0;i<files.length;i++)
		{
			arr[i]=false;
			try
			{
				if(!files[i].exists())
				{
					files[i].mkdirs();
					arr[i]=true;
				}
			}
			catch(Exception ex)
			{
				
			}
		}
		return arr;
	}
	public static void deleteIfExists(File file)
	{
		deleteIfExists(new File[] {file});
	}
	public static void deleteIfExists(File files[])
	{
		for(File ff : files)
		{
			FileUtils.deleteQuietly(ff);
		}
	}
}