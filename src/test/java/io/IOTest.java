package io;

import org.example.io.IOUtils;
import org.junit.*;
import org.junit.runners.JUnit4;

import java.io.File;
import java.util.Date;

public class IOTest {

    public static final String TEST_TXT = "D:/test/test.txt";
    public static final String TEST_TXT_BUFF = "D:/test/test_buff.txt";

    @BeforeClass
    public static void init(){
        System.out.println("Initialization job");
        IOUtils.writeFile(TEST_TXT, "hello world!");
        IOUtils.writeFile(TEST_TXT_BUFF, "hello world!");
    }

    @AfterClass
    public static void destroy(){
        System.out.println("****** finalization job ******");
        remove(TEST_TXT);
        remove(TEST_TXT_BUFF);
        System.out.println("****** finalization job END. ******");
    }

    @Before
    public void initBeforeEach(){
        System.out.println("Initialization job before each");
    }

    @After
    public void destroyAfterEach(){
        System.out.println("finalization job before each ");
    }

    @Test
    public void testReadFile(){
        String fileContent = IOUtils.readFile(TEST_TXT);
        String expectedContent = "hello world!";
        Assert.assertEquals("ERROR MSG", fileContent, expectedContent);
    }

    @Test
    public void testReadFileWithBuff(){
        String fileContent = IOUtils.readFileWithBuff(TEST_TXT_BUFF);
        String expectedContent = "hello world!";
        Assert.assertEquals("ERROR MSG", fileContent, expectedContent);
    }

    @Test
    public void testReadFileNotExist(){
        String fileContent = IOUtils.readFile("D:/test/test123.txt");
        Assert.assertNull("ERROR MSG. FILE EXISTS!", fileContent);
    }

    @Test
    public void testWriteFile(){
        String content = "HELLO WORLD!";
        String dateLbl = new Date().toString().replaceAll(":", "_");

        String path = "D:/test/test_"+dateLbl+".txt";
        IOUtils.writeFile(path, content);

        remove(path);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testWriteFileWhenItsFolder(){
        String content = "HELLO WORLD!";
        String path = "D:/test";
        IOUtils.writeFile(path, content);
    }


    @Test
    public void testWriteFileWhenNewWrite(){
        String content = "HELLO WORLD!";
        String content2 = "HELLO WORLD2!";
        String path = "D:/test/test_original.txt";

        IOUtils.writeFile(path, content);
        IOUtils.writeFile(path, content2);

        Assert.assertEquals(content2, IOUtils.readFile(path));

    }

    @Test
    public void testWriteFileWithUpdate(){
        String initialContent = "HELLO WORLD!";
        String path = "D:/test/test_new.txt";

        IOUtils.writeFile(path, initialContent);
        IOUtils.writeOrUpdateFile(path, initialContent);

        Assert.assertEquals(initialContent+initialContent, IOUtils.readFile(path));

    }

    private static boolean remove(String path){
        File file = new File(path);
        boolean isDeleted = file.delete();
        if(isDeleted)
            System.out.println("Resource : '" + path + "' has been removed");
        return isDeleted;
    }


}
