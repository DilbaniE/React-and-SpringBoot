package com.foodapp.foodapp.endPoinst;

public interface IOrderEndPoint {
    String ORDER_BASE_URL = "/orders";
    String ORDER_CREATE_URL = "";
    String ORDER_UPDATE_URL = "/{uuid}/delivered/{timestamp}";

}
