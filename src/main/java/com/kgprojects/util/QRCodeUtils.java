package com.kgprojects.util;

import java.awt.image.BufferedImage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.Writer;
import com.google.zxing.oned.Code128Writer;

public class QRCodeUtils
{
	public static BufferedImage generateQR(String txt, int w, int h)
	{
		BufferedImage img = null;
		try
		{
			QRCodeWriter qrw = new QRCodeWriter();
			BitMatrix mat = qrw.encode(txt, BarcodeFormat.QR_CODE, w, h);
			img = MatrixToImageWriter.toBufferedImage(mat);
		}
		catch(Exception e)
		{
			
		}
		return img;
	}
	public static BufferedImage generateBarcode(String txt, int w, int h)
	{
		BufferedImage img = null;
		try
		{
			Writer qrw = new Code128Writer();
			BitMatrix mat = qrw.encode(txt, BarcodeFormat.CODE_128, w, h);
			img = MatrixToImageWriter.toBufferedImage(mat);
		}
		catch(Exception e)
		{
			
		}
		return img;
	}
}