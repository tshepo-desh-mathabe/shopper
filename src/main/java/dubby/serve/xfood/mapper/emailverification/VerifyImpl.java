package dubby.serve.xfood.mapper.emailverification;

import dubby.serve.xfood.domain.emailverification.Verify;
import dubby.serve.xfood.domain.emailverification.dto.VerifyDto;
import dubby.serve.xfood.util.helper.IFieldPropertyMapper;
import dubby.serve.xfood.util.helper.IModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VerifyImpl implements IModelMapper<Verify, VerifyDto> {
    
    @Override
    public Verify toEntity(VerifyDto verifyDto) {
        return convertToEntity(verifyDto);
    }

    @Override
    public VerifyDto toDto(Verify verify) {
        return convertToDto(verify);
    }

    private VerifyDto convertToDto(Verify verify) {
        if (verify != null) {
            IFieldPropertyMapper<VerifyDto> mapper = destination -> {
                destination.setCreatedByUserId(verify.getCreatedBy());
                destination.setCreatedAtDate(verify.getCreatedAt());
                destination.setVerificationToken(verify.getToken());

                return destination;
            };

            return mapper.mapTo(new VerifyDto());
        } else {
            return null;
        }
    }
    
    private Verify convertToEntity(VerifyDto verifyDto) {
        if (verifyDto != null) {
            IFieldPropertyMapper<Verify> mapper = destination -> {
                destination.setCreatedBy(verifyDto.getCreatedByUserId());
                destination.setCreatedAt(verifyDto.getCreatedAtDate());
                destination.setToken(String.valueOf(verifyDto.getVerificationToken()));

                return destination;
            };

            return mapper.mapTo(new Verify());
        } else {
            return null;
        }
    }
}
