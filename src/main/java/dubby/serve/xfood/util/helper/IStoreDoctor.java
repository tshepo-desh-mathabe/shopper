package dubby.serve.xfood.util.helper;

import dubby.serve.xfood.util.response.ApiResponse;

public interface IStoreDoctor<T> extends IService<T>{

    /**
     * Validates request before persisting
     * @param request - data received from end-point
     * @return - API response object
     */
    ApiResponse isPersistentReady(T request);
}
