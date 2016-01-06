package pl.lodz.p.carpooling.fileupload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Adrian Szwajkowski
 */
public class FileUploadUtil
{
    private static final String THUMBNAIL_FILE_EXTENSION = "gif";
    private static final ImageObserver DUMMY_OBSERVER = (img, infoflags, x, y, width, height) -> true;

    public static void storeFile(MultipartFile file, String path) throws IOException {
        Path filePath = Paths.get(path);
        File fileToStore = filePath.toFile();
        FileOutputStream fileToStoreOutputStream = new FileOutputStream(fileToStore);
        BufferedOutputStream fileToStoreBufferedStream = new BufferedOutputStream(fileToStoreOutputStream);
        fileToStoreBufferedStream.write(file.getBytes());
        fileToStoreBufferedStream.close();
    }

    public static void thumbnailImage(String originalImagePathString, String thumbnailPathString, int maxLongSide) throws IOException {
        Path sourceImagePath = Paths.get(originalImagePathString);
        File sourceImageFile = sourceImagePath.toFile();
        BufferedImage bufferedSourceImage = ImageIO.read(sourceImageFile);

        Path thumbnailPath = Paths.get(thumbnailPathString);
        File thumbnailFile = thumbnailPath.toFile();

        double scale;
        int bufferedSourceImageWidth = bufferedSourceImage.getWidth();
        int bufferedSourceImageHeight = bufferedSourceImage.getHeight();
        if (bufferedSourceImageWidth <= maxLongSide && bufferedSourceImageHeight <= maxLongSide) {
            ImageIO.write(bufferedSourceImage, THUMBNAIL_FILE_EXTENSION, thumbnailFile);
            return;
        }
        else if (bufferedSourceImageWidth >= bufferedSourceImageHeight) {
            scale = Math.min(maxLongSide, bufferedSourceImageWidth) / (double) bufferedSourceImageWidth;
        }
        else {
            scale = Math.min(maxLongSide, bufferedSourceImageHeight) / (double) bufferedSourceImageHeight;
        }

        BufferedImage thumbnailOut = new BufferedImage((int) (scale * bufferedSourceImage.getWidth()),
                (int) (scale * bufferedSourceImage.getHeight()), bufferedSourceImage.getType());
        Graphics2D thumbnailGraphics = thumbnailOut.createGraphics();
        AffineTransform transform = AffineTransform.getScaleInstance(scale, scale);
        thumbnailGraphics.drawImage(bufferedSourceImage, transform, DUMMY_OBSERVER);
        ImageIO.write(thumbnailOut, THUMBNAIL_FILE_EXTENSION, thumbnailFile);
    }
}
