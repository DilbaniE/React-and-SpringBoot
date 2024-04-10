package com.foodapp.foodapp.endPoinst;

public interface IClientEndPoint {
    String CLIENT_BASE_URL = "/client";
    String CLIENT_CREATE_URL = "";
    String CLIENT_UPDATE_URL = "/{document}/{name}";
    String CLIENT_GET_URL = "/{document}";
    String CLIENT_DESACTIVATE_URL = "/{document}";
}
