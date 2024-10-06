package com.processing;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageProcessor {

    // Method to resize the image
    public static ImageContainer resizeImage(ImageContainer imageContainer, int newWidth, int newHeight) throws IOException {
        BufferedImage originalImage = imageContainer.getImage();

        // Create a new BufferedImage with the desired dimensions
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());

        // Draw the original image resized into the new BufferedImage
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        g.dispose();

        // Return a new ImageContainer with the resized image
        return new ImageContainer(resizedImage);
    }
}