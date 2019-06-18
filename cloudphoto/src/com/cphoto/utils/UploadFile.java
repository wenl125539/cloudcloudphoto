package com.cphoto.utils;


import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;





public class UploadFile {

    /**
     * 保存文件 成功返回 文件名 反之 保存失败
     * @param bytes
     * @param path 	String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
     * @return
     */
    public static String store(byte[] bytes,String path) {
       String path2 = null;
           
        
        UUID uid = UUID.randomUUID();
        try {
        	 //将文件转换为字节
			/*
			 * FileInputStream fis = new FileInputStream(file); ByteArrayOutputStream bos =
			 * new ByteArrayOutputStream(); byte[] b = new byte[1024]; int len = -1;
			 * while((len = fis.read(b)) != -1) { bos.write(b, 0, len); }
			 * //toByteArray()方法得到文件的字节数组。 bytes = bos.toByteArray();
			 */
            
            //获取项目根目录
        
            System.out.println(path);
            
            path2 = uid+".mp4";
            //创建文件
            File file2 = new File(path+"/mp4/");
            if(!file2.exists()) {
            	file2.mkdirs();
            }
            //创建文件
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(new File(file2,path2)));
            //将字节写进文件中
            stream.write(bytes);
            stream.close();

            getTempPath(path+"/mp4s/"+uid+".jpg",path+"/mp4/"+path2);

            System.out.println(path+"static/mp4/"+path2);

        } catch (Exception e) {
            return "保存失败";
        }
        System.out.println(path2);
        return uid.toString();
    }

    /**
     *
     * @param fileOut 保存路径
     * @param fileIn    MP4文件路径
     * @return
     */
    public static Boolean getTempPath(String fileOut,String fileIn) {
        Boolean flag1 = false;
        String tempPath = fileOut;//保存的目标路径
        File targetFile = new File(tempPath);
        if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdirs();
        }
        try {
            File file2 = new File(fileIn);
            if (file2.exists()) {
                System.out.println("文件存在");
                FFmpegFrameGrabber ff = new FFmpegFrameGrabber(file2);
                ff.start();
                int ftp = ff.getLengthInFrames();
                int flag = 0;
                Frame frame = null;
                while (flag <= ftp) {
                    //获取帧
                    frame = ff.grabImage();
                    //过滤前3帧，避免出现全黑图片
                    if ((flag > 5) && (frame != null)) {
                        break;
                    }
                    flag++;
                }
                ImageIO.write(FrameToBufferedImage(frame), "jpg", targetFile);
                ff.close();
                ff.stop();
            }else{
                flag1 = false;
            }
        } catch (Exception e) {
            System.out.println("获取预览图失败");

        }
        return flag1;
    }
    private static RenderedImage FrameToBufferedImage(Frame frame) {
        //创建BufferedImage对象
        Java2DFrameConverter converter = new Java2DFrameConverter();
        BufferedImage bufferedImage = converter.getBufferedImage(frame);
        return bufferedImage;
    }
}
