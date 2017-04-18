package cn.dxq.xmlDemo.SAX;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class SaxToXmlDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1、创建SAXTransformerFactory实例 
        SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        try {
        	  //2、创建TransformerHandler实例  
			TransformerHandler handler = factory.newTransformerHandler();
			//3、创建Transformer实例 
			Transformer transformer = handler.getTransformer();
			//4、设置输出的xml属性，encoding为编码，indent是确保输出的xml文件能够自动换行
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			//5、创建Result对象，将Result对象加载到TransHandler中  
            //注意：1、这一步必须在Transformer.setOutputProperty()之后，不然设置的xml属性将不生效  
            //    2、这一步也必须在TransformerHandler.startDocument()之前，不然会报错。  
            //       分析源码后发现，startDocument()会先判断result是否为空，为空则报错  
            Result result = new StreamResult("book.xml");  
            handler.setResult(result);
            //6、创建属性Attribute对象  
            AttributesImpl attr = new AttributesImpl();  
            //7、开始写文件  
			handler.startDocument();
            //8、写入根节点bookstore  
            handler.startElement("", "", "bookstore", attr);  
              
            //9、清空属性，每次新增一个节点都需要先清空一下属性，防止在设置节点属性时发生错误  
            attr.clear();  
            //10、设置属性  
            attr.addAttribute("", "", "id", "", "1");  
            //11、写入根节点的子节点book  
            handler.startElement("", "", "book", attr);  
              
            attr.clear();  
            //12、分别写入book节点的子节点  
            handler.startElement("", "", "name", attr);  
            //13、写入子节点内容  
            handler.characters("冰与火之歌".toCharArray(), 0, "冰与火之歌".toCharArray().length);  
            //14、写入子节点末尾  
            handler.endElement("", "", "name");  
            attr.clear();  
            handler.startElement("", "", "author", attr);  
            handler.characters("乔治马丁".toCharArray(), 0, "乔治马丁".toCharArray().length);  
            handler.endElement("", "", "author");  
            attr.clear();  
            handler.startElement("", "", "time", attr);  
            handler.characters("2014".toCharArray(), 0, "2014".toCharArray().length);  
            handler.endElement("", "", "name");  
            attr.clear();  
            handler.startElement("", "", "price", attr);  
            handler.characters("60".toCharArray(), 0, "60".toCharArray().length);  
            handler.endElement("", "", "name");  
  
            //15、写入book节点末尾  
            handler.endElement("", "", "book");  
            //16、写入根节点末尾  
            handler.endElement("", "", "bookstore");  
            //17、写文件结束  
            handler.endDocument();  
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
	}

}
