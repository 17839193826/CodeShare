package com.code.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {

	public static String getLocation(String ip) {
		BufferedReader reader=null;
		HttpURLConnection huc=null;
		try {
			//创建请求的路径对象
			URL url=new URL("https://ip.cn/index.php");
			//获取连接对象
			huc=(HttpURLConnection) url.openConnection();
			//连接
			huc.connect();
			//验证状态响应码
			if(huc.getResponseCode()==200) {
				//从响应字节流中获取内容
				StringBuffer buffer=new StringBuffer();
				reader=new BufferedReader(new InputStreamReader(huc.getInputStream()));
				String msg=null;
				while ((msg=reader.readLine())!=null) {
					buffer.append(msg);
				}
				
				return buffer.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			huc.disconnect();
		}
		return null;
		
	}
}
