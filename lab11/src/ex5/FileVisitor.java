package ex5;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class FileVisitor extends SimpleFileVisitor<Path> {
    private FileElementVisitor elementVisitor;

    public FileVisitor(FileElementVisitor elementVisitor) {
        this.elementVisitor = elementVisitor;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        elementVisitor.visitFile(file, attrs);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.err.println("Falha ao acessar o arquivo: " + file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        elementVisitor.visitDirectory(dir, attrs);
        return FileVisitResult.CONTINUE;
    }
}
