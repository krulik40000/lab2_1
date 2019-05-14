package lab2_1;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import edu.iis.mto.bsearch.SearchResult;
import static edu.iis.mto.bsearch.BinarySearch.search;

public class Test {

    private int singleElementSeq[] = new int[1];

    @org.junit.Test
    public void SingleElementInSeq() {
        SearchResult result = search(singleElementSeq[0], singleElementSeq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(1));
    }

    @org.junit.Test
    public void NotInSeq() {
        SearchResult result = search(singleElementSeq[0] + 1, singleElementSeq);
        assertThat(result.isFound(), is(false));
        assertThat(result.getPosition(), is(-1));
    }
}
