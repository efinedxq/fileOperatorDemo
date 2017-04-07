package cn.dxq.xmlDemo.dom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomHandler {
	public List<Book> process(){
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setValidating(false);//通用做法，防止出现莫名其妙的错误
		domFactory.setNamespaceAware(true);
		
		try {
			DocumentBuilder builder = domFactory.newDocumentBuilder();
			
			Document document = builder.parse("book.xml");
			// 得到books节点
			Node node = document.getFirstChild();
			
			// 得到所有book节点
			NodeList nodes = node.getChildNodes();
			List<Book> books = new ArrayList<Book>();
			
			// 对每个book节点处理
			for(int i=0;i<nodes.getLength();i++){
				Book temp = new Book();
				Node bookNode = nodes.item(i);
				if(!bookNode.hasChildNodes())
					continue;
				
				NamedNodeMap attributes = bookNode.getAttributes();
				String bookid = attributes.getNamedItem("id").getNodeValue();
				temp.setBookid(bookid);
				
				// 取出book的第一个节点
				Node child = bookNode.getFirstChild();
				for (int j = 0; j < bookNode.getChildNodes().getLength(); j++) {
					if(j!=0){
						child = child.getNextSibling();
					}
					
					String name = child.getNodeName();
					if (name.equals("bookname")) {
						temp.setBookname(child.getTextContent());
					} else if (name.equals("author")) {
						temp.setAuthor(child.getTextContent());
					} else if (name.equals("publisher")) {
						temp.setPublisher(child.getTextContent());
					} else if (name.equals("price")) {
						temp.setPrice(Float.parseFloat(child.getTextContent()));
					}
				}
				books.add(temp);
			}
			return books;			
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
		return null;
	}
	
	
	public static void main(String[] args){
		DomHandler dh = new DomHandler();
		List<Book> books = dh.process();
		Iterator<Book> it = books.iterator();
		while(it.hasNext()){
			Book oneBook = it.next();
			System.out.println(oneBook.toString());			
		}
	}
}

