import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PixelTraversal {
    /**
     * @param imagePath 要遍历图像的名字
     * @param path 新生成的图像的名字
     *
     */
    // 该方法可以将近似于白色的像素的全部置换为白色
    // 该方法可以达到一定的去除水印的效果
    // 但是实际使用时还有一些接近白色的像素没被替换
    public void transform(String imagePath, String path) throws   Exception {
        BufferedImage image;

        int[] rgb = new int[3];
        try {
            image = ImageIO.read(new File(imagePath));

            //输出图片大小
            System.out.println(image.getHeight() + "    " + image.getWidth());
            for (int y = image.getMinY(); y < image.getHeight(); y++) {
                for (int x = image.getMinX(); x < image.getWidth(); x++) {
                    int pixel = image.getRGB(x, y);

                    rgb[0] = (pixel & 0xff0000) >> 16; //r
                    rgb[1] = (pixel & 0xff00) >> 8; //g
                    rgb[2] = (pixel & 0xff); //b
                    // 如果像素值接近纯白色，直接将像素赋值为白色
                    // 可以通过设置具体的值控制像素替换的范围
                    if (rgb[0] >= 225 && rgb[1] >= 225 && rgb[2] >= 225) {

                        image.setRGB(x, y, -1);
                    } else {
                        image.setRGB(x, y, pixel);
                    }
                }
            }
            try {
                ImageIO.write(image, "jpg", new File(path));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
     // 添加一个参数，该参数表示处理图片的格式
    public void transform(String format, String imagePath, String path) throws   Exception {
        BufferedImage image;

        int[] rgb = new int[3];
        try {
            image = ImageIO.read(new File(imagePath));

            //输出图片大小
            System.out.println(image.getHeight() + "    " + image.getWidth());
            for (int y = image.getMinY(); y < image.getHeight(); y++) {
                for (int x = image.getMinX(); x < image.getWidth(); x++) {
                    int pixel = image.getRGB(x, y);

                    rgb[0] = (pixel & 0xff0000) >> 16; //r
                    rgb[1] = (pixel & 0xff00) >> 8; //g
                    rgb[2] = (pixel & 0xff); //b
                    // 如果像素值接近纯白色，直接将像素赋值为白色
                    // 可以通过设置具体的值控制像素替换的范围
                    if (rgb[0] >= 200 && rgb[1] >= 200 && rgb[2] >= 200) {

                        image.setRGB(x, y, -1);
                    } else {
                        image.setRGB(x, y, pixel);
                    }
                }
            }
            try {
                ImageIO.write(image, format, new File(path));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
    

}
