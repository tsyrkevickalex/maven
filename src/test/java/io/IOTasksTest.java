package io;

import org.example.io.IOTasks;
import org.junit.Assert;
import org.junit.Test;

public class IOTasksTest {

    @Test(timeout = 200)
    public void testFindTextInFile(){
        String search = "would youwant to stay? forced to stand still as a statue and silent as a shadow for hours on end while the lords";
        String bookPath = "C:\\Users\\Sharlan_A\\Downloads\\Deas_thief-takers_apprentice\\Deas_thief-takers_apprentice_2_Warlocks_shadow_RuLit_Net.txt";
        Assert.assertTrue(IOTasks.findInFile(bookPath, search));
        Assert.assertFalse(IOTasks.findInFile(bookPath, "ТЕКСТ"));

    }

    @Test(expected = RuntimeException.class)
    public void testFindTextInFileWhenFileNotExists(){
        String search = "would youwant to stay? forced to stand still as a statue and silent as a shadow for hours on end while the lords";
        String bookPath = "C:\\Users\\Deas_thief-takers_apprentice_2_Warlocks_shadow_RuLit_Net.txt";
        IOTasks.findInFile(bookPath, search);
    }
}
