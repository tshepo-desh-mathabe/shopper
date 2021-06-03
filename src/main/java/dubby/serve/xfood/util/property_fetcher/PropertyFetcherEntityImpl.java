package dubby.serve.xfood.util.property_fetcher;

import dubby.serve.xfood.util.constants.EntityConstant;
import org.springframework.beans.factory.annotation.Value;

@Deprecated
public class PropertyFetcherEntityImpl implements IPropertyFetcher<EntityConstant> {
    @Value("${entity.table.name.account-enabled}")
    private String accountEnabled;

    @Override
    public String getProperty(EntityConstant keyValue) {
        return switch (keyValue) {
            case ACCOUNT_ENABLED -> accountEnabled;
        };
    }
}
