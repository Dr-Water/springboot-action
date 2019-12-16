package com.ratel.shiro.controller;

import com.ratel.shiro.common.utils.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @业务描述：
 * @package_name： com.ratel.shiro.com.ratel.shiro.modules.jwt.controller
 * @project_name： springboot-shiro
 * @author： ratelfu@qq.com
 * @create_time： 2019-12-12 17:15
 * @copyright (c) ratelfu 版权所有
 */
@RestController
@RequestMapping("/file")
public class FileController {



    @RequestMapping("downloadFiles")
    public void downloadFiles ( HttpServletResponse res,@RequestParam("files") MultipartFile[] files) throws IOException {
       // String zipName="test.zip";
        String zipName="test.rar";
        String zipBasePath="D:/temp/download/";
        FileUtils.downloadFiles(res,files,zipName,zipBasePath);
    }

    @RequestMapping("downloadFileList")
    public void downloadFiles ( HttpServletResponse res,@RequestParam("files") List<MultipartFile> files) throws IOException {
        // String zipName="test.zip";
        String zipName="test.rar";
        String zipBasePath="D:/temp/download/";
        MultipartFile[] files1 = (MultipartFile[])files.toArray();
        FileUtils.downloadFiles(res,files1,zipName,zipBasePath);
    }
}
