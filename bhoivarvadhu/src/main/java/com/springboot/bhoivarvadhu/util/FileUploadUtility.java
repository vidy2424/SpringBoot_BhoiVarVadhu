package com.springboot.bhoivarvadhu.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	private static final String ABS_PATH ="C:/Users/vidyesh/Desktop/Node/Bhoi_VarVadhu/src/assets/image/";
	private static String REAL_PATH= "C:/Users/vidyesh/Desktop/Node/Bhoi_VarVadhu/src/assets/image/";
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		
		// Get the real path
		//sREAL_PATH =request.getSession().getServletContext().getRealPath("/assets/image/");
		
		logger.info(REAL_PATH);
		
		//to make sure all the directory exists
		//please create the directories
		if(!new File(ABS_PATH).exists()) { 
			//create the directories
			new File(ABS_PATH).mkdirs();
		}
		
		if(!new File(REAL_PATH).exists()) {
			//create the directories
			new File(REAL_PATH).mkdirs();
		}
		
		try {
			//server upload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));

			//project directory upload
			file.transferTo(new File(ABS_PATH + code + ".jpg"));

		} catch (Exception e) {
		 
		}
	}
	
	public static void uploadNoImage(HttpServletRequest request, String code) {
		// get the real server path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/image/");
	
		String imageURL = "http://placehold.it/640X480?text=No Image";
		String destinationServerFile = REAL_PATH + code + ".jpg";
		String destinationProjectFile = REAL_PATH + code + ".jpg";
				
		try {
			URL url = new URL(imageURL);				
			try (	
					InputStream is = url.openStream();
					OutputStream osREAL_PATH = new FileOutputStream(destinationServerFile);
					OutputStream osABS_PATH = new FileOutputStream(destinationProjectFile);
				){
			
				byte[] b = new byte[2048];
				int length;
				while((length = is.read(b))!= -1) {
					osREAL_PATH.write(b, 0, length);
					osABS_PATH.write(b, 0, length);
				}
			}			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
