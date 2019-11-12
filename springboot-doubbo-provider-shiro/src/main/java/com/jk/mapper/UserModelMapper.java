package com.jk.mapper;


import com.jk.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserModelMapper {


    User queryUserByName( String username);


}
