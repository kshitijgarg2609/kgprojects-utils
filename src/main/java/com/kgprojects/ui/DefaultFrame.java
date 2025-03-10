package com.kgprojects.ui;

import javax.swing.JFrame;
/**
 * @author Kshitij Garg
 */
public class DefaultFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4421213419189942113L;
	public DefaultFrame(String a)
	{
		this(a,850,650);
	}
	public DefaultFrame()
	{
		super();
//		setBounds(CenterRectangle.getScreenRectangle(w,h));
		setResizable(true);
		setLayout(null);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public DefaultFrame(String a,int w,int h)
	{
		super(a);
		setBounds(CenterRectangle.getScreenRectangle(w,h));
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void ready()
	{
		setVisible(true);
		repaint();
		refresh();
	}
	public void refresh()
	{
		revalidate();
		requestFocus();
	}
}