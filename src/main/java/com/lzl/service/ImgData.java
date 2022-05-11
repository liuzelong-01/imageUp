package com.lzl.service;

import com.lzl.common.VO.ImgVo;

import java.util.List;

public interface ImgData {
    void ImgDataSave(ImgVo img);
    ImgVo ImgDataSelect(ImgVo vo);
}
