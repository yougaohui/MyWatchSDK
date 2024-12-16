package com.legend.mywatch.sdk.mywatchsdklib.android.event;

/**
 * 产品信息返回事件;主要用于显示产品图
 */
public class ProductInfoEvent extends BaseEvent {

    private String productInfo;//产品信息
    private String productType;//产品型号

    public ProductInfoEvent(String productInfo, String productType) {
        this.productInfo = productInfo;
        this.productType = productType;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public String getProductType() {
        return productType;
    }

    @Override
    public String toString() {
        return "ProductInfoModel{" + ", productInfo='" + productInfo + '\'' + ", productType='" + productType + '\'' + '}';
    }
}
