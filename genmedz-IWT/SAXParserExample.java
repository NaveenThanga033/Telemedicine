import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SAXParserExample {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            BlogHandler handler = new BlogHandler();
            File inputFile = new File("blogData.xml"); // Change this to your XML file path
            saxParser.parse(inputFile, handler);

            List<BlogPost> posts = handler.getBlogPosts();
            for (BlogPost post : posts) {
                System.out.println("Title: " + post.getTitle());
                System.out.println("Content: " + post.getContent());
                System.out.println("--------------");
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
