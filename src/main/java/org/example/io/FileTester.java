package org.example.io;

import java.io.File;

public class FileTester {


    public static void main(String[] args) {


//        String pathname = "D:\\test";
//        File file = new File( pathname);
//        if(file.exists()){
//            if(file.isFile()){
//                System.out.println(pathname + " is FILE");
//            } else if(file.isDirectory()){
//                System.out.println(pathname + " is FOLDER");
//            }
//        } else {
//            System.out.println(pathname + " NOT exists");
//        }
//
//       File d = new File("D:\\");
//        for(File outer : d.listFiles()){
//            //FOLDER
//            if(outer.isDirectory()){
//
//                System.out.println("FOLDER: " + outer.getName());
//                File[] files = outer.listFiles();
//                if(files == null){ // empty folder
//                    continue;
//                }
//                for (File inner : files){
//                    if(inner.isDirectory()){
//                        System.out.println("FOLDER: " + inner.getName());
//                    } else {
//                        System.out.println("FILE: " + inner.getName());
//                    }
//                }
//            } else {
//                // FILE
//                System.out.println("FILE: " + outer.getName());
//            }
//        }

        printFilesStat("C:\\");
    }

    public static void printFilesStat(String path){
        File file = new File(path);
        if(file.exists()){
          if(file.isFile()){
              System.out.println("FILE: " + file.getName());
          } else {
              System.out.println("FOLDER: " + file.getName());
              File[] files = file.listFiles();
              if(files != null){
                  for(File f : files){
                      printFilesStat(f.getPath());
                  }
              } else {
                  System.out.println("---------> FOLDER is EMPTY!");
              }

          }
        } else {
            System.out.println(path + " does not exist!");
        }

    }

}
