package dubby.serve.xfood.service.util;

import dubby.serve.xfood.domain.emailverification.Verify;
import dubby.serve.xfood.domain.emailverification.dto.VerifyDto;
import dubby.serve.xfood.repository.emailverification.IVerifyRepository;
import dubby.serve.xfood.util.constants.AppConstant;
import dubby.serve.xfood.util.generators.TokenGenerator;
import dubby.serve.xfood.util.helper.IModelMapper;
import dubby.serve.xfood.util.helper.IStoreDoctor;
import dubby.serve.xfood.util.mailsender.EmailUtil;
import dubby.serve.xfood.util.mailsender.IMailBody;
import dubby.serve.xfood.util.property_fetcher.IPropertyFetcher;
import dubby.serve.xfood.util.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.time.LocalDateTime;

@Component
//@Qualifier("verifyServiceImpl")
public class VerifyServiceImpl implements IStoreDoctor<VerifyDto> {

    @Autowired
    private IVerifyRepository verifyRepository;
    @Autowired
    private IModelMapper<Verify, VerifyDto> modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailUtil emailUtil;
    @Autowired
    private IMailBody registrationMailBody;
    @Autowired
    private IPropertyFetcher propertyFetcher;

    @Override
    public void storeData(VerifyDto request) {
        if (isPersistentReady(request).getSuccess()) {
            beforeSave(request);
            registrationMail(request);
            request.setVerificationToken(passwordEncoder.encode(request.getVerificationToken()));
            request.setVerificationToken(request.getVerificationToken());
            request.setCreatedByUserId(request.getCreatedByUserId());
            verifyRepository.save(modelMapper.toEntity(request));
        }
    }

    @Override
    public void deleteData(String token) {
        verifyRepository.findByToken(token).ifPresent(e -> {
            verifyRepository.delete(e);
        });
    }

    @Override
    public ApiResponse isPersistentReady(VerifyDto request) {
        if (request.getEmailAddress() == null) {
            return new ApiResponse(false);
        } else if (request.getFullName() == null) {
            return new ApiResponse(false);
        } else {
            return new ApiResponse(true);
        }
    }

    private void beforeSave(VerifyDto verify) {
        var tokenGenerator = new TokenGenerator();
        var token = tokenGenerator.getGeneratedToken();
        verify.setCreatedAtDate(LocalDateTime.now());
        verify.setVerificationToken(String.valueOf(token));
    }

    private void registrationMail(VerifyDto body) {
        String subject = propertyFetcher.getProperty(AppConstant.USER_REGISTRATION_SUBJECT);
        String htmlBody = registrationMailBody.htmlMessageBody(body.getFullName(), Integer.parseInt(body.getVerificationToken()));
        try {
            emailUtil.sendMail(body.getEmailAddress(), subject, htmlBody);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
