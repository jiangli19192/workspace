package com.zjl.study.csv;

import info.monitorenter.cpdetector.io.ASCIIDetector;
import info.monitorenter.cpdetector.io.CodepageDetectorProxy;
import info.monitorenter.cpdetector.io.JChardetFacade;
import info.monitorenter.cpdetector.io.ParsingDetector;
import info.monitorenter.cpdetector.io.UnicodeDetector;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/** 
 *  
 */

/**
 * @author weict
 * 
 */
public class JudgeFileCode {

	private static FileInputStream fileInputStream;

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String filePath = "src/com/zjl/study/csv/ANSI-1.csv";
		String filePath2 = "src/com/zjl/study/csv/UTF-8-1.csv";
		String filePath3 = "src/com/zjl/study/csv/Unicode-1.csv";
		String filePath4 = "src/com/zjl/study/csv/Unicode-big-end-1.csv";
		// String encoding = getFileEncoding(filePath);
		// printCSVFile(filePath, encoding);

		// String encoding2 = getFileEncoding(filePath2);
		// printCSVFile(filePath2, encoding2);

		// String encoding3 = getFileEncoding(filePath3);
		// if ("windows-1252".equals(encoding3)) {
		// encoding3 = "UTF-16LE";
		// }
		// printCSVFile(filePath3, encoding3);

		// String encoding4 = getFileEncoding(filePath4);
		// printCSVFile(filePath4, encoding4);

		String encoding5 = getTextStreamEncoding(filePath4);
		if ("US-ASCII".equals(encoding5)) {
			encoding5 = "GBK";
		}
		printCSVFile(filePath, encoding5);
	}

	public static String getFileEncoding(String filePath) {
		/*------------------------------------------------------------------------  
		 
		 
		detector是探测器，它把探测任务交给具体的探测实现类的实例完成。  

		cpDetector内置了一些常用的探测实现类，这些探测实现类的实例可以通过add方法  

		加进来，如ParsingDetector、 JChardetFacade、ASCIIDetector、UnicodeDetector。    

		detector按照“谁最先返回非空的探测结果，就以该结果为准”的原则返回探测到的  

		字符集编码。  

		--------------------------------------------------------------------------*/

		CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();

		/*-------------------------------------------------------------------------  

		  ParsingDetector可用于检查HTML、XML等文件或字符流的编码,构造方法中的参数用于  

		  指示是否显示探测过程的详细信息，为false不显示。  

		---------------------------------------------------------------------------*/

		detector.add(new ParsingDetector(false));// 如果不希望判断xml的encoding，而是要判断该xml文件的编码，则可以注释掉

		/*--------------------------------------------------------------------------  

		   JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码  

		   测定。所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以  

		   再多加几个探测器，比如下面的ASCIIDetector、UnicodeDetector等。  

		  ---------------------------------------------------------------------------*/

		detector.add(JChardetFacade.getInstance());

		// ASCIIDetector用于ASCII编码测定

		detector.add(ASCIIDetector.getInstance());

		// UnicodeDetector用于Unicode家族编码的测定

		detector.add(UnicodeDetector.getInstance());

		Charset charset = null;

		// File f = new File("文件路径");
		File f = new File(filePath);

		try {

			charset = detector.detectCodepage(f.toURL());

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if (charset != null) {

			System.out.println(f.getName() + "编码是：" + charset.name());
			return charset.name();

		} else {

			System.out.println(f.getName() + "未知");
			return "";
		}
	}

	public static String getTextStreamEncoding(String filePath)
			throws FileNotFoundException {
		CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
		detector.add(new ParsingDetector(false));// 如果不希望判断xml的encoding，而是要判断该xml文件的编码，则可以注释掉
		detector.add(JChardetFacade.getInstance());
		detector.add(ASCIIDetector.getInstance()); // ASCIIDetector用于ASCII编码测定
		detector.add(UnicodeDetector.getInstance());// UnicodeDetector用于Unicode家族编码的测定

		Charset charset = null;

		File file = new File(filePath);
		fileInputStream = new FileInputStream(file);
		
		byte[] byteArr = new byte[10000];
		try {
			fileInputStream.read(byteArr);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("length=" + byteArr.length);
		InputStream inputStream = new ByteArrayInputStream(byteArr);
		
		System.out.println("length=" + byteArr.length);
		try {

			charset = detector.detectCodepage(inputStream, 5);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (charset != null) {

			System.out.println(file.getName() + "流编码是：" + charset.name());
			return charset.name();

		} else {

			System.out.println(file.getName() + "流编码未知");
			return "";
		}
	}

	public static void printCSVFile(String filePath, String encoding) {
		try {

			File file = new File(filePath);

			FileInputStream fileInputStream = new FileInputStream(file);
			DataInputStream dataInputStream = new DataInputStream(
					fileInputStream);
			InputStreamReader inputStreamReader = new InputStreamReader(
					dataInputStream, encoding);
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			List<String[]> list = new ArrayList<String[]>();
			String line = null;

			while ((line = bufferedReader.readLine()) != null) {
				String[] columns = line.split(",");
				list.add(columns);
			}

			for (String[] ss : list) {
				for (String s : ss)
					if (null != s && !s.equals(""))
						System.out.print(s + " , ");
				System.out.println();
			}

			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}