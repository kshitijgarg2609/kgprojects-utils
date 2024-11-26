package com.kgprojects.util;

import org.apache.commons.lang3.SystemUtils;

public class SharedFolderName
{
	public static String getSharedFolderName()
	{
		String name=null;
		if(SystemUtils.IS_OS_WINDOWS)
		{
			name=String.format("%s_%s", "windows",SystemUtils.OS_ARCH);
		}
		else if(SystemUtils.IS_OS_LINUX)
		{
			name=String.format("%s_%s", "linux",SystemUtils.OS_ARCH);
		}
		else if(SystemUtils.IS_OS_MAC)
		{
			name=String.format("%s_%s", "mac",SystemUtils.OS_ARCH);
		}
		return name;
	}
	public static String getSharedFileExtensionWithDot()
	{
		return "."+getSharedFileExtension();
	}
	public static String getSharedFileExtension()
	{
		String name=null;
		if(SystemUtils.IS_OS_WINDOWS)
		{
			name="dll";
		}
		else if(SystemUtils.IS_OS_LINUX)
		{
			name="so";
		}
		else if(SystemUtils.IS_OS_MAC)
		{
			name="dylib";
		}
		return name;
	}
}