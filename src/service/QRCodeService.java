import net.glxn.qrgen.javase.QRCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class QRCodeService {
    private static final Logger logger = LoggerFactory.getLogger(QRCodeService.class);

    public void generateQRCodeForBook(String bookInfo, String filePath) {
        if (bookInfo == null || bookInfo.isEmpty()) {
            throw new IllegalArgumentException("Book info cannot be null or empty.");
        }

        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty.");
        }

        File file = new File(filePath);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            QRCode.from(bookInfo).writeTo(fos);
        } catch (IOException e) {
            logger.error("Error generating QR code for book: ", e);
        }
    }
}
