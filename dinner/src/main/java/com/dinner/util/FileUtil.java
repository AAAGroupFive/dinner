package com.dinner.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * className:FileUtil
 * discriptoin:
 * author:邢芳彬
 * createTime:2018-11-23 13:58
 */
public class FileUtil {

    /**
     * 通用上传方法
     * @param savePath
     * @param file
     * @return
     */
    public static String uploadFile(String savePath, MultipartFile file){
        //获取原文件名称
        String originalFilename = file.getOriginalFilename();//1.jpg
        //获取原文件名称后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));//.jpg
        //组装新名称
        String newFileName = UUID.randomUUID()+suffix;//随机串.jpg

        //创建文件
        File newFile  =new File(savePath, newFileName);//D:/images/随机串.jpg
       /* if(!file.exists()){
            file.mkdirs();//创建父目录
        }*/
        try {
            //文件读写
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFileName;
    }

    /**
     * 通用下载方法
     * @param savePath
     * @param fileName
     * @param response
     * @return
     */
    public static String downloadFile(String savePath,String fileName, HttpServletResponse response) {
       // String fileName = "aim_test.txt";// 设置文件名，根据业务需要替换成要下载的文件名
        if (fileName != null) {
            //设置文件路径   savePath ="d:/images/"   file ="d:/images/1.jpg"
            File file = new File(savePath , fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开 MIME
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                  /* int i=0;
                   while((i=bis.read(buffer))!=-1){
                       os.write(buffer, 0, i);
                   }*/
                   // System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

}
