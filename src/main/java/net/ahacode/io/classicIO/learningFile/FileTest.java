package net.ahacode.io.classicIO.learningFile;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class FileTest {
    public static void main(String[] args) {
        fileSeparator();
        //absolute path
        printFileInfo(getWorkingPath(), "test-file1.txt");

        System.out.println();

        //relative path
        printFileInfo("src");
        System.out.println();

        printFileInfo("../test-file3.txt");
        System.out.println();
        printFileInfo("../", "test-file4.txt");

        // list file system roots and disk info
        File[] roots = File.listRoots();
        for (File root : roots) {
            System.out.println(root);
            System.out.println("Free space: " + bytesToGb(root.getFreeSpace()) + "GB");
            System.out.println("Total space: " + bytesToGb(root.getTotalSpace()) + "Gb");
            System.out.println("Usable space: " + bytesToGb(root.getUsableSpace()) + "GB");
            System.out.println();
        }

        // list of directories
        listOfFilenames(getWorkingPath());
        System.out.println();
        listSubFiles("C:\\Users\\steve\\Desktop");
        System.out.println();
        listFilesWithFilter("C:\\Users\\steve\\Desktop");
        //temp dir
        System.out.println(getTmpDir());

        // temp file
        File tmp = createTmpFile("text", ".txt");
        System.out.println(tmp);
        deleteFileOnExit(tmp);
    }

    private static void listOfFilenames(String path) {
        File file = new File(path);
        String[] files = file.list();
        if (files != null) {
            for (String fileName : files) {
                System.out.println(fileName);
            }
        }
    }

    private static void listSubFiles(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        if (files == null) {
            return;
        }
        for (File subFile : files) {
            System.out.println(subFile);
        }
    }

    private static void listFilesWithFilter(String path) {
        File file = new File(path);
        File[] files = file.listFiles((dir, name) -> name.endsWith("lnk"));
        if (files == null) {
            System.out.println("No files listed");
            return;
        }
        System.out.println("sub files: " + files.length);
        for (File subFile : files) {
            System.out.println(subFile);
        }
    }

    private static void fileSeparator() {
        System.out.println(System.getProperty("file.separator"));
        System.out.println(File.separator);
        System.out.println(File.separatorChar);
    }

    private static void storedAbstractPaths(File file) {
        System.out.println("File absolute path:\t" + file.getAbsolutePath());
        System.out.println("File path:\t" + file.getPath());
        System.out.println("Is absolute: " + file.isAbsolute());
        System.out.println("File absolute file:\t" + file.getAbsoluteFile());
        System.out.println("File name:\t" + file.getName());
        try {
            System.out.println("Canonical Path:\t" + file.getCanonicalPath());
        } catch (IOException ex) {
            //ignore.
        }
        System.out.println("Parent:\t" + file.getParent());
        System.out.println("File exists: " + file.exists());
        System.out.println("File isDirectory: " + file.isDirectory());
        System.out.println("File isFile: " + file.isFile());
        System.out.println("File isHidden: " + file.isHidden());
        System.out.println("Last Modified: " + LocalDateTime.ofInstant(Instant.ofEpochMilli(file.lastModified()), ZoneId.systemDefault()));
        System.out.println("Length: " + file.length());
    }

    private static String getWorkingPath() {
        return System.getProperty("user.dir");
    }

    private static String getTmpDir() {
        return System.getProperty("java.io.tmpdir");
    }

    private static File createTmpFile(String prefix, String suffix) {
        try {
            return File.createTempFile(prefix, suffix);
        } catch (IOException ex) {
            // ignore
        }
        return null;
    }
    private static void deleteFileOnExit(File file){
        if(file != null){
            file.deleteOnExit();;
        }
    }

    private static void printFileInfo(String parent, String fileName) {
        File file = new File(parent, fileName);
        storedAbstractPaths(file);
    }

    private static void printFileInfo(String path) {
        File file = new File(path);
        storedAbstractPaths(file);
    }

    /**
     * convert byte to gigabyte. truncate decimals
     */
    private static long bytesToGb(long bytes) {
        return bytes / 1024 / 1024 / 1024;
    }
}
