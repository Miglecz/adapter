package com.epam.test.adapter;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.file.Path;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 * Do not modify!
 */
public class Helper {
    public static Document parseXml(Path path) {
        try {
            final InputSource inputSource = new InputSource(new InputStreamReader(new FileInputStream(path.toFile()), "UTF-8"));
            inputSource.setEncoding("UTF-8");
            final DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            builder.setEntityResolver((publicId, systemId) -> new InputSource(new StringReader("")));
            return builder.parse(inputSource);
        } catch (Exception e) {
            throw new RuntimeException("xml error of file='" + path.toAbsolutePath() + "'", e);
        }
    }
}
