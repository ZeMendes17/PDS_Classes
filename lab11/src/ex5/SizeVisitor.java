package ex5;



import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


public class SizeVisitor implements FileElementVisitor {
    private long totalFileSize;
    private long totalDirectorySize;

    @Override
    public void visitFile(Path file, BasicFileAttributes attrs) {
        totalFileSize += attrs.size();
        System.out.println(file.getFileName() + ": " + attrs.size() + " bytes");
    }

    @Override
    public void visitDirectory(Path dir, BasicFileAttributes attrs) {
        System.out.println("| -> " + dir.getFileName() + "/");
    }

    public long getTotalFileSize() {
        return totalFileSize;
    }

    public long getTotalDirectorySize() {
        return totalDirectorySize;
    }

    public long getTotalSize() {
        return totalFileSize + totalDirectorySize;
    }
}

