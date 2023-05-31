package ex5;


import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

interface FileElementVisitor {
    void visitFile(Path file, BasicFileAttributes attrs);

    void visitDirectory(Path dir, BasicFileAttributes attrs);
}



