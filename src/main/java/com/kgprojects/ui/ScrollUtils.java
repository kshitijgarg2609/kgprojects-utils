package com.kgprojects.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ScrollUtils
{
	public static JScrollPane addPanelWithDefaultScroll(JPanel panel)
	{
		return new JScrollPane(panel);
	}
	public static JScrollPane addPanelWithScroll(JPanel panel)
	{
		JScrollPane scroll = new JScrollPane(panel);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		return scroll;
	}
}