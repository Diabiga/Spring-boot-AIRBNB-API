package com.projet1.projet1;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class ImageUtils {

	

	
	
	   public static byte[] decompressImage(byte[] compressedImageData) throws IOException {
	        ByteArrayInputStream bais = new ByteArrayInputStream(compressedImageData);
	        BufferedImage bufferedImage = ImageIO.read(bais);

	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        ImageIO.write(bufferedImage, "jpg", baos);
	        baos.flush();
	        byte[] imageData = baos.toByteArray();
	        baos.close();

	        return imageData;
	    }
	   
	   public static byte[] compressImage(byte[] imageData) throws IOException {
	        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imageData));

	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        ImageIO.write(bufferedImage, "jpg", baos);
	        baos.flush();
	        byte[] compressedImage = baos.toByteArray();
	        baos.close();

	        return compressedImage;
	    }
	   
	   
	   
		
		public static byte[] readBytesFromFile(String filePath) throws IOException {
		    Path path = Paths.get(filePath);
		    return Files.readAllBytes(path);
		}
		
}
