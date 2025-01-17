package com.kgprojects.util;

import java.io.File;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
/**
 * @author Kshitij Garg
 */
public class MultiPartFileUploader
{
	public static void upload(HttpURLConnection http, File file)throws Exception
	{
		upload(http, file, file.getName());
	}
	public static void upload(HttpURLConnection http, File file, String name)throws Exception
	{
//		HttpURLConnection http = (HttpURLConnection) uri.toURL().openConnection();
		http.setRequestMethod("POST");
		http.setDoOutput(true);
		String crlf = "\r\n";
		String boundary = UUID.randomUUID().toString();
		String d_dash="--";
		http.setRequestProperty("Content-Type", "multipart/form-data; boundary="+boundary);
		//System.out.println(http.getHeaderFields());
		OutputStream os = http.getOutputStream();
		os.write((d_dash + boundary + crlf).getBytes());
		os.write(("Content-Disposition: form-data; name=\"file\"; filename=\"" + name + "\""+crlf).getBytes());
		os.write(("Content-Type: " + "application/octet-stream" + crlf).getBytes());
		os.write(crlf.getBytes());
		//os.write("test data\ntest data".getBytes());
		os.write(FileUtils.readFileToByteArray(file));
		os.write(crlf.getBytes());
        os.write((d_dash + boundary + d_dash+crlf).getBytes());
        os.close();
        //System.out.println("status : "+http.getResponseCode());
//        flg=http.getResponseCode()==HttpURLConnection.HTTP_CREATED;
//        System.out.println("code : "+http.getResponseCode());
//        http.disconnect();
	}
}