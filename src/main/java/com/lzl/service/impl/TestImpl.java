package com.lzl.service.impl;

import com.lzl.common.VO.ImgVo;
import com.lzl.mapper.test.TestMapper;
import com.lzl.service.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestImpl implements Test {
    @Resource
    private TestMapper mapper;

    @Override
    public List<ImgVo> test() {
        List<ImgVo> imgAll = mapper.selectImgAll();

        return imgAll;
    }
}
