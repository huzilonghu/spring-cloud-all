package com.miao.car.base.erro;


import com.miao.car.base.exception.RestfulException;

public class FieldException {

    public static void validateId(Long id){
        if (id == null || id.longValue() == 0) {
            throw new RestfulException(IErro.INVALIDE, "id不能为空");
        }
    }

    public static void validateId(Integer id){
        if (id == null || id.intValue() == 0) {
            throw new RestfulException(IErro.INVALIDE, "id不能为空");
        }
    }

    public static void validateIdsValues(long[] ids, int[] values){
        if (ids==null||values==null||ids.length==0||values.length==0){
            throw new RestfulException(IErro.INVALIDE, "id列表和值列表不能为空");
        }else if (ids.length!=values.length){
            throw new RestfulException(IErro.INVALIDE, "id列表和值列表长度必须一致");
        }
    }
}
