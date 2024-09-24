package com.processing;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageContainer {

    private BufferedImage image;

    // Constructor to load the image
    public ImageContainer(String imagePath) throws IOException {
        loadImage(imagePath);
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

    // Method to resize the image if needed
    public BufferedImage resizeImage(int newWidth, int newHeight) {
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, image.getType());
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(image, 0, 0, newWidth, newHeight, null);
        g.dispose();
        return resizedImage;
    }

    // Method to export the image to a file
    public void exportImage(String outputFilePath, String format, int width, int height) throws IOException {
        BufferedImage imageToExport = image;

        // Resize image if new dimensions are provided
        if (width > 0 && height > 0) {
            imageToExport = resizeImage(width, height);
        }

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
            ImageContainer processor = new ImageContainer("resources/file_example_JPG_500kB.jpg");

            // Export as resized JPG
            processor.exportImage("resources/output.jpg", "jpg", 800, 600);

            // Export as original size PNG
            processor.exportImage("resources/output.png", "png", -1, -1);  // Passing -1 means keep original size
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

