package com.lzl.mapper.test;

import com.lzl.common.VO.ImgVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TestMapper {
    List<ImgVo> selectImgAll();
}
