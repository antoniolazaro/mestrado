package br.ufba.activityrecognition.business.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.ufba.activityrecognition.executor.ab.ExecutorAb;

public class IOUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(IOUtil.class);
	
	public static void mergeFiles(String[] files,String target) throws IOException{
		logger.info("\n CONCATENANDO ARQUIVOS. Total: "+files.length+". Nome: "+target+" \n");
		OutputStream out = new FileOutputStream(target);
	    byte[] buf = new byte[1024];
	    for (String file : files) {
	    	logger.info("\n CONCATENANDO ARQUIVO: "+file+"\n");
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
	
	public static void writeResults(String fileName,String content){
		BufferedWriter bufferedWriter = null;
		try {
 			File myFile = new File(fileName);
 			if (!myFile.exists()) {
				myFile.createNewFile();
			}
 			Writer writer = new FileWriter(myFile);
			bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write(content);
 		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try{
				if(bufferedWriter != null) bufferedWriter.close();
			} catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}

}
