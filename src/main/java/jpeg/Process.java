package jpeg;

import Jama.Matrix;
import enums.ColorType;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Process {

    private BufferedImage originalImage;
    private int imageHeight;
    private int imageWidth;

    private int[][] originalRed, modifiedRed;
    private int[][] originalGreen, modifiedGreen;
    private int[][] originalBlue, modifiedBlue;

    private Matrix originalY, modifiedY;
    private Matrix originalCb, modifiedCb;
    private Matrix originalCr, modifiedCr;


    public void setOriginalRGB() {
        for (int h = 0; h < imageHeight; h++) {
            for (int w = 0; w < imageWidth; w++) {
                Color color = new Color(originalImage.getRGB(w, h));
                originalRed[h][w] = color.getRed();
                originalBlue[h][w] = color.getBlue();
                originalGreen[h][w] = color.getGreen();
            }

        }
    }

    public BufferedImage getImageFromRGB() {
        BufferedImage bfImage = new BufferedImage(
                imageWidth, imageWidth, BufferedImage.TYPE_INT_RGB);
        for (int h = 0; h < imageHeight; h++) {
            for (int w = 0; w < imageWidth; w++) {
                bfImage.setRGB(w, h, (new Color(modifiedRed[h][w], modifiedGreen[h][w], modifiedBlue[h][w])).getRGB());
            }
        }

        return bfImage;
    }

    public BufferedImage showOneColorImageFromRGB(int[][] color, ColorType type, boolean greyScale) {

        BufferedImage bfImage = new BufferedImage(
                imageWidth, imageWidth, BufferedImage.TYPE_INT_RGB);
        for (int h = 0; h < imageHeight; h++) {
            for (int w = 0; w < imageWidth; w++) {
                if (greyScale = true) {
                    bfImage.setRGB(w, h, (new Color(color[h][w], color[h][w], color[h][w])).getRGB());
                }
                switch (type) {
                    case RED:
                        bfImage.setRGB(w, h, (new Color(color[h][w], 0, 0)).getRGB());
                        break;
                    case GREEN:
                        bfImage.setRGB(w, h, (new Color(0, color[h][w], 0)).getRGB());
                        break;
                    case BLUE:
                        bfImage.setRGB(w, h, (new Color(0, 0, color[h][w])).getRGB());
                        break;
                }
            }
        }

        return bfImage;
    }

    public BufferedImage showOneColorFromYCbCr(Matrix color) {
        BufferedImage bfImage = new BufferedImage(
                imageWidth, imageWidth, BufferedImage.TYPE_INT_RGB);

        double [][] colorOrigin = color.getArray();
        for (int h = 0; h < imageHeight; h++) {
            for (int w = 0; w < imageWidth; w++) {
                bfImage.setRGB(w,h, (new Color(colorOrigin[w][h] > 255 ? 255 : 0,colorOrigin[w][h] > 255 ? 255 : 0, colorOrigin[w][h] > 255 ? 255 : 0).getRGB()));
            }
        }
        return bfImage;
    }

}




