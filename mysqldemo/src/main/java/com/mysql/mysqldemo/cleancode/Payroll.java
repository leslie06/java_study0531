package com.mysql.mysqldemo.cleancode;

import lombok.var;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author leslie
 * @Date 2022/11/8 13:53
 **/
public class Payroll {
    public static class RichNode{
        public List<RichNode> getNodeList() {
            return nodeList;
        }

        public void setNodeList(List<RichNode> nodeList) {
            this.nodeList = nodeList;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public RichNode(List<RichNode> nodeList, String value) {
            this.nodeList = nodeList;
            this.value = value;
        }

        public List<RichNode> nodeList;
        public String value;
    }



    public List<String> ExtractRichNodeValue(RichNode richNode){
        List<String> richNodeValueList = richNode.getNodeList().stream()
                .map(RichNode::getValue)
                .collect(Collectors.toList());
        return richNodeValueList;
    }

}
