package dubby.serve.xfood.util.property_fetcher;

import dubby.serve.xfood.util.constants.AppConstant;

/**
 * Property retrieval operator
 */
@FunctionalInterface
public interface IPropertyFetcher<T> {

    /**
     * gets the property value/s
     * @param keyValue - key for property
     * @return - returns value/s of property
     */
    String getProperty(T keyValue);
}
