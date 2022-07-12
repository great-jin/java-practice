package basis.upgrade.io;

import org.apache.tika.detect.DefaultDetector;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ContentTest {

    private final String sourcePath = "src\\main\\resources\\user.csv";

    /**
     * Get File ContentType
     */
    @Test
    public void ContentType() throws IOException {
        try (InputStream in = new FileInputStream(sourcePath)) {
            final DefaultDetector detector = new DefaultDetector();
            final TikaInputStream tikaStream = TikaInputStream.get(in);
            final Metadata metadata = new Metadata();
            metadata.set(Metadata.RESOURCE_NAME_KEY, "user.csv");
            final MediaType mediatype = detector.detect(tikaStream, metadata);
            String mimeType = mediatype.toString();

            System.out.println(mimeType);
        }
    }
}
