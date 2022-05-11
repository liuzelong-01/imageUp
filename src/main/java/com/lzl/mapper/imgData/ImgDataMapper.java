package com.lzl.mapper.imgData;

import com.lzl.common.VO.ImgVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImgDataMapper {
    void insertImgData(ImgVo img);
    ImgVo ImgDataSelect(ImgVo vo);
}
