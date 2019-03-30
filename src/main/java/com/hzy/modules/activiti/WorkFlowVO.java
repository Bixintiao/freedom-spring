package com.hzy.modules.activiti;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2018年12月08日
 * @project freedom_spring
 * @description
 * @Modification Date:2018年12月08日 {填写修改说明}
 */
public class WorkFlowVO {


    private String assignee;         //委托人
    private String approveStatus;   //审批状态
    private String comment;          //内容，备注

    public WorkFlowVO() {
    }

    public WorkFlowVO(String assignee, String approveStatus, String comment) {
        this.assignee = assignee;
        this.approveStatus = approveStatus;
        this.comment = comment;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
