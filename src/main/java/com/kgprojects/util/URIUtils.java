package com.kgprojects.util;
/**
 * @author Kshitij Garg
 */
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

public class URIUtils
{
	public static String replacer(String uri) throws Exception
	{
		return URLEncoder.encode(uri, StandardCharsets.UTF_8.toString())
				.replace("+", "%20")
		        .replace("%21", "!")
		        .replace("%27", "'")
		        .replace("%28", "(")
		        .replace("%29", ")")
		        .replace("%7E", "~")
		        .replace("%40", "@");
	}
	public static URI getLink(String parent,String child)throws Exception
	{
		if(parent.charAt(parent.length()-1)=='/')
		{
			return getLink(parent.substring(0, parent.length()-1),child);
		}
		return URI.create(parent+"/"+URLEncoder
				.encode(child, StandardCharsets.UTF_8.toString())
				.replace("+", "%20")
		        .replace("%21", "!")
		        .replace("%27", "'")
		        .replace("%28", "(")
		        .replace("%29", ")")
		        .replace("%7E", "~")
		        .replace("%40", "@")
		        );
	}
	public static URI getLink(String parent,Map<String, String> query)throws Exception
	{
		return URI.create(parent+"?"+requestToString(query));
	}
	public static URI getLink(String parent,String child,Map<String, String> query)throws Exception
	{
		return URI.create(getLink(parent,child).toString()+"?"+requestToString(query));
	}
	public static String requestToString(Map<String, String> map)throws Exception
	{
//		StringBuilder requestBody = new StringBuilder();
//		for(Map.Entry<String, String> ent : map.entrySet())
//		{
//			if(requestBody.length()>0)
//			{
//				requestBody.append('&');
//			}
//			requestBody.append(URLEncoder.encode(ent.getKey(), StandardCharsets.UTF_8.toString()))
//			.append('=').append(URLEncoder.encode(ent.getValue(), StandardCharsets.UTF_8.toString()));
//		}
		return String.join("&", 
				map.entrySet().stream().map(ent->
				{
					try
					{
						String key=URLEncoder.encode(ent.getKey(), StandardCharsets.UTF_8.toString())
								.replace("+", "%20")
						        .replace("%21", "!")
						        .replace("%27", "'")
						        .replace("%28", "(")
						        .replace("%29", ")")
						        .replace("%7E", "~")
						        .replace("%40", "@");
						String value=URLEncoder.encode(ent.getValue(), StandardCharsets.UTF_8.toString())
								.replace("+", "%20")
						        .replace("%21", "!")
						        .replace("%27", "'")
						        .replace("%28", "(")
						        .replace("%29", ")")
						        .replace("%7E", "~")
						        .replace("%40", "@");
//						System.out.println(String.format("%s=%s", key, value));
						return String.format("%s=%s", key, value);
					}
					catch (UnsupportedEncodingException e)
					{
						return null;
					}
				}).collect(Collectors.toList()));
	}
}