package ex5;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class RecursiveFileVisitor implements FileElementVisitor {
    private FileElementVisitor elementVisitor;
    private long totalFileSize = 0;
    private long totalDirectorySize = 0;

    RecursiveFileVisitor(FileElementVisitor elementVisitor) {
        this.elementVisitor = elementVisitor;
    }

    public void visit(Path directory) throws IOException {
        try (Stream<Path> stream = Files.list(directory)) {
            stream.forEach(path -> {
                try {
                    BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                    if (attrs.isDirectory()) {
                        elementVisitor.visitDirectory(path, attrs);
                        RecursiveFileVisitor subVisitor = new RecursiveFileVisitor(elementVisitor);
                        subVisitor.visit(path);  // Recursively visit subdirectory
                        totalDirectorySize += subVisitor.getTotalDirectorySize();
                        totalFileSize += subVisitor.getTotalFileSize();
                    } else {
                        elementVisitor.visitFile(path, attrs);
                        totalFileSize += attrs.size();
                    }
                } catch (IOException e) {
                    System.err.println("Falha ao acessar o arquivo: " + path);
                }
            });
        }
    }

    private long getTotalFileSize() {
        return totalFileSize;
    }

    private long getTotalDirectorySize() {
        return totalDirectorySize;
    }

    @Override
    public void visitFile(Path file, BasicFileAttributes attrs) {
        elementVisitor.visitFile(file, attrs);
    }

    @Override
    public void visitDirectory(Path dir, BasicFileAttributes attrs) {
        elementVisitor.visitDirectory(dir, attrs);
    }
}
