package dubby.serve.xfood.util.mailsender;

public interface IMailBody {

    String htmlMessageBody(String userFullName, int verificationToken);
}
