package com.camelot.atom.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.camelot.atom.service.CommonRequestLogAtomService;
import com.camelot.atom.dto.CommonRequestLogDto;
import com.camelot.atom.mapper.CommonRequestLogMapper;
import org.springframework.stereotype.Service;

/**
* <p>Description: [请求日志表 Mapper]</p>
* Created on 2022年01月21日
* @author  <a href="mailto: majianwei@camelotchina.com">majianwei</a>
* @version 1.0
* Copyright (c) 2022 北京柯莱特科技有限公司 交付部
*/
@Service
public class CommonRequestLogAtomServiceImpl extends ServiceImpl
<CommonRequestLogMapper, CommonRequestLogDto> implements CommonRequestLogAtomService {

}