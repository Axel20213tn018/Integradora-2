package mx.edu.utez.REDRE.services.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class FilesStorageServiceImpl implements FilesStorageService{

    private final Path root = Paths.get("docs");

    @Override
    public void init() {
        try{
            Files.createDirectories(root);
        }catch (IOException e){
            throw new RuntimeException("Error");
        }
    }

    @Override
    public void save(MultipartFile file) {
        try{
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        }catch (Exception e){
            if (e instanceof FileAlreadyExistsException){
                throw new RuntimeException("Ese archivo ya existe");
            }

            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Resource load(String filaName) {
        try {
            Path file = root.resolve(filaName);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()){
                return resource;
            } else {
                throw new RuntimeException("No se puede leer el archivo");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }
}
