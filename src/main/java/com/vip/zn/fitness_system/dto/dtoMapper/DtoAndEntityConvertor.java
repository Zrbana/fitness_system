package com.vip.zn.fitness_system.dto.dtoMapper;

import com.vip.zn.fitness_system.db.entity.*;
import com.vip.zn.fitness_system.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.jmx.export.annotation.ManagedAttribute;

import javax.jws.soap.SOAPBinding;

/**
 * @ClassName DtoConvertor
 * @Description TODO
 * @Author na.zhao
 * @Date 2021/4/22 12:39
 */

@Mapper
public interface DtoAndEntityConvertor {

    DtoAndEntityConvertor INSTANCE = Mappers.getMapper(DtoAndEntityConvertor.class);

    @Mappings({
            @Mapping(source = "courseName",target = "courseName"),
            @Mapping(source = "courseBeginTime",target = "courseBeginTime"),
            @Mapping(source = "courseEndTime",target = "courseEndTime"),
            @Mapping(source = "teacherId",target = "teacherId")
    })
    CourseDto entity2CourseDto(Course course);

    @Mappings({
            @Mapping(source = "username",target = "userName"),
            @Mapping(source = "password",target = "password")
    })
    AccountDto entity2AccountDto(Account account);


    @Mappings({
             @Mapping(source = "placeName",target = "placeName"),
            @Mapping(source = "status",target = "status")
    })
    SiteDto entity2SiteDto(Place place);

    @Mappings({
            @Mapping(source = "teacherId",target = "teacherId"),
            @Mapping(source = "teacherName",target = "teacherName"),
            @Mapping(source = "phoneNumber",target = "phoneNumber"),
            @Mapping(source = "status",target = "status")
    })
    TeacherDto entity2TeacherDto(Teacher teacher);

    @Mappings({
            @Mapping(source = "name",target = "name"),
            @Mapping(source = "gender",target = "gender"),
            @Mapping(source = "beginTime",target = "beginTime"),
            @Mapping(source = "endTime",target = "endTime"),
            @Mapping(source = "cardType",target = "cardType"),
            @Mapping(source = "phoneNumber",target = "phoneNumber"),
            @Mapping(source = "cardNum",target = "cardNum"),
            @Mapping(source = "isExpired",target = "isExpired")
    })
    UserDto entity2UserDto(User user);

    @Mappings({
            @Mapping(source = "name",target = "name"),
            @Mapping(source = "gender",target = "gender"),
            @Mapping(source = "beginTime",target = "beginTime"),
            @Mapping(source = "endTime",target = "endTime"),
            @Mapping(source = "cardType",target = "cardType"),
            @Mapping(source = "phoneNumber",target = "phoneNumber"),
            @Mapping(source = "cardNum",target = "cardNum"),
            @Mapping(source = "isExpired",target = "isExpired")
    })
    User Dto2UserEntity(UserDto userDto);
}




