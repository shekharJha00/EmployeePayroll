import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

@SuppressWarnings("resource")
public class IOServiceTest {
    private static final String HOME = System.getProperty("user.home");
    private static final String IO_FILE = "TempFolder";

    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {
        Path pathHome = Paths.get(HOME);
        Assert.assertTrue(Files.exists(pathHome));

        Path pathFile = Paths.get(HOME + "/" + IO_FILE);
        if (Files.exists(pathFile))
            FileUtils.deleteFiles(pathFile.toFile());
        Assert.assertTrue(Files.notExists(pathFile));

        Files.createDirectory(pathFile);
        Assert.assertTrue(Files.exists(pathFile));

        IntStream.range(1,5).forEach(crt -> {
            Path pathTemp = Paths.get(pathFile+"/temp"+crt);
            Assert.assertTrue(Files.notExists(pathTemp));
            try {
                Files.createFile(pathTemp);
            }catch (IOException ignored) {
            }
            Assert.assertTrue(Files.exists(pathTemp));
        });
        Files.list(pathFile).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(pathFile).forEach(System.out::println);
        Files.newDirectoryStream(pathFile, path -> path.toFile().isFile() && path.toString().startsWith("temp")).forEach(System.out::println);
    }

}

