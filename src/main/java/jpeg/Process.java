package jpeg;

import Jama.Matrix;
import enums.ColorType;
import graphics.Dialogs;

import java.awt.*;
import java.awt.image.BufferedImage;

import static enums.ColorType.*;


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

    public Process(String path) {

        this.originalImage = Dialogs.loadImageFromPath(path);

        imageWidth = originalImage.getWidth();
        imageHeight = originalImage.getHeight();

        originalRed = new int[imageHeight][imageWidth];
        originalGreen = new int[imageHeight][imageWidth];
        originalBlue = new int[imageHeight][imageWidth];

        originalY = new Matrix(imageHeight, imageWidth);
        originalCb = new Matrix(imageHeight, imageWidth);
        originalCr = new Matrix(imageHeight, imageWidth);
        setOriginalRGB();
    }


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
    
    public void convertToYCbCr() {

        Matrix[] temp = ColorTransform.convertOriginalRGBtoYcBcR(originalRed, originalGreen, originalBlue);
        originalY = temp[0];
        originalCb = temp[1];
        originalCr = temp[2];
        
    }

    public void convertToRGB()
    {
        int[][][] temp = ColorTransform.convertModifiedYcBcRtoRGB(originalY, originalCb, originalCr);
        modifiedRed = temp[0];
        modifiedGreen = temp[1];
        modifiedBlue = temp[2];
    }


    public BufferedImage showOneColorImageFromRGB(int[][] color, ColorType type) {

        BufferedImage bfImage = new BufferedImage(
                imageWidth, imageWidth, BufferedImage.TYPE_INT_RGB);
        for (int h = 0; h < imageHeight; h++) {
            for (int w = 0; w < imageWidth; w++) {
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
                imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);

        double [][] colorOrigin = color.getArray();
        for (int h = 0; h < imageHeight; h++) {
            for (int w = 0; w < imageWidth; w++) {
                bfImage.setRGB(w,h,
                        (new Color((int)color.get(h,w),
                                (int)color.get(h,w),
                                (int)color.get(h,w)).getRGB()));
            }
        }
        return bfImage;
    }



    public BufferedImage showOrigBlue()
    {
        return showOneColorImageFromRGB(originalBlue, BLUE);
    }
    public BufferedImage showOrigGreen()
    {
        return showOneColorImageFromRGB(originalGreen, GREEN);
    }
    public BufferedImage showOrigRed()
    {
        return showOneColorImageFromRGB(originalRed,  RED);
    }
    public BufferedImage showModifBlue()
    {
        return showOneColorImageFromRGB(modifiedBlue, BLUE);
    }
    public BufferedImage showModifGreen()
    {
        return showOneColorImageFromRGB(modifiedGreen, GREEN);
    }
    public BufferedImage showModifRed()
    {
        return showOneColorImageFromRGB(modifiedRed,  RED);
    }
    public BufferedImage showOrigY()
    {
        return  showOneColorFromYCbCr(originalY);
    }
    public BufferedImage showModifY()
    {
        return  showOneColorFromYCbCr(originalY);
    }
    public BufferedImage showOrigCb()
    {
        return  showOneColorFromYCbCr(originalCb);
    }
    public BufferedImage showModifCb()
    {
        return  showOneColorFromYCbCr(originalCb);
    }
    public BufferedImage showOrigCr()
    {
        return  showOneColorFromYCbCr(originalCr);
    }
    public BufferedImage showModifCr()
    {
        return  showOneColorFromYCbCr(originalCr);
    }

}




