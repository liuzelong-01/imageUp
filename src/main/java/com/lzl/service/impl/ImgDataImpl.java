package com.lzl.service.impl;

import com.lzl.common.VO.ImgVo;
import com.lzl.mapper.imgData.ImgDataMapper;
import com.lzl.service.ImgData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ImgDataImpl implements ImgData {
    @Resource
    private ImgDataMapper imgDataMapper;

    @Override
    public void ImgDataSave(ImgVo img) {
        imgDataMapper.insertImgData(img);
    }

    @Override
    public ImgVo ImgDataSelect(ImgVo vo) {
        return imgDataMapper.ImgDataSelect(vo);

    }
}
