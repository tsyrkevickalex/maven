package org.example.io;

public class IOTasks {
    public static boolean findInFile(String filePath, String search){
        String content = IOUtils.readFileWithBuff(filePath);
        if(content == null){
            throw new RuntimeException("File not exists. Path is " + filePath);
        }
        return content.toLowerCase().contains(search.toLowerCase());

    }

    public static void replace(String path, String str1, String str2){
        String filecontent = IOUtils.readFileWithBuff(path);
        if(filecontent == null){
            throw new RuntimeException("File not exist. Path is" + path);

        }
        String file2 = filecontent.replaceAll(str1, str2);
        IOUtils.writeFile(path, file2);

    }



    public static void mergeFiles(String targetPath, String... paths){
        for (String path: paths) {
            //TODO
        }
    }

    public static void main(String[] args) {
        mergeFiles("TEST", "TEST2");
        mergeFiles("TEST", "TEST2", "!@#", "123");
        mergeFiles("TEST");
    }


}
