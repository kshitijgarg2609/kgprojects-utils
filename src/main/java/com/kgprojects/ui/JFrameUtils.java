package com.kgprojects.ui;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class JFrameUtils
{
	public static JFrame preparePanelInGridLayout(Component comp)
	{
		DefaultFrame df = new DefaultFrame();
		df.setLayout(new GridLayout());
		df.add(comp);
		df.ready();
		return df;
	}
}