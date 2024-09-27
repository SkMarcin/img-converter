package com.processing;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageContainer {

    private BufferedImage image;

    // Constructor to load the image
    public ImageContainer(String imagePath) throws IOException {
        loadImage(imagePath);
    }

    public ImageContainer(BufferedImage newImage) {
        image = newImage;
    }

    // Method to load the image from a file
    private void loadImage(String imagePath) throws IOException {
        File imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            throw new IOException("File not found: " + imagePath);
        }
        image = ImageIO.read(imageFile);
        System.out.println("Image loaded successfully.");
    }


    // Method to export the image to a file
    public void exportImage(String outputFilePath, String format) throws IOException {
        BufferedImage imageToExport = image;

        File outputFile = new File(outputFilePath);
        boolean success = ImageIO.write(imageToExport, format, outputFile);
        if (!success) {
            throw new IOException("Failed to export the image.");
        }
        System.out.println("Image exported successfully to " + outputFilePath);
    }

    // Getter to access the BufferedImage
    public BufferedImage getImage() {
        return image;
    }

    public static void main(String[] args) {
        try {
            // Example usage
            ImageContainer image = new ImageContainer("backend/src/main/resources/file_example_JPG_500kB.jpg");
            ImageContainer resizedImage = ImageProcessor.resizeImage(image, 100, 100);

            // Export as original size JPG
            image.exportImage("backend/src/main/resources/output.jpg", "jpg");

            // Export as resized PNG
            resizedImage.exportImage("backend/src/main/resources/output.png", "png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

