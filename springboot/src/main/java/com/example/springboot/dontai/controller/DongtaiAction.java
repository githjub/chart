package com.example.springboot.dontai.controller;

import com.example.springboot.util.JsonResultBean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @program: springboot
 * @description:
 * @author: llz
 * @date: 2021/8/16 22:32
 */
@RequestMapping("/DongtaiAction")
@RestController
@Component
public class DongtaiAction {

    @RequestMapping("/uploadImg")
    public JsonResultBean uploadImg(HttpServletRequest request, @RequestParam("photo") MultipartFile file){
        System.out.println("upload方法被调用");
        JsonResultBean jsonResultBean = new JsonResultBean();
        String filePath = request.getServletContext().getRealPath("/upload");
        System.out.println("传递图片保存的http路径: "+filePath);
        File f = new File(filePath);
        if (!f.exists()) f.mkdirs();//创建目录
        try {
            file.transferTo(new File(f,file.getOriginalFilename()));
            jsonResultBean.setCode(0);
            jsonResultBean.setMsg("图片上传成功");
            //http:192.168.135.38:8080/upload/xxx.png
//            jsonResultBean.setData("http:192.168.213.38:8888/upload/"+file.getOriginalFilename());//传递图片保存的http路径
            jsonResultBean.setData("http:127.0.0.1:8888/upload/"+file.getOriginalFilename());//传递图片保存的http路径
        } catch (IOException e) {
            e.printStackTrace();
            jsonResultBean.setCode(1);
            jsonResultBean.setMsg("图片上传失败");
        }
        return jsonResultBean;
    }
}
