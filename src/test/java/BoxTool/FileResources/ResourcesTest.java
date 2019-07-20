package boxTool.fileResources;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ResourcesTest {

    @Test
    public void loadXMLTest() {

        ClassLoader classLoader = getClass().getClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream("xml/data.xml")) {

            String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);


            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
