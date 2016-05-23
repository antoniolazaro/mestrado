package br.ufba.activityrecognition.business.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IOUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(IOUtil.class);
	
	public static void mergeFiles(String[] files,String target) throws IOException{
		logger.info("CONCATENANDO ARQUIVOS. Total: "+files.length+". Nome: "+target+" \n");
		OutputStream out = new FileOutputStream(target);
	    byte[] buf = new byte[1024];
	    for (String file : files) {
	    	logger.info("CONCATENANDO ARQUIVO: "+file+"\n");
	        InputStream in = new FileInputStream(file);
	        int b = 0;
	        while ( (b = in.read(buf)) >= 0) {
	            out.write(buf, 0, b);
	            out.flush();
	        }
	        in.close();
	    }
	    out.close();
	}

}
