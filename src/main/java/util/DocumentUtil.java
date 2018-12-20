package util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.nio.file.Path;
import java.util.Optional;

/**
 * Created by shiraz on 20/12/2018.
 */
public class DocumentUtil {
    public static Optional<String> getFileNameWithoutExtension(Path path) {
        return Optional.of(FilenameUtils.getBaseName(path.getFileName().toString()));
    }
}
