package Utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * author:MarryCheck
 * create 2018-11-21 21:24
 * comment: xml解析
 */

public class Dom4jTest01 {

    @Test
    public void test01() throws DocumentException{
        SAXReader reader = new SAXReader();
        Document document = reader.read("web/xml/book.xml");
        //获取根节点
        Element root = document.getRootElement();
        //获取当前节点
        List list = root.elements();
        Element firstBook = (Element) list.get(0);
        String name = firstBook.element("name").getText();
        System.out.println(name);
    }


    /*
     * 遍历所有节点
     */
    @Test
    public void test02() throws DocumentException{
        SAXReader reader = new SAXReader();
        Document document = reader.read("web/xml/book.xml");
        Element root = document.getRootElement();
        treeSelect(root);
    }

    //递归
    private void treeSelect(Element ele){
        System.out.println(ele.getName());
        for (int i = 0; i < ele.nodeCount(); i++) {
            //取出下表为i的节点
            Node node = ele.node(i);
            //判断当前节点是否为标签
            if (node instanceof Element){
                treeSelect((Element) node);

            }else {
                System.out.println(node.getText());
            }
        }


    }

}
