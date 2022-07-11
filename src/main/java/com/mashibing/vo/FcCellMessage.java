package com.mashibing.vo;

public class FcCellMessage {
    /**
     * unitCode 单元编号
     */
    private String unitCode;
    /**
     * startFloor 开始楼层
     */
    private Integer startFloor;
    /**
     * stopFloor 结束楼层
     */
    private Integer stopFloor;
    /**
     * startCellId 开始编号
     */
    private Integer startCellId;
    /**
     * stopCellId 结束编号
     */
    private Integer stopCellId;

    @Override
    public String toString() {
        return "FcCellMessage{" +
                "unitCode='" + unitCode + '\'' +
                ", startFloor=" + startFloor +
                ", stopFloor=" + stopFloor +
                ", startCellId=" + startCellId +
                ", stopCellId=" + stopCellId +
                '}';
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public Integer getStartFloor() {
        return startFloor;
    }

    public void setStartFloor(Integer startFloor) {
        this.startFloor = startFloor;
    }

    public Integer getStopFloor() {
        return stopFloor;
    }

    public void setStopFloor(Integer stopFloor) {
        this.stopFloor = stopFloor;
    }

    public Integer getStartCellId() {
        return startCellId;
    }

    public void setStartCellId(Integer startCellId) {
        this.startCellId = startCellId;
    }

    public Integer getStopCellId() {
        return stopCellId;
    }

    public void setStopCellId(Integer stopCellId) {
        this.stopCellId = stopCellId;
    }

    public FcCellMessage() {
    }

    public FcCellMessage(String unitCode, Integer startFloor, Integer stopFloor, Integer startCellId, Integer stopCellId) {
        this.unitCode = unitCode;
        this.startFloor = startFloor;
        this.stopFloor = stopFloor;
        this.startCellId = startCellId;
        this.stopCellId = stopCellId;
    }
}
