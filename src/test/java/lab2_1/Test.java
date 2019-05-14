package lab2_1;

import static org.junit.Assert.*;

import org.junit.Before;

import static org.hamcrest.core.Is.is;

import edu.iis.mto.bsearch.SearchResult;
import static edu.iis.mto.bsearch.BinarySearch.search;

public class Test {

    private int singleElementSeq[] = new int[1];
    private int seq[] = new int[20];
    private int emptySeq[] = new int[0];
    private int notLinearSeq[] = {1, 3, 6, 9, 16, 17};

    @Before
    public void initTest() {
        for (int i = 0; i < seq.length; i++) {
            seq[i] = i;
        }

        singleElementSeq[0] = 1;
    }

    @org.junit.Test
    public void IsSingleElementInSeq() {
        SearchResult result = search(singleElementSeq[0], singleElementSeq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(1));
    }

    @org.junit.Test
    public void IsNotInSingleSeq() {
        SearchResult result = search(singleElementSeq[0] + 1, singleElementSeq);
        assertThat(result.isFound(), is(false));
        assertThat(result.getPosition(), is(-1));
    }

    @org.junit.Test
    public void IsFirstElementInSeq() {
        SearchResult result = search(seq[0], seq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(1));
    }

    @org.junit.Test
    public void IsLastElementInSeq() {
        SearchResult result = search(seq[seq.length - 1], seq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(seq.length));
    }

    @org.junit.Test
    public void IsMidElementInSeq() {
        SearchResult result = search(seq[seq.length / 2], seq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(seq.length / 2 + 1));
    }

    @org.junit.Test
    public void IsNotInSeq() {
        SearchResult result = search(seq.length * 2, seq);
        assertThat(result.isFound(), is(false));
        assertThat(result.getPosition(), is(-1));
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void IsSeqEmpty() {
        SearchResult result = search(-1, emptySeq);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void IsNotLinearSeq() {
        SearchResult result = search(1, notLinearSeq);
    }
}
