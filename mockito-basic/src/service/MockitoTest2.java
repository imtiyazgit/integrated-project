package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.stub;
import static org.junit.Assert.assertEquals;

class Dao {
    public List getAllPersonsFromDB(){
        // complex db logic
        return null;
    }
}

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest2 {
    @Mock
    Dao dao;

    @Test
    public void testGetAllFromDb() {
        List<String> persons = Arrays.asList("A","B");
        stub(dao.getAllPersonsFromDB()).toReturn(persons);
        assertEquals(2, dao.getAllPersonsFromDB().size());
    }

}
