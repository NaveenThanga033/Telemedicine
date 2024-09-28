import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class BlogHandler extends DefaultHandler {
    private List<BlogPost> blogPosts;
    private BlogPost currentPost;
    private StringBuilder currentValue;

    public BlogHandler() {
        blogPosts = new ArrayList<>();
    }

    public List<BlogPost> getBlogPosts() {
        return blogPosts;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentValue = new StringBuilder();
        if (qName.equalsIgnoreCase("post")) {
            currentPost = new BlogPost();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName.toLowerCase()) {
            case "post":
                blogPosts.add(currentPost);
                break;
            case "title":
                currentPost.setTitle(currentValue.toString());
                break;
            case "content":
                currentPost.setContent(currentValue.toString());
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue.append(ch, start, length);
    }
}
