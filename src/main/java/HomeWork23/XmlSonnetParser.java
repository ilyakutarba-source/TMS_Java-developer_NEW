package HomeWork23;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class XmlSonnetParser {
    private static final String DEFAULT_XML_RESOURCE = "/HomeWork23/sonnet.xml";

    public static void main(String[] args) throws Exception {
        Document document = args.length > 0
                ? parseXml(Files.newInputStream(Path.of(args[0])))
                : parseDefaultXml();

        String firstName = getTagText(document, "firstName");
        String lastName = getTagText(document, "lastName");
        String title = getTagText(document, "title");

        String fileName = firstName + "_" + lastName + "_" + title + ".txt";
        Path outputPath = args.length > 1
                ? Path.of(args[1]).resolve(fileName)
                : Path.of(fileName);

        List<String> lines = getLines(document);
        Files.write(outputPath, lines, StandardCharsets.UTF_8);

        System.out.println("Created file: " + outputPath.toAbsolutePath());
    }

    private static Document parseDefaultXml() throws Exception {
        InputStream inputStream = XmlSonnetParser.class.getResourceAsStream(DEFAULT_XML_RESOURCE);

        if (inputStream == null) {
            throw new IllegalStateException("XML resource not found: " + DEFAULT_XML_RESOURCE);
        }

        return parseXml(inputStream);
    }

    private static Document parseXml(InputStream inputStream) throws Exception {
        try (inputStream) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(inputStream));
            document.getDocumentElement().normalize();

            return document;
        }
    }

    private static String getTagText(Document document, String tagName) {
        NodeList nodes = document.getElementsByTagName(tagName);

        if (nodes.getLength() == 0) {
            throw new IllegalArgumentException("Tag not found: " + tagName);
        }

        return nodes.item(0).getTextContent().trim();
    }

    private static List<String> getLines(Document document) {
        NodeList nodes = document.getElementsByTagName("line");
        List<String> lines = new ArrayList<>();

        for (int i = 0; i < nodes.getLength(); i++) {
            lines.add(nodes.item(i).getTextContent());
        }

        return lines;
    }
}
