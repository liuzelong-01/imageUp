package com.lzl.controller;

import com.lzl.common.VO.ImgReturn;
import com.lzl.common.VO.ImgVo;
import com.lzl.service.ImgData;
import com.lzl.service.Test;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.util.*;

@RestController
public class TestController {
    @Resource
    private Test test;
    @Resource
    private ImgData imgData;

    @RequestMapping("/aaa")
    public ImgReturn aaa() {
        List<ImgVo> test1 = test.test();
        return new ImgReturn(200, "查询成功", test1);

    }

    @RequestMapping("/upload")
    public ImgReturn imgUp(@RequestPart("file") MultipartFile file) throws IOException {
        String originalName = file.getOriginalFilename();
        String ext = "." + FilenameUtils.getExtension(originalName);
        String fileName = UUID.randomUUID().toString() + ext;
        URL img = TestController.class.getResource("./IMG");
        System.out.println(img);
        final String basePath = TestController.class.
                getResource("./IMG").
                getPath();

        File targetFile = new File(basePath, fileName);
        FileUtils.writeByteArrayToFile(targetFile, file.getBytes());
        ImgVo imgVo = new ImgVo();
        imgVo.setImg(basePath + "/" + fileName);
        imgVo.setRemark(originalName);
        imgData.ImgDataSave(imgVo);
        return new ImgReturn(200, "ok", null);
    }


    @RequestMapping("seeImg")
    public void seeImg(@RequestParam String remark, HttpServletResponse httpServletResponse) throws IOException {
        ImgVo vo = new ImgVo();
        vo.setRemark(remark);
        ImgVo img = imgData.ImgDataSelect(vo);
        File file = new File(img.getImg());
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        httpServletResponse.setContentType("image/png");
        OutputStream os = httpServletResponse.getOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = in.read(buff, 0, 100)) > 0) {
            os.write(buff, 0, rc);
        }
        os.flush();
    }

    @RequestMapping("lookImg")
    public ImgReturn lookImg(@RequestParam String remark) throws IOException {
        ImgVo vo = new ImgVo();
        vo.setRemark(remark);
        ImgVo img = imgData.ImgDataSelect(vo);
        File file = new File(img.getImg());
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        int available = in.available();
        byte[] bytes = new byte[available];
        in.read(bytes);
        Base64.Encoder encoder = Base64.getEncoder();
        String img64 = encoder.encodeToString(bytes);
        Map<String, Object> map = new HashMap<>(1);
        map.put("img64", img64);
        return new ImgReturn(200, "ok", map);
    }

}
