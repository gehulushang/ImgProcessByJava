import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Main {


    public static void main(String[] args) {
        BufferedImage image;
        String imagePath = "F:\\毕业论文\\新建文件夹\\分子结构.jpg";
        String path = "F:\\毕业论文\\新建文件夹\\分子结构3.jpg";
        PixelTraversal pixelTraversal = new PixelTraversal();
        try{
            pixelTraversal.transform(imagePath, path );
        }catch (Exception e){
            e.printStackTrace();
        }

        //System.out.println("Hello World!");
    }
}
