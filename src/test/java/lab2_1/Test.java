package lab2_1;

import static org.junit.Assert.*;

import org.junit.Before;

import static org.hamcrest.core.Is.is;

import edu.iis.mto.bsearch.SearchResult;
import static edu.iis.mto.bsearch.BinarySearch.search;

public class Test {

    private int singleElementSeq[] = new int[1];
    private int seq[] = new int[20];

    @Before
    public void initTest() {
        for (int i = 0; i < seq.length; i++) {
            seq[i] = i;
        }

        singleElementSeq[0] = 1;
    }

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
    
    @org.junit.Test
    public void FirstElementInSeq() {
        SearchResult result = search(seq[0], seq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(1));
    }
    
    @org.junit.Test
    public void LastElementInSeq() {
        SearchResult result = search(seq[seq.length-1], seq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(seq.length));
    }
}
