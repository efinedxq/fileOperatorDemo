package cn.dxq.xmlDemo.SAX;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.annotation.DomHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;



import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test = new Test();
		test.testSAX();
//		test.testDOM();
	}

	public void testSAX(){
		SAXParserFactory saxF = SAXParserFactory.newInstance();
		
		try {
			SAXParser parser = saxF.newSAXParser();
			BookHandler handler = new BookHandler();
			parser.parse("book.xml",handler);
			List<Book> books = handler.getBooks();
			for(Book temp:books){
				System.out.println(temp.toString());
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	
//	public void testDOM(){
//		DomHandler handler = new DomHandler();
//		List<Book> books = handler.process();
//		for(Book temp:books){
//			System.out.println(temp.toString());
//		}
//	}
	
}
