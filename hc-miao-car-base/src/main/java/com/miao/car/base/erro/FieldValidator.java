package com.miao.car.base.erro;



import com.miao.car.base.common.base.BaseDto;
import com.miao.car.base.entity.ErrorEntity;
import com.miao.car.base.exception.RestfulException;

import org.apache.commons.lang3.StringUtils;


public class FieldValidator {

    public static final String ERRO_TAG = "FIELD_VALIDATOR";

    private ErrorEntity errorEntity;

    public FieldValidator() {

    }

    public FieldValidator(ErrorEntity entity) {
        this.errorEntity = entity;
    }

    public static FieldValidator instance(){
        return new FieldValidator();
    }

    public static FieldValidator instance(ErrorEntity entity){
        return new FieldValidator(entity);
    }

    public FieldValidator validatedField(CharSequence obj, String message) {
        if (StringUtils.isBlank(obj)) {
            if (errorEntity == null) {
                errorEntity = new ErrorEntity();
                errorEntity.setStatusCode(ERRO_TAG);
            }
            errorEntity.addMessage(message);
        }
        return this;
    }


    public FieldValidator validatedField(Object obj, String message) {
        if (obj == null) {
            if (errorEntity == null) {
                errorEntity = new ErrorEntity();
                errorEntity.setStatusCode(ERRO_TAG);
            }
            errorEntity.addMessage(message);
        }
        return this;
    }

    public FieldValidator validatedField(Ivalidate condition, String message) {
        if (condition.validate()) {
            if (errorEntity == null) {
                errorEntity = new ErrorEntity();
                errorEntity.setStatusCode(ERRO_TAG);
            }
            errorEntity.addMessage(message);
        }
        return this;
    }

    public ErrorEntity validate() {
        if (errorEntity!=null){
            throw new RestfulException(errorEntity);
        }
        return errorEntity;
    }


    public static void ValidateDto(BaseDto dto){
        if (dto == null) {
            throw new RestfulException("NULL", "参数为空");
        }
        //参数为空检查
        ErrorEntity validate = dto.validate();
        if (validate != null) {
            throw new RestfulException(validate);
        }
    }

    public interface Ivalidate {
        boolean validate();
    }
}
