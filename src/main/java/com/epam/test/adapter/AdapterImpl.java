package com.epam.test.adapter;

import java.util.stream.Stream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Implement methods body!
 */
public class AdapterImpl implements Adapter {
    @Override
    public Stream<Element> getElementsByTagName(Document document, String tagName) {
        //TODO implement this
        throw new UnsupportedOperationException("Method not implemented yet.");
    }

    @Override
    public Stream<Element> getElementsByTagName(Element element, String tagName) {
        //TODO implement this
        throw new UnsupportedOperationException("Method not implemented yet.");
    }

    @Override
    public Stream<Element> getChildElementsByTagName(Node node, String tagName) {
        //TODO implement this
        throw new UnsupportedOperationException("Method not implemented yet.");
    }

    @Override
    public Stream<String> xpathValues(Node node, String xpathSelector) {
        //TODO implement this
        throw new UnsupportedOperationException("Method not implemented yet.");
    }

    @Override
    public Stream<Node> xpathNodes(Node node, String expression) {
        //TODO implement this
        throw new UnsupportedOperationException("Method not implemented yet.");
    }
}