package es.npatarino.android.gotchallenge;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import es.npatarino.android.gotchallenge.characters.GoTListFragment;
import es.npatarino.android.gotchallenge.houses.GoTHousesListFragment;

/**
 * Created by Manuel González Villegas on 28/9/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class HomeSectionsPagerAdapterTest {

    @Mock
    private HomeActivity mMockContext;

    private HomeSectionsPagerAdapter pagerAdapter;

    @Before
    public void setUp() {
        pagerAdapter = new HomeSectionsPagerAdapter(mMockContext);
    }

    @Test
    public void viewPager_hasTwoPages() throws Exception {
        Assert.assertEquals(pagerAdapter.getCount(), 2);
    }

    @Test
    public void firsrPageTitle_IsCharactersTitle() throws Exception {
        Assert.assertEquals(pagerAdapter.getPageTitle(0), mMockContext.getString(R.string.home_section_pager_characters));
    }

    @Test
    public void secondPageTitle_IsHousesTitle() throws Exception {
        Assert.assertEquals(pagerAdapter.getPageTitle(2), mMockContext.getString(R.string.home_section_pager_houses));
    }

    @Test
    public void firstPage_IsCharactersFragment() {
        Assert.assertEquals(pagerAdapter.getItem(0).getClass(), GoTListFragment.class);
    }

    @Test
    public void secondPage_IsHousesFragment() {
        Assert.assertEquals(pagerAdapter.getItem(1).getClass(), GoTHousesListFragment.class);
    }
}
