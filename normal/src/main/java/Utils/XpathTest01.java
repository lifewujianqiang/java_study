package Utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * author:MarryCheck
 * create 2018-11-21 21:48
 * comment:解析xml
 */

public class XpathTest01 {

    @Test
    public void test01() throws DocumentException{
        SAXReader reader = new SAXReader();
        Document document = reader.read("web/xml/book.xml");
        Node node1 = document.selectSingleNode("/books/book/name");
        System.out.println(node1.getText());

        Node node2 = document.selectSingleNode("/books/book[3]/name");
        System.out.println(node2.getText());

        Node node3 = document.selectSingleNode("/book/book/attribute::id");
        System.out.println(node3);

        Node node4 = document.selectSingleNode("/books/book[2]/attribute::id");
        System.out.println(node4);
    }

    @Test
    public void test02() throws DocumentException{
        SAXReader reader = new SAXReader();
        Document document = reader.read("web/xml/book.xml");
        List list = document.selectNodes("//*");
        for (int i = 0; i < list.size(); i++) {
            Node node = (Node) list.get(i);
            System.out.println(node.getName() + node.getText());
        }

    }



}
