package com.processing;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import static org.junit.jupiter.api.Assertions.*;

class ImageProcessorTest {

    @Test
    void testImageResizeAndExport() {
        try {
            // Arrange: Load the original image from resources
            ImageContainer originalImage = new ImageContainer("src/main/resources/file_examples/file_example_JPG.jpg");

            // Act: Resize the image
            ImageContainer resizedImage = ImageProcessor.resizeImage(originalImage, 100, 100);

            // Export the resized image as PNG
            resizedImage.exportImage("src/main/resources/output_test.png", "png");

            // Assert: Check that the resized image was saved
            File resizedImageFile = new File("src/main/resources/output_test.png");
            assertTrue(resizedImageFile.exists(), "Resized image file should exist");

            // Act & Assert: Verify the dimensions of the resized image
            BufferedImage bufferedResizedImage = ImageIO.read(resizedImageFile);
            assertEquals(100, bufferedResizedImage.getWidth(), "Resized image should have width 100");
            assertEquals(100, bufferedResizedImage.getHeight(), "Resized image should have height 100");

        } catch (IOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testImageProcessJPG() {
        try {
            // Arrange: Load the original image from resources
            System.out.println("Current working directory: " + System.getProperty("user.dir"));
            ImageContainer originalImage = new ImageContainer("src/main/resources/file_examples/file_example_JPG.jpg");

            // Act: Resize the image
            ImageContainer resizedImage = ImageProcessor.resizeImage(originalImage, 100, 100);

            // Export the resized image as PNG
            resizedImage.exportImage("src/main/resources/output_test.jpg", "jpg");

            // Assert: Check that the resized image was saved
            File resizedImageFile = new File("src/main/resources/output_test.jpg");
            assertTrue(resizedImageFile.exists(), "Resized image file should exist");

            // Act & Assert: Verify the dimensions of the resized image
            BufferedImage bufferedResizedImage = ImageIO.read(resizedImageFile);
            assertEquals(100, bufferedResizedImage.getWidth(), "Resized image should have width 100");
            assertEquals(100, bufferedResizedImage.getHeight(), "Resized image should have height 100");

        } catch (IOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testImageProcessPNG() {
        try {
            // Arrange: Load the original image from resources
            System.out.println("Current working directory: " + System.getProperty("user.dir"));
            ImageContainer originalImage = new ImageContainer("src/main/resources/file_examples/file_example_PNG.png");

            // Act: Resize the image
            ImageContainer resizedImage = ImageProcessor.resizeImage(originalImage, 100, 100);

            // Export the resized image as PNG
            resizedImage.exportImage("src/main/resources/output_test.png", "png");

            // Assert: Check that the resized image was saved
            File resizedImageFile = new File("src/main/resources/output_test.png");
            assertTrue(resizedImageFile.exists(), "Resized image file should exist");

            // Act & Assert: Verify the dimensions of the resized image
            BufferedImage bufferedResizedImage = ImageIO.read(resizedImageFile);
            assertEquals(100, bufferedResizedImage.getWidth(), "Resized image should have width 100");
            assertEquals(100, bufferedResizedImage.getHeight(), "Resized image should have height 100");

        } catch (IOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testImageProcessTIFF() {
        try {
            // Arrange: Load the original image from resources
            System.out.println("Current working directory: " + System.getProperty("user.dir"));
            ImageContainer originalImage = new ImageContainer("src/main/resources/file_examples/file_example_TIFF.tiff");

            // Act: Resize the image
            ImageContainer resizedImage = ImageProcessor.resizeImage(originalImage, 100, 100);

            // Export the resized image as PNG
            resizedImage.exportImage("src/main/resources/output_test.tiff", "tiff");

            // Assert: Check that the resized image was saved
            File resizedImageFile = new File("src/main/resources/output_test.tiff");
            assertTrue(resizedImageFile.exists(), "Resized image file should exist");

            // Act & Assert: Verify the dimensions of the resized image
            BufferedImage bufferedResizedImage = ImageIO.read(resizedImageFile);
            assertEquals(100, bufferedResizedImage.getWidth(), "Resized image should have width 100");
            assertEquals(100, bufferedResizedImage.getHeight(), "Resized image should have height 100");

        } catch (IOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testImageProcessGIF() {
        try {
            // Arrange: Load the original image from resources
            System.out.println("Current working directory: " + System.getProperty("user.dir"));
            ImageContainer originalImage = new ImageContainer("src/main/resources/file_examples/file_example_GIF.gif");

            // Act: Resize the image
            ImageContainer resizedImage = ImageProcessor.resizeImage(originalImage, 100, 100);

            // Export the resized image as PNG
            resizedImage.exportImage("src/main/resources/output_test.gif", "gif");

            // Assert: Check that the resized image was saved
            File resizedImageFile = new File("src/main/resources/output_test.gif");
            assertTrue(resizedImageFile.exists(), "Resized image file should exist");

            // Act & Assert: Verify the dimensions of the resized image
            BufferedImage bufferedResizedImage = ImageIO.read(resizedImageFile);
            assertEquals(100, bufferedResizedImage.getWidth(), "Resized image should have width 100");
            assertEquals(100, bufferedResizedImage.getHeight(), "Resized image should have height 100");

        } catch (IOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testImageProcessBMP() {
        try {
            // Arrange: Load the original image from resources
            System.out.println("Current working directory: " + System.getProperty("user.dir"));
            ImageContainer originalImage = new ImageContainer("src/main/resources/file_examples/file_example_BMP.bmp");

            // Act: Resize the image
            ImageContainer resizedImage = ImageProcessor.resizeImage(originalImage, 100, 100);

            // Export the resized image as PNG
            resizedImage.exportImage("src/main/resources/output_test.bmp", "bmp");

            // Assert: Check that the resized image was saved
            File resizedImageFile = new File("src/main/resources/output_test.bmp");
            assertTrue(resizedImageFile.exists(), "Resized image file should exist");

            // Act & Assert: Verify the dimensions of the resized image
            BufferedImage bufferedResizedImage = ImageIO.read(resizedImageFile);
            assertEquals(100, bufferedResizedImage.getWidth(), "Resized image should have width 100");
            assertEquals(100, bufferedResizedImage.getHeight(), "Resized image should have height 100");

        } catch (IOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @AfterEach
    void cleanup() throws IOException {
        File resizedImageFile = new File("resources/output_test.png");
        if (resizedImageFile.exists()) {
            if (resizedImageFile.delete()) {
                throw new IOException("File not found " + resizedImageFile.getPath());
            }
        }
    }
}