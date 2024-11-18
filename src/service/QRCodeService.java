import net.glxn.qrgen.javase.QRCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class QRCodeService {
    private static final Logger logger = LoggerFactory.getLogger(QRCodeService.class);

    /**
     * Generates a QR code for the provided book information and saves it to the specified file path.
     * 
     * @param bookInfo The information about the book (e.g., title, author) to encode in the QR code.
     * @param filePath The file path to save the generated QR code image.
     */
    public void generateQRCodeForBook(String bookInfo, String filePath) {
        if (bookInfo == null || bookInfo.isEmpty()) {
            throw new IllegalArgumentException("Book info cannot be null or empty.");
        }

        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty.");
        }

        // Ensure the directory exists
        File file = new File(filePath);
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            boolean created = parentDir.mkdirs();  // Creates the directory if it doesn't exist
            if (created) {
                logger.info("Created directories for file path: " + parentDir.getAbsolutePath());
            } else {
                logger.warn("Failed to create directories for file path: " + parentDir.getAbsolutePath());
            }
        }

        // Try generating the QR code and saving it to the specified file
        try (FileOutputStream fos = new FileOutputStream(file)) {
            QRCode.from(bookInfo).writeTo(fos);
            logger.info("QR code successfully generated for book info: " + bookInfo);
        } catch (IOException e) {
            logger.error("Error generating QR code for book: ", e);
        }
    }

    /**
     * Helper method to test the QR code generation.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        QRCodeService qrCodeService = new QRCodeService();
        String bookInfo = "Title: The Great Gatsby\nAuthor: F. Scott Fitzgerald\nISBN: 9780743273565";
        String filePath = "qrcodes/TheGreatGatsbyQRCode.png";

        qrCodeService.generateQRCodeForBook(bookInfo, filePath);
    }
}
