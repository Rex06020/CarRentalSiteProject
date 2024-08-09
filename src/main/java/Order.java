package main.java;

class Order {
    private int orderID;
    private int memberID;
    private int detailID;
    private OrderStatus odStatus;

	enum OrderStatus {
	    COMPLETED, RENTING
	}

    public Order(int orderID, int memberID, int detailID, OrderStatus odStatus) {
        this.orderID = orderID;
        this.memberID = memberID;
        this.detailID = detailID;
        this.odStatus = odStatus;
    }

    // Getters and Setters
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public OrderStatus getOdStatus() {
        return odStatus;
    }

    public void setOdStatus(OrderStatus odStatus) {
        this.odStatus = odStatus;
    }
}

