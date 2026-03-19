package com.kgprojects.ui;

import javax.swing.JComboBox;

public class ComboBoxUtils
{
	public static <T> void selectIndexByOption(JComboBox<T> comboBox, T option)
	{
		for(int i=0;i<comboBox.getModel().getSize();i++)
		{
			if(option.equals(comboBox.getModel().getElementAt(i)))
			{
				comboBox.setSelectedIndex(i);
				break;
			}
		}
	}
}