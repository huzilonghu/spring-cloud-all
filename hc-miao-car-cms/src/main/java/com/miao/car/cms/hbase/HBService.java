package com.miao.car.cms.hbase;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.RpcRetryingCaller;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xsing on 2017/10/19.
 */
@Service
public class HBService {

    @Autowired
    HbaseTemplate hbaseTemplate;

    /**
     * 通过表名和key获取一行数据
     *
     * @param tableName
     * @param rowKey
     * @return
     */
    public Map<String, Object> get(String tableName, String rowKey) {
        RpcRetryingCaller d;
        return hbaseTemplate.get(tableName, rowKey, new RowMapper<Map<String, Object>>() {

            public Map<String, Object> mapRow(Result result, int rowNum) throws Exception {
                List<Cell> ceList = result.listCells();
                Map<String, Object> map = new HashMap<String, Object>();
                if (ceList != null && ceList.size() > 0) {
                    for (Cell cell : ceList) {
                        map.put(Bytes.toString(cell.getFamilyArray(), cell.getFamilyOffset(), cell.getFamilyLength())
                                        + "_"
                                        + Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(),
                                cell.getQualifierLength()),
                                Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                    }
                }
                return map;
            }
        });
    }
}
