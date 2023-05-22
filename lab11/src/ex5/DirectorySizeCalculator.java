package ex5;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class DirectorySizeCalculator {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Uso: java DirectorySizeCalculator <diretório> [-r]");
            System.exit(1);
        }

        String directoryPath = args[0];
        boolean recursive = args.length > 1 && args[1].equals("-r");

        FileElementVisitor visitor = new SizeVisitor();

        if (recursive) {
            RecursiveFileVisitor fileVisitor = new RecursiveFileVisitor(visitor);
            fileVisitor.visit(Paths.get(directoryPath));
        } else {
            NonRecursiveFileVisitor fileVisitor = new NonRecursiveFileVisitor(visitor);
            try (Stream<Path> stream = Files.list(Paths.get(directoryPath))) {
                stream.forEach(file -> {
                    try {
                        BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
                        fileVisitor.visitFile(file, attrs);
                    } catch (IOException e) {
                        System.err.println("Falha ao acessar o arquivo: " + file);
                    }
                });
            }
        }

        System.out.println("Total: " + ((SizeVisitor) visitor).getTotalSize() + " bytes");
    }
}




