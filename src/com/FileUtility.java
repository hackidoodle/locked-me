package com;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileUtility {
    private static final String WORKING_DIR = "digital_locker";

    static {
        File directory = new File(WORKING_DIR);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public static void listAllFiles() {
        File folder = new File(WORKING_DIR);
        String[] fileArray = folder.list();

        if (fileArray == null || fileArray.length == 0) {
            System.out.println("🗃️  No files found in the locker.");
            return;
        }

        List<String> files = Arrays.asList(fileArray);
        Collections.sort(files, String::compareToIgnoreCase);
        System.out.println("\n📂 Files in locker (sorted):");
        files.forEach(f -> System.out.println(" - " + f));
    }

    public static void addNewFile(String fileName) {
        File file = new File(WORKING_DIR + File.separator + fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("✅ File added: " + fileName);
            } else {
                System.out.println("⚠️  File already exists.");
            }
        } catch (IOException e) {
            System.out.println("❌ Error while creating the file: " + e.getMessage());
        }
    }

    public static void deleteFile(String fileName) {
        File file = new File(WORKING_DIR + File.separator + fileName);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("🗑️  File deleted: " + fileName);
            } else {
                System.out.println("⚠️  Could not delete file.");
            }
        } else {
            System.out.println("❌ File not found: " + fileName);
        }
    }

    public static void searchFile(String fileName) {
        File folder = new File(WORKING_DIR);
        String[] files = folder.list();

        boolean found = files != null && Arrays.asList(files).contains(fileName);

        if (found) {
            System.out.println("🔍 File located: " + fileName);
        } else {
            System.out.println("❌ File not present in locker.");
        }
    }
}
