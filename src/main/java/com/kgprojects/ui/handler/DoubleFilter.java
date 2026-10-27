package com.kgprojects.ui.handler;

/**
 * @author Kshitij Garg
 */
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class DoubleFilter extends DocumentFilter
{
	@Override
	public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException
	{
		StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.insert(offset, text);
        if (isDouble(sb.toString()))
        {
            super.insertString(fb, offset, text, attr);
        }
	}
	@Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
	{
        StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.replace(offset, offset + length, text);
        if (isDouble(sb.toString()))
        {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    private boolean isDouble(String s)
    {
    	boolean result=false;
        try
        {
            Double.parseDouble(s);
            result=true;
        }
        catch (Exception e)
        {
        }
        return result;
    }
}