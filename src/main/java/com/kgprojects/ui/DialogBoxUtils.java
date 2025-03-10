package com.kgprojects.ui;

import javax.swing.JDialog;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
/**
 * @author Kshitij Garg
 */
public class DialogBoxUtils
{
	public static JDialog getMessageDialog(JFrame jf, String msg)
	{
		JDialog jd = new JDialog(jf, "", true);
		jd.setBounds(CenterRectangle.getScreenRectangle(400, 200));
		jd.getContentPane().setLayout(new GridLayout(1, 1, 10, 10));
		JLabel lbl = new JLabel(msg,SwingConstants.CENTER);
		lbl.setBorder(new LineBorder(Color.ORANGE, 4, true));
		lbl.setOpaque(true);
		jd.getContentPane().add(lbl);
		jd.setVisible(true);
		return jd;
	}
	public static JDialog getMessageDialog(JDialog dialog, String msg)
	{
		JDialog jd = new JDialog(dialog, msg, true);
		jd.setBounds(CenterRectangle.getScreenRectangle(400, 200));
		jd.getContentPane().setLayout(new GridLayout(1, 1, 10, 10));
		JLabel lbl = new JLabel(msg,SwingConstants.CENTER);
		lbl.setBorder(new LineBorder(Color.ORANGE, 4, true));
		lbl.setOpaque(true);
		jd.getContentPane().add(lbl);
		jd.setVisible(true);
		return jd;
	}
}
