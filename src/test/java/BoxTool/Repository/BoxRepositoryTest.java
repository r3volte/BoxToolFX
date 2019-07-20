package boxTool.repository;

import boxTool.data.Box;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.ArrayList;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoxRepositoryTest {


    @Test
    public void shouldAddBoxToList() {
        DataRepository boxRepo = new BoxRepository();
        List<Box> beforeAdd = new ArrayList<>();
        Box box = new Box(120, 120, 120);
        boxRepo.add(box);
        assertEquals(beforeAdd.size() + 1, boxRepo.getComponent().size());
    }

    @Test
    public void shouldRemoveBoxFromList() {
        DataRepository boxRepo = new BoxRepository();
        List<Box> afterRemove = new ArrayList<>();
        Box box = new Box(120, 120, 120);
        boxRepo.delete(box);
        assertEquals(afterRemove.size(), boxRepo.getComponent().size());
    }

    @Test
    public void shouldBeJSonException() {
        //given
        DataRepository repo = new BoxRepository();
        List<Box> myList = new ArrayList<>();
        //when
        repo.fileConverter(myList);
        //then
        assertThrows(JSONException.class, () -> JSONAssert
                .assertEquals("", repo.fileConverter(myList), true));
    }

    @Test
    public void shouldGetConvertedJSon() throws JSONException {
        //given
        DataRepository repo = new BoxRepository();
        Box box = new Box(320, 200, 90);
        List<Box> myList = new ArrayList<>();
        myList.add(box);
        //when
        repo.fileConverter(myList);
        //then
        JSONAssert.assertEquals("[{\"number\":320,\"height\":90,\"width\":200}]", repo.fileConverter(myList), true);
        JSONAssert.assertEquals("[{\"height\":90,\"number\":320,\"width\":200}]", repo.fileConverter(myList), false);
    }

}
