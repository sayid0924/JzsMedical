package com.jzs.bedcard.controller;


import com.jzs.bedcard.entity.BaseApiService;
import com.jzs.bedcard.entity.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.Iterator;

@RestController
@RequestMapping("/uploadFile")
public class UploadFileController extends BaseApiService {

//    @Autowired
//    RabbitTemplate rabbitTemplate;

    @RequestMapping("/upload")
    public ResponseBase uploadPic(HttpServletRequest request, HttpServletResponse resp) {

        String key = "上传失败";
        FileInputStream fis;
        FileOutputStream fos;
        byte[] temp = new byte[1024];
        byte[] bytes = new byte[0];
        String appVersionNumber = null;
        String uploadFileName = "";
        String size = null;
        String Path = null;
        try {
            Collection<Part> parts = request.getParts();
            Iterator<Part> iterator = parts.iterator();
            while (iterator.hasNext()) {
                Part part = iterator.next();
                System.out.println("类型名称————" + part.getName());
                switch (part.getName()) {
                    case "appVersionNumber":
                        bytes = new byte[part.getInputStream().available()];
                        part.getInputStream().read(bytes);
                        appVersionNumber = new String(bytes);
                        System.out.println("appVersionNumber————" + appVersionNumber);
                        break;
                    case "name":
                        bytes = new byte[part.getInputStream().available()];
                        part.getInputStream().read(bytes);
                        uploadFileName = new String(bytes);
                        System.out.println("uploadFileName————" + uploadFileName);
                        break;
                    case "size":
                        bytes = new byte[part.getInputStream().available()];
                        part.getInputStream().read(bytes);
                        size = new String(bytes);
                        System.out.println("size————" + size);
                        break;
                    case "file":
                         Path = (String.valueOf(Thread.currentThread().getContextClassLoader().getResource("") + "static/swagger/"))
                                .replaceAll("file:/", "").replaceAll("%20", " ").trim();
                        if (Path.indexOf(":") != 1) {
                            Path = File.separator + Path;
                        }

                        String filePath = Path + "uploadFiles/uploadFiles";//自定义上传路径
                        File file = new File(filePath, uploadFileName);

                        if (!file.exists()) {//判断文件夹是否存在，如果不存在则创建
                            if (!file.getParentFile().exists()) {
                                file.getParentFile().mkdirs();
                            }
                            file.createNewFile();
                        }

                        fos = new FileOutputStream(file);
                        fis = (FileInputStream) part.getInputStream();
                        int i = fis.read(temp);
                        while (i != -1) {
                            fos.write(temp, 0, temp.length);
                            fos.flush();
                            i = fis.read(temp);
                        }
                        key = "上传成功";
                        // 发送给rabbitMQ消息队列 通知下载新的app
//                        rabbitTemplate.convertAndSend("bben.direct", "bben.upadte",new UpadteBean(Path,uploadFileName,size,appVersionNumber));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return setResultSuccess(key);
    }

}
