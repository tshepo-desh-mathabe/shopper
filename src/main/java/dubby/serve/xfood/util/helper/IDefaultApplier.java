package dubby.serve.xfood.util.helper;

import dubby.serve.xfood.domain.account.dto.UserDto;
import dubby.serve.xfood.util.property_fetcher.IPropertyFetcher;

public interface IDefaultApplier {

    void applyDefaults(UserDto request);
}
