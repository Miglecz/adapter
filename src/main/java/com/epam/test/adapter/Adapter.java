package com.epam.test.adapter;

import java.util.stream.Stream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Do not modify!
 */
public interface Adapter {
    Stream<Element> getElementsByTagName(Document document, String tagName);

    Stream<Element> getElementsByTagName(Element element, String tagName);

    Stream<Element> getChildElementsByTagName(Node node, String tagName);

    Stream<String> xpathValues(Node node, String xpathSelector);

    Stream<Node> xpathNodes(Node node, String expression);
}
