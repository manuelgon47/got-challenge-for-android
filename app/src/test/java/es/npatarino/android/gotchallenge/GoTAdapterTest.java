package es.npatarino.android.gotchallenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import es.npatarino.android.gotchallenge.characters.GoTAdapter;

/**
 * Created by Manuel González Villegas on 28/9/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class GoTAdapterTest {

    @Mock
    private HomeActivity mMockContext;

    private GoTAdapter adapter;

    @Before
    public void setUp() {
        adapter = new GoTAdapter(mMockContext);
    }

    @Test
    public void charactersList_IsNotNull() throws Exception {
        Assert.assertTrue(adapter.getGcs() != null);

    }


}
