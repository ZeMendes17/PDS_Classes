package ex5;



import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;


public class NonRecursiveFileVisitor implements FileElementVisitor {
    private FileElementVisitor elementVisitor;

    public NonRecursiveFileVisitor(FileElementVisitor elementVisitor) {
        this.elementVisitor = elementVisitor;
    }

    @Override
    public void visitFile(Path file, BasicFileAttributes attrs) {
        elementVisitor.visitFile(file, attrs);
    }

    @Override
    public void visitDirectory(Path dir, BasicFileAttributes attrs) {
        elementVisitor.visitDirectory(dir, attrs);

        try (Stream<Path> stream = Files.list(dir)) {
            stream.forEach(path -> {
                try {
                    BasicFileAttributes fileAttrs = Files.readAttributes(path, BasicFileAttributes.class);
                    if (fileAttrs.isDirectory()) {
                        NonRecursiveFileVisitor subVisitor = new NonRecursiveFileVisitor(elementVisitor);
                        subVisitor.visitDirectory(path, fileAttrs);
                    } else {
                        elementVisitor.visitFile(path, fileAttrs);
                    }
                } catch (IOException e) {
                    System.err.println("Falha ao acessar o arquivo: " + path);
                }
            });
        } catch (IOException e) {
            System.err.println("Falha ao listar o diretório: " + dir);
        }
    }
}
