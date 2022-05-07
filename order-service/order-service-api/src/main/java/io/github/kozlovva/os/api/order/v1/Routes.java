package io.github.kozlovva.os.api.order.v1;

public class Routes {
    public static final String ROOT = "/api/v1/orders";
    public static final String CANCEL = ROOT + "/{id}/cancel";
    public static final String PAY = ROOT + "/{id}/pay";
}
