package com.projet1.projet1;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import java.util.Arrays;
import java.util.List;


public class ByteArrayHttpMessageConverter implements HttpMessageConverter<List<byte[]>> {

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return List.class.isAssignableFrom(clazz) && mediaType != null
                && mediaType.getType().equals("image") && mediaType.getSubtype().equals("jpeg");
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return Arrays.asList(MediaType.IMAGE_JPEG);

    }

    
    @Override
    public void write(List<byte[]> byteArrays, MediaType contentType, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        HttpHeaders headers = outputMessage.getHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        for (byte[] byteArray : byteArrays) {
            outputMessage.getBody().write(byteArray);
        }
    }

	@Override
	public List<byte[]> read(Class<? extends List<byte[]>> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		// TODO Auto-generated method stub
		return null;
	}

}
