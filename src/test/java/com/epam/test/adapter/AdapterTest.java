package com.epam.test.adapter;

import static com.epam.test.adapter.Helper.parseXml;
import static java.nio.file.Paths.get;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.of;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import java.util.List;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

/**
 * Do not modify!
 */
public class AdapterTest {
    private final Adapter adapter = new AdapterImpl();
    private final Document document = parseXml(get("src/test/resources/10DT0000029352.xml"));

    @Test
    public void testAdapterGetElementByTagNameShouldReturnThreeIdentifiers() {
        // Given
        // When
        final List<String> result = of(document)
                .flatMap(d -> adapter.getElementsByTagName(d, "cdc-dottrina"))
                .flatMap(e -> adapter.getElementsByTagName(e, "extra-item"))
                .map(e -> e.getAttribute("chiave"))
                .collect(toList());
        // Then
        assertThat(result, hasItem("10DT0000029352SOMM"));
        assertThat(result, hasItem("10DT0000029352ART6"));
        assertThat(result, hasItem("10DT0000029352ART40"));
        assertThat(result.toString(), result, hasSize(3));
    }

    @Test
    public void testAdapterGetChildElementByTagNameShouldReturnThreeIdentifiers() {
        // Given
        // When
        final List<String> result = of(document)
                .flatMap(d -> adapter.getChildElementsByTagName(d, "cdc-dottrina"))
                .flatMap(e -> adapter.getChildElementsByTagName(e, "extra-info"))
                .flatMap(e -> adapter.getChildElementsByTagName(e, "extra-item"))
                .map(e -> e.getAttribute("chiave"))
                .collect(toList());
        // Then
        assertThat(result, hasItem("10DT0000029352SOMM"));
        assertThat(result, hasItem("10DT0000029352ART6"));
        assertThat(result, hasItem("10DT0000029352ART40"));
        assertThat(result.toString(), result, hasSize(3));
    }

    @Test
    public void testAdapterGetXpathShouldReturnThreeIdentifiers() {
        // Given
        // When
        final List<String> result = of(document)
                .flatMap(d -> adapter.xpathNodes(d, "/cdc-dottrina"))
                .flatMap(e -> adapter.xpathNodes(e, "//extra-item"))
                .flatMap(e -> adapter.xpathValues(e, "@chiave"))
                .collect(toList());
        // Then
        assertThat(result, hasItem("10DT0000029352SOMM"));
        assertThat(result, hasItem("10DT0000029352ART6"));
        assertThat(result, hasItem("10DT0000029352ART40"));
        assertThat(result.toString(), result, hasSize(3));
    }

    @Test
    public void testAdapterGetXpathShouldReturnOneText() {
        // Given
        // When
        final List<String> result = of(document)
                .flatMap(d -> adapter.xpathValues(d, "//extra-item[@id-ga='i1']/extra-classificazione/extra-classvoce[2]/extra-classinfo/text()"))
                .collect(toList());
        // Then
        assertThat(result, hasItem("Iva e Dogane"));
        assertThat(result.toString(), result, hasSize(1));
    }
}
