package com.foodapp.foodapp.endPoinst;

public interface IProductEndPoint {
    String PRODUCT_BASE_URL = "/products";
    String PRODUCT_CREATE_URL = "";
    String PRODUCT_DESACTIVATE_URL = "/{uuid}";
    String PRODUCT_UPDATE_URL = "/{uuid}";
    String PRODUCT_GET_URL = "/{uuid}";
}
