package com.cphoto.utils;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class UploadFileImg {

    /**
     * 保存文件 成功返回 文件名 反之 保存失败
     * @param bytes
     * @param path
     * @return
     */
    public static String store(byte[] bytes,String path) {
       String path2 = null;
       
    
          
         
        try {
			/*  //将文件转换为字节
			 * FileInputStream fis = new FileInputStream(file); ByteArrayOutputStream bos =
			 * new ByteArrayOutputStream(); byte[] b = new byte[1024]; int len = -1;
			 * while((len = fis.read(b)) != -1) { bos.write(b, 0, len); }
			 * //toByteArray()方法得到文件的字节数组。 bytes = bos.toByteArray();
			 */
            //获取项目根目录
            //String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
            //根据时间给文件命名
            path2 = UUID.randomUUID()+".jpg";
            //创建文件
            String path3 = path+"/img/"+path2;
            //创建缩略图
            String path4 = path+"/imgs/"+path2;
            
            File file1 = new File(path+"/img/");
            File file2 = new File(path+"/imgs/");

            if(!file1.exists() || !file2.exists() ){
                file1.mkdirs();
                file2.mkdirs();
            }
            if(!file1.getParentFile().exists() || !file2.getParentFile().exists()){            
                file1.getParentFile().mkdirs();
                file2.getParentFile().mkdirs();
            }

            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(new File(path3)));
            //将字节写进文件中
            stream.write(bytes);
            stream.close();

            Boolean flag  = compressImg(path3,path4,1280,720,true);

            if(!flag){
                return "保存失败";
            }

        } catch (IOException e) {
        	e.printStackTrace();
            return "保存失败";
        }

        return path2;
    }


    /**
     * @param inputFile  源文件
     * @param outFile    生成文件
     * @param width      宽度
     * @param height     高度
     * @param proportion 是否等比例操作
     * @描述 —— 是否等比例缩放图片
     */
    public static boolean compressImg(String inputFile, String outFile,
                                      int width, int height, boolean proportion) {
        try {
            // 获得源文件
            File file = new File(inputFile);
            if (!file.exists()) {
                return false;
            }
            Image img = ImageIO.read(file);
            // 判断图片格式是否正确
            if (img.getWidth(null) == -1) {
                return false;
            } else {
                int newWidth;
                int newHeight;
                // 判断是否是等比缩放
                if (proportion == true) {
                    // 为等比缩放计算输出的图片宽度及高度
                    double rate1 = ((double) img.getWidth(null))
                            / (double) width + 0.1;
                    double rate2 = ((double) img.getHeight(null))
                            / (double) height + 0.1;
                    // 根据缩放比率大的进行缩放控制
                    double rate = rate1 > rate2 ? rate1 : rate2;
                    newWidth = (int) (((double) img.getWidth(null)) / rate);
                    newHeight = (int) (((double) img.getHeight(null)) / rate);
                } else {
                    newWidth = width; // 输出的图片宽度
                    newHeight = height; // 输出的图片高度
                }

                BufferedImage tag = new BufferedImage((int) newWidth,
                        (int) newHeight, BufferedImage.TYPE_INT_RGB);

            /*
             * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的,优先级比速度高
            生成的图片质量比较好但速度慢
             */
                tag.getGraphics().drawImage(
                        img.getScaledInstance(newWidth, newHeight,
                                Image.SCALE_SMOOTH), 0, 0, null);
                FileOutputStream out = new FileOutputStream(outFile);
                // JPEGImageEncoder可适用于其他图片类型的转换
                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
                encoder.encode(tag);
                out.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }

}
