package cn.dxq.xmlDemo.SAX;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BookHandler extends DefaultHandler {

	private List<Book> books = new ArrayList<Book>();
	private Book temp;
	private String element;
	private Stack elementStack=new Stack();
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
//		System.out.println("Parsing content of "+element);
//		System.out.println("Parsing content of "+elementStack.peek().toString());
		String content=new StringBuffer().append(ch,start,length).toString().trim();
		if(content.length()==0)
			return ;
		
		element = elementStack.peek().toString();
		if(element.equals("bookname")){
			temp.setBookname(content);
		}else if(element.equals("author")){
			temp.setAuthor(content);
		}else if(element.equals("publisher")){
			temp.setPublisher(content);
		}else if(element.equals("price")){
			temp.setPrice(Float.parseFloat(content));
		}
	}

	@Override
	public void endElement(String uri, String localName, String name)
			throws SAXException {
		if(name.equals("book")){
			books.add(temp);
		}
//		System.out.println("Ending parsing tag "+element);
//		System.out.println("Ending parsing tag "+elementStack.peek().toString());
		elementStack.pop();
	}

	@Override
	public void startElement(String uri, String localName, String name,
			Attributes attributes) throws SAXException {
		// 如果是book元素，新建图书对象，否则记录当前元素
		if(name.equals("book")){
			temp = new Book();
			temp.setBookid(attributes.getValue(0));
//			element = name;
			elementStack.push(name);
		}
		else
			//			element = name;
			elementStack.push(name);
//		System.out.println("Begining parsing tag "+element);
//		System.out.println("Begining parsing tag "+elementStack.peek().toString());
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}

