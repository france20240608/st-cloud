package com.st.cloud.agent.pojo.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.st.cloud.agent.pojo.vo.MemberUserVO;
import com.st.cloud.module.user.dto.MemberUserRespDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MemberUserVOConvert {

    MemberUserVOConvert INSTANCE = Mappers.getMapper(MemberUserVOConvert.class);

    /********************** VO -> DTO ***********************/
    MemberUserVO convert(MemberUserRespDTO bean);

    List<MemberUserVO> convert(List<MemberUserRespDTO> list);

    Page<MemberUserVO> convert(Page<MemberUserRespDTO> page);
}
