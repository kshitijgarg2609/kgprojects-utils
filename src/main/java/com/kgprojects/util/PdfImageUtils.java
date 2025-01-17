package com.kgprojects.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
/**
 * @author Kshitij Garg
 */
public class PdfImageUtils
{
	public static byte[] exportImageToA4Pdf(BufferedImage img)throws Exception
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfDocument pdf = new PdfDocument(new PdfWriter(baos));
		pdf.setDefaultPageSize(PageSize.A4);
		Document document = new Document(pdf);
	    document.setMargins(0, 0, 0, 0);
	    ImageData idata = ImageDataFactory.create(ImageLoader.imageToBytes(img));
	    Image image = new Image(idata).scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
	    image.setFixedPosition(0,0);
	    document.add(image);
	    document.close();
	    byte arr[] = baos.toByteArray();
	    baos.close();
	    return arr;
	}
	public static byte[] exportImageToA4Pdf(List<BufferedImage> imgs)throws Exception
	{
		return exportImageToA4Pdf(imgs.stream().toArray(BufferedImage[]::new));
	}
	public static void exportImageToA4Pdf(File img[],File pdfOutput)throws Exception
	{
		OutputStream baos = new FileOutputStream(pdfOutput);
		PdfDocument pdf = new PdfDocument(new PdfWriter(baos));
		pdf.setDefaultPageSize(PageSize.A4);
		Document document = new Document(pdf);
		document.setMargins(0, 0, 0, 0);
		for(int i=0;i<img.length-1;i++)
		{
			pdf.addNewPage();
		}
		for(int i=0;i<img.length;i++)
		{
			ImageData idata = ImageDataFactory.create(img[i].toURI().toURL());
			Image image = new Image(idata).scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
			image.setFixedPosition(i+1, 0f, 0f);
			document.add(image);
			
			if(i<img.length-1)
			{
				
			}
		}
		document.close();
	    baos.close();
	}
	public static byte[] exportImageToA4Pdf(BufferedImage img[])throws Exception
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfDocument pdf = new PdfDocument(new PdfWriter(baos));
		pdf.setDefaultPageSize(PageSize.A4);
		Document document = new Document(pdf);
		document.setMargins(0, 0, 0, 0);
		for(int i=0;i<img.length-1;i++)
		{
			pdf.addNewPage();
		}
		for(int i=0;i<img.length;i++)
		{
			ImageData idata = ImageDataFactory.create(ImageLoader.imageToBytes(img[i]));
			Image image = new Image(idata).scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
			image.setFixedPosition(i+1, 0f, 0f);
			document.add(image);
			
			if(i<img.length-1)
			{
				
			}
		}
		document.close();
	    byte arr[] = baos.toByteArray();
	    baos.close();
	    return arr;
	}
	public static byte[] combinePdfs(List<byte[]> pdfs)throws Exception
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfDocument pdf = new PdfDocument(new PdfWriter(baos));
		pdf.setDefaultPageSize(PageSize.A4);
		Document document = new Document(pdf);
		
		byte arr[] = baos.toByteArray();
	    baos.close();
	    return arr;
	}
}